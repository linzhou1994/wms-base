package com.wms.base.service.service.warehouse.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.api.dto.warehouse.LoginWarehouseDTO;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.base.service.dao.warehouse.WarehouseMapper;
import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;
import com.wms.base.service.model.dto.warehouse.WarehouseDTO;
import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.model.entity.warehouse.WarehouseEntity;
import com.wms.base.service.model.entity.warehouse.WarehouseUserRelaEntity;
import com.wms.base.service.model.enums.company.CompanyStatusEnum;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.redis.RedisCacheKeyEnum;
import com.wms.base.service.model.enums.warehouse.WarehouseStatusEnum;
import com.wms.base.service.model.param.warehouse.CreateWarehouseParam;
import com.wms.base.service.service.company.CompanyService;
import com.wms.base.service.service.warehouse.WarehouseService;
import com.wms.base.service.service.warehouse.WarehouseUserRelaService;
import com.wms.singlesignonapi.utils.LoginUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.*;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 18:04
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Autowired
    private WarehouseUserRelaService warehouseUserRelaService;
    @Autowired
    private CompanyService companyService;
    @Autowired
    private WarehouseMapper warehouseMapper;
    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    @Transactional
    public Long createWarehouse(CreateWarehouseParam createWarehouseParam) throws BizException {
        checkCreateWarehouseParam(createWarehouseParam);
        WarehouseEntity entity = doCreateWarehouse(createWarehouseParam);
        return entity.getId();
    }


    @Override
    public List<GetWarehouseListDTO> getWarehouseListDTO() throws BizException {
        //获取当前用户绑定的所有仓库
        List<WarehouseUserRelaEntity> warehouseUserRelaEntities = warehouseUserRelaService.getBandWarehouseIds();

        List<Long> companyIds = warehouseUserRelaEntities.stream()
                .map(WarehouseUserRelaEntity::getCompanyId)
                .distinct()
                .collect(Collectors.toList());

        List<Long> warehouseIds = warehouseUserRelaEntities.stream()
                .map(WarehouseUserRelaEntity::getWarehouseId)
                .collect(Collectors.toList());

        List<CompanyEntity> companyEntities = companyService.getCompanyByIds(companyIds)
                .stream()
                .filter(o -> Objects.equals(o.getCompanyStatus(), CompanyStatusEnum.ALLOW_LOGIN.getCode()))
                .collect(Collectors.toList());

        Map<Long, List<WarehouseEntity>> companyId2warehouse = getWarehouseByIds(warehouseIds)
                .stream()
                .filter(o -> Objects.equals(o.getWarehouseStatus(), CompanyStatusEnum.ALLOW_LOGIN.getCode()))
                .collect(Collectors.groupingBy(WarehouseEntity::getCompanyId));


        List<GetWarehouseListDTO> rlt = new ArrayList<>(companyEntities.size());
        for (CompanyEntity companyEntity : companyEntities) {
            GetWarehouseListDTO dto = new GetWarehouseListDTO();
            dto.setCompanyId(companyEntity.getId());
            dto.setCompanyName(companyEntity.getCompanyName());
            List<WarehouseEntity> warehouseEntities = companyId2warehouse.get(companyEntity.getId());
            dto.setWarehouseList(BeanCopy.copyList(warehouseEntities, WarehouseDTO.class));
        }


        return rlt;
    }

    @Override
    public void chooseWarehouse(Long warehouseId) throws BizException {
        String ticket = LoginUtil.getLoginContext().getTicket();
        List<Long> warehouseIds = warehouseUserRelaService.getBandWarehouseIds()
                .stream()
                .map(WarehouseUserRelaEntity::getWarehouseId)
                .distinct()
                .collect(Collectors.toList());
        AssertUtil.isTrue(warehouseIds.contains(warehouseId), WmsBaseErrorCodeEnum.USER_IS_NOT_WAREHOUSE_STAFF);
        WarehouseEntity warehouse = getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);
        AssertUtil.isEquals(warehouse.getWarehouseStatus(), WarehouseStatusEnum.ALLOW_LOGIN.getCode(), WmsBaseErrorCodeEnum.WAREHOUSE_IS_FREEZE);

        refreshChooseWarehouse(warehouseId, ticket);
    }

    @Override
    public LoginWarehouseDTO getLoginWarehouseDTO() throws BizException {
        String ticket = LoginUtil.getLoginContext().getTicket();
        String redisKey = RedisCacheKeyEnum.LOGIN_WAREHOUSE_TICKET_CACHE.getKey(ticket);
        Long warehouseId = redisTemplate.boundValueOps(redisKey).get();
        if (Objects.isNull(warehouseId)) {
            return null;
        }
        WarehouseEntity warehouse = getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);
        AssertUtil.isEquals(warehouse.getWarehouseStatus(), WarehouseStatusEnum.ALLOW_LOGIN.getCode(), WmsBaseErrorCodeEnum.WAREHOUSE_IS_FREEZE);
        return BeanCopy.copy(warehouse, LoginWarehouseDTO.class);
    }

    @Override
    public List<WarehouseEntity> getWarehouseByIds(List<Long> warehouseIds) {
        if (CollectionUtils.isEmpty(warehouseIds)) {
            return Collections.emptyList();
        }
        return warehouseMapper.selectByIds(warehouseIds);
    }


    @Override
    public WarehouseEntity getWarehouseById(Long warehouseId) {
        if (Objects.isNull(warehouseId) || warehouseId <= 0L) {
            return null;
        }
        return warehouseMapper.selectByPrimaryKey(warehouseId);
    }

    /**
     * 刷新选择企业的过期时间
     *
     * @param warehouseId
     * @param ticket
     */
    private void refreshChooseWarehouse(Long warehouseId, String ticket) {
        String redisKey = RedisCacheKeyEnum.LOGIN_WAREHOUSE_TICKET_CACHE.getKey(ticket);
        redisTemplate.boundValueOps(redisKey)
                .set(warehouseId, RedisCacheKeyEnum.LOGIN_WAREHOUSE_TICKET_CACHE.getTimeout(), TimeUnit.HOURS);
    }


    /**
     * 创建仓库
     *
     * @param createWarehouseParam
     * @return
     * @throws BizException
     */
    private WarehouseEntity doCreateWarehouse(CreateWarehouseParam createWarehouseParam) throws BizException {
        WarehouseEntity entity = BeanCopy.copy(createWarehouseParam, WarehouseEntity.class);
        entity.setWarehouseStatus(WarehouseStatusEnum.ALLOW_LOGIN.getCode());
        entity.setCreateId(LoginWarehouseUtils.getUserId());
        entity.setCompanyId(LoginWarehouseUtils.getLoginCompanyId());
        warehouseMapper.insertSelective(entity);
        return entity;
    }

    /**
     * 校验创建仓库的参数
     *
     * @param createWarehouseParam
     * @throws BizException
     */
    private void checkCreateWarehouseParam(CreateWarehouseParam createWarehouseParam) throws BizException {
        AssertUtil.isNotBlank(createWarehouseParam.getWarehouseName(), WmsBaseErrorCodeEnum.WAREHOUSE_NAME_IS_NOT_BLANK);
        AssertUtil.isNotBlank(createWarehouseParam.getWarehouseCode(), WmsBaseErrorCodeEnum.WAREHOUSE_CODE_IS_NOT_BLANK);
        WarehouseEntity warehouse = warehouseMapper.selectByWarehouseCode(createWarehouseParam.getWarehouseCode());
        AssertUtil.isNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_CODE_EXISTS);
    }

}
