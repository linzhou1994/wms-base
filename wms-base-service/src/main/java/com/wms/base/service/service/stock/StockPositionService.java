package com.wms.base.service.service.stock;

import com.java.utils.exception.BizException;
import com.spring.utils.http.result.PageResult;
import com.wms.base.service.model.entity.stock.StockPositionEntity;
import com.wms.base.service.model.param.stock.AddStockPositionBatchItemParam;
import com.wms.base.service.model.param.stock.GetStockPositionParam;
import com.wms.base.service.model.param.stock.UpdateStockPositionParam;

import java.util.List;

/**
 * @author linzhou
 */
public interface StockPositionService {


    /**
     * 批量创建库位
     *
     * @param params
     */
    void addStockPositionBatch(List<AddStockPositionBatchItemParam> params) throws BizException;

    /**
     * 修改库位
     *
     * @param param
     */
    void update(UpdateStockPositionParam param) throws BizException;

    /**
     * 分页查询库位
     *
     * @param param
     * @return
     */
    PageResult<StockPositionEntity> getStockPositionList(GetStockPositionParam param) throws BizException;

    /**
     * 根据库位id 获取库位
     *
     * @param id
     * @return
     */
    StockPositionEntity getById(Long id);

    /**
     * 通过库位id获取库位列表
     *
     * @param ids
     * @return
     */
    List<StockPositionEntity> getByIds(List<Long> ids);
}
