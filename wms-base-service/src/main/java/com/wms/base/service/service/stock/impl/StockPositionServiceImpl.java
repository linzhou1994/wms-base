package com.wms.base.service.service.stock.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.spring.utils.http.result.PageResult;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.base.service.dao.stock.StockPositionMapper;
import com.wms.base.service.model.entity.stock.StockAreaEntity;
import com.wms.base.service.model.entity.stock.StockPositionEntity;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.stock.StockAreaStatusEnum;
import com.wms.base.service.model.enums.stock.StockPositionStatusEnum;
import com.wms.base.service.model.param.stock.AddStockPositionBatchItemParam;
import com.wms.base.service.model.param.stock.GetStockPositionParam;
import com.wms.base.service.model.param.stock.UpdateStockPositionParam;
import com.wms.base.service.service.stock.StockAreaService;
import com.wms.base.service.service.stock.StockPositionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-07-03 18:11
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
@Slf4j
public class StockPositionServiceImpl implements StockPositionService {

    @Autowired
    private StockPositionMapper stockPositionMapper;

    @Autowired
    private StockAreaService stockAreaService;


    @Override
    public void addStockPositionBatch(List<AddStockPositionBatchItemParam> params) throws BizException {

        checkAddStockPositionBatch(params);
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        Long userId = LoginWarehouseUtils.getUserId();
        Date now = new Date();
        List<StockPositionEntity> entities = BeanCopy.copyList(params, StockPositionEntity.class);
        for (StockPositionEntity entity : entities) {
            entity.setWarehouseId(loginWarehouseId);
            entity.setCreateId(userId);
            entity.setCreateDate(now);
            entity.setUpdateDate(now);
        }
        stockPositionMapper.batchInsert(entities);
    }


    @Override
    public void update(UpdateStockPositionParam param) throws BizException {
        checkUpdateParam(param);
        StockPositionEntity copy = BeanCopy.copy(param, StockPositionEntity.class);
        stockPositionMapper.updateByPrimaryKeySelective(copy);
    }


    @Override
    public PageResult<StockPositionEntity> getStockPositionList(GetStockPositionParam param) throws BizException {
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        Long total = stockPositionMapper.getStockPositionListCount(param, loginWarehouseId);
        if (total <= 0L) {
            return PageResult.buildEmpty(param);
        }
        List<StockPositionEntity> data = stockPositionMapper.getStockPositionList(param, loginWarehouseId);
        return PageResult.build(param, total, data);
    }

    @Override
    public StockPositionEntity getById(Long id) {
        if (Objects.isNull(id) || id <= 0L) {
            return null;
        }
        return stockPositionMapper.selectByPrimaryKey(id);
    }


    private void checkAddStockPositionBatch(List<AddStockPositionBatchItemParam> params) throws BizException {

        AssertUtil.isNotEmpty(params, WmsBaseErrorCodeEnum.ADD_STOCK_POSITION_LIST_NOT_EMPTY);
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();

        for (int i = 0; i < params.size(); i++) {
            AddStockPositionBatchItemParam param = params.get(i);
            AssertUtil.isNotBlank(param.getStockPositionCode(), WmsBaseErrorCodeEnum.ADD_STOCK_POSITION_CODE_NOT_EMPTY, i + 1);
            AssertUtil.isNotBlank(param.getStockPositionName(), WmsBaseErrorCodeEnum.ADD_STOCK_POSITION_NAME_NOT_EMPTY, i + 1);
            AssertUtil.isNotNull(param.getStockAreaId(), WmsBaseErrorCodeEnum.ADD_STOCK_POSITION_AREA_NOT_EMPTY, i + 1);
        }
        //创建库位所属的库区
        List<Long> areaIds = params.stream().map(AddStockPositionBatchItemParam::getStockAreaId).distinct().collect(Collectors.toList());
        //需要创建库位的有效库区
        Set<Long> areaIdSet = stockAreaService.getByIds(areaIds).stream()
                .filter(o -> Objects.equals(StockAreaStatusEnum.ENABLE.getCode(), o.getAreaStatus()))
                .filter(o -> Objects.equals(loginWarehouseId, o.getWarehouseId()))
                .map(StockAreaEntity::getId)
                .collect(Collectors.toSet());
        //无效或者不存在的库区id
        Set<Long> notExistsAreaIdSet = new HashSet<>();
        for (Long areaId : areaIds) {
            if (!areaIdSet.contains(areaId)) {
                notExistsAreaIdSet.add(areaId);
            }
        }

        AssertUtil.isEmpty(notExistsAreaIdSet, WmsBaseErrorCodeEnum.ADD_STOCK_POSITION_AREA_NOT_EMPTY, notExistsAreaIdSet);

    }

    private void checkUpdateParam(UpdateStockPositionParam param) throws BizException {
        Long loginWarehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        AssertUtil.isNotBlank(param.getStockPositionName(), WmsBaseErrorCodeEnum.STOCK_POSITION_NAME_NOT_EMPTY);
        StockPositionEntity entity = getById(param.getId());
        AssertUtil.isNotNull(entity, WmsBaseErrorCodeEnum.STOCK_POSITION_NOT_EXISTS);
        AssertUtil.isEquals(entity.getWarehouseId(), loginWarehouseId, WmsBaseErrorCodeEnum.STOCK_POSITION_NOT_EXISTS);
        AssertUtil.isEquals(entity.getStatus(), StockPositionStatusEnum.ENABLE.getCode(), WmsBaseErrorCodeEnum.STOCK_POSITION_NOT_ENABLE);
    }
}
