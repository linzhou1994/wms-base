package com.wms.base.service.service.warehouse.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.base.service.dao.warehouse.WarehouseUserRelaMapper;
import com.wms.base.service.model.entity.warehouse.WarehouseEntity;
import com.wms.base.service.model.entity.warehouse.WarehouseUserRelaEntity;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.rela.RelaStatusEnum;
import com.wms.base.service.model.enums.warehouse.WarehouseStatusEnum;
import com.wms.base.service.service.company.CompanyUserRelaService;
import com.wms.base.service.service.warehouse.WarehouseService;
import com.wms.base.service.service.warehouse.WarehouseUserRelaService;
import com.wms.singlesignonapi.utils.LoginUtil;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-27 11:40
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class WarehouseUserRelaServiceImpl implements WarehouseUserRelaService {
    @Autowired
    private WarehouseUserRelaMapper warehouseUserRelaMapper;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private CompanyUserRelaService companyUserRelaService;

    @Override
    public List<WarehouseUserRelaEntity> getBandWarehouseIds() throws BizException {
        Long userId = LoginUtil.getUserId();
        return warehouseUserRelaMapper.selectByUserId(userId)
                .stream()
                .filter(o -> Objects.equals(o.getStatus(), RelaStatusEnum.ALLOW_LOGIN.getCode()))
                .collect(Collectors.toList());
    }

    @Override
    public void bandWarehouseUser(Long warehouseId, List<Long> userIds) throws BizException {
        AssertUtil.isNotEmpty(userIds, WmsBaseErrorCodeEnum.WAREHOUSE_USER_IDS_IS_NOT_NULL);
        WarehouseEntity warehouse = warehouseService.getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);
        AssertUtil.isEquals(warehouse.getWarehouseStatus(), WarehouseStatusEnum.ALLOW_LOGIN.getCode(), WmsBaseErrorCodeEnum.WAREHOUSE_IS_FREEZE);
        //获取已经绑定过的员工，修改绑定状态
        List<WarehouseUserRelaEntity> oldRelaList = warehouseUserRelaMapper.selectByWarehouseIdAndUserIds(warehouseId, userIds);
        List<Long> oldUserIds = oldRelaList.stream()
                .map(WarehouseUserRelaEntity::getUserId)
                .collect(Collectors.toList());
        if (CollectionUtils.isNotEmpty(oldUserIds)) {
            warehouseUserRelaMapper.updateStatusByWarehouseAndUserIds(warehouseId, oldUserIds, RelaStatusEnum.ALLOW_LOGIN.getCode());
        }
        //没有绑定过的员工，创建绑定关系
        List<WarehouseUserRelaEntity> needBandList = new ArrayList<>();
        for (Long userId : userIds) {
            if (oldUserIds.contains(userId)) {
                return;
            }
            WarehouseUserRelaEntity entity = new WarehouseUserRelaEntity();
            entity.setCompanyId(warehouse.getCompanyId());
            entity.setWarehouseId(warehouseId);
            entity.setUserId(userId);
            entity.setStatus(RelaStatusEnum.ALLOW_LOGIN.getCode());
            Date now = new Date();
            entity.setCreateDate(now);
            entity.setUpdateDate(now);
            entity.setCreateId(LoginWarehouseUtils.getUserId());
            needBandList.add(entity);
        }
        if (CollectionUtils.isNotEmpty(needBandList)) {
            warehouseUserRelaMapper.batchInsert(needBandList);
        }
        //绑定企业员工关系
        companyUserRelaService.bandCompanyUser(warehouse.getCompanyId(), userIds);
    }

    @Override
    public void bandWarehouseUser(List<Long> userIds) throws BizException {
        Long warehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        bandWarehouseUser(warehouseId, userIds);
    }

    @Override
    public void unBandWarehouseUser(Long warehouseId, List<Long> userIds) throws BizException {
        AssertUtil.isNotEmpty(userIds, WmsBaseErrorCodeEnum.WAREHOUSE_USER_IDS_IS_NOT_NULL);
        WarehouseEntity warehouse = warehouseService.getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);

        warehouseUserRelaMapper.updateStatusByWarehouseAndUserIds(warehouseId, userIds, RelaStatusEnum.FREEZE.getCode());

    }

    @Override
    public void unBandWarehouseUser(List<Long> userIds) throws BizException {
        Long warehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        unBandWarehouseUser(warehouseId, userIds);
    }
}
