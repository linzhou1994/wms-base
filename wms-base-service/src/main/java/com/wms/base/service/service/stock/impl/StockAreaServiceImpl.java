package com.wms.base.service.service.stock.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.enums.EnumUtil;
import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.spring.utils.http.result.PageResult;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.base.service.dao.stock.StockAreaMapper;
import com.wms.base.service.model.dto.stock.StockAreaDTO;
import com.wms.base.service.model.entity.stock.StockAreaEntity;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.stock.StockAreaStatusEnum;
import com.wms.base.service.model.enums.stock.StockAreaTypeEnum;
import com.wms.base.service.model.param.stock.GetStockAreaListParam;
import com.wms.base.service.model.param.stock.SaveStockAreaParam;
import com.wms.base.service.service.stock.StockAreaService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-29 13:09
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
@Slf4j
public class StockAreaServiceImpl implements StockAreaService {

    @Autowired
    private StockAreaMapper stockAreaMapper;

    @Override
    public StockAreaDTO saveStockAreas(SaveStockAreaParam saveStockAreaParam) throws BizException {


        Long stockAreaId = saveStockAreaParam.getId();
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        if (Objects.isNull(stockAreaId)) {
            //新增
            stockAreaId = createStockArea(saveStockAreaParam, loginWarehouseId);
        } else {
            //修改
            updateStockArea(saveStockAreaParam, loginWarehouseId);
        }
        StockAreaEntity stockAreaEntity = stockAreaMapper.selectByPrimaryKey(stockAreaId);
        return BeanCopy.copy(stockAreaEntity, StockAreaDTO.class);
    }

    @Override
    public PageResult<StockAreaEntity> getStockAreaList(GetStockAreaListParam param) throws BizException {
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        Long total = stockAreaMapper.getStockAreaListCount(param,loginWarehouseId);
        if (total <= 0L) {
            return PageResult.buildEmpty(param);
        }
        List<StockAreaEntity> data = stockAreaMapper.getStockAreaList(param,loginWarehouseId);
        return PageResult.build(param, total, data);
    }

    @Override
    public List<StockAreaEntity> getByIds(List<Long> ids) {
        if (CollectionUtils.isEmpty(ids)){
            return Collections.emptyList();
        }
        ids = ids.stream()
                .filter(id -> Objects.nonNull(id) && id > 0L)
                .distinct()
                .collect(Collectors.toList());
        if (CollectionUtils.isEmpty(ids)){
            return Collections.emptyList();
        }
        return stockAreaMapper.selectByIds(ids);
    }

    /**
     * 修改库区
     *
     * @param saveStockAreaParam
     * @param warehouseId
     * @throws BizException
     */
    private void updateStockArea(SaveStockAreaParam saveStockAreaParam, Long warehouseId) throws BizException {
        StockAreaEntity stockAreaEntity = stockAreaMapper.selectByPrimaryKey(saveStockAreaParam.getId());
        AssertUtil.isNotNull(stockAreaEntity, WmsBaseErrorCodeEnum.STOCK_AREA_NOT_EXISTS);
        AssertUtil.isEquals(stockAreaEntity.getWarehouseId(), warehouseId, WmsBaseErrorCodeEnum.STOCK_AREA_NOT_IN_WAREHOUSE);
        AssertUtil.isNotEquals(stockAreaEntity.getAreaStatus(), StockAreaStatusEnum.DELETE.getCode(), WmsBaseErrorCodeEnum.STOCK_AREA_NOT_EXISTS);

        checkStockAreaParam(saveStockAreaParam);

        stockAreaEntity.setAreaCode(saveStockAreaParam.getAreaCode());
        stockAreaEntity.setAreaName(saveStockAreaParam.getAreaName());
        stockAreaEntity.setAreaType(saveStockAreaParam.getAreaType());
        stockAreaEntity.setAreaStatus(saveStockAreaParam.getAreaStatus());
        stockAreaEntity.setUpdateId(LoginWarehouseUtils.getUserId());
        stockAreaEntity.setUpdateDate(new Date());
        stockAreaMapper.updateByPrimaryKey(stockAreaEntity);
    }

    /**
     * 创建库区
     *
     * @param saveStockAreaParam
     * @param warehouseId
     * @return 创建的库区id
     * @throws BizException
     */
    private Long createStockArea(SaveStockAreaParam saveStockAreaParam, Long warehouseId) throws BizException {

        checkStockAreaParam(saveStockAreaParam);

        StockAreaEntity stockAreaEntity = BeanCopy.copy(saveStockAreaParam, StockAreaEntity.class);
        stockAreaEntity.setAreaStatus(StockAreaStatusEnum.ENABLE.getCode());
        stockAreaEntity.setWarehouseId(warehouseId);
        stockAreaEntity.setCreateId(LoginWarehouseUtils.getUserId());
        stockAreaMapper.insertSelective(stockAreaEntity);
        return stockAreaEntity.getId();
    }

    private void checkStockAreaParam(SaveStockAreaParam saveStockAreaParam) throws BizException {
        AssertUtil.isNotBlank(saveStockAreaParam.getAreaCode(), WmsBaseErrorCodeEnum.STOCK_AREA_CODE_NOT_BLANK);
        AssertUtil.isNotBlank(saveStockAreaParam.getAreaName(), WmsBaseErrorCodeEnum.STOCK_AREA_NAME_NOT_BLANK);
        StockAreaTypeEnum typeEnum = EnumUtil.getEnumByCode(StockAreaTypeEnum.class, saveStockAreaParam.getAreaType());
        AssertUtil.isNull(typeEnum, WmsBaseErrorCodeEnum.STOCK_AREA_TYPE_NOT_BLANK);
    }
}
