package com.wms.base.service.service.stock;

import com.java.utils.exception.BizException;
import com.spring.utils.http.result.PageResult;
import com.wms.base.service.model.dto.stock.StockAreaDTO;
import com.wms.base.service.model.entity.stock.StockAreaEntity;
import com.wms.base.service.model.param.stock.GetStockAreaListParam;
import com.wms.base.service.model.param.stock.SaveStockAreaParam;

import java.util.List;


/**
 * 库区管理
 *
 * @author linzhou
 */
public interface StockAreaService {

    /**
     * 保存库区
     *
     * @param saveStockAreaParam
     * @return
     */
    StockAreaDTO saveStockAreas(SaveStockAreaParam saveStockAreaParam) throws BizException;

    /**
     * 查询库区
     *
     * @param param
     * @return
     */
    PageResult<StockAreaEntity> getStockAreaList(GetStockAreaListParam param) throws BizException;

    /**
     * 根据id查询库区
     *
     * @param ids
     * @return
     */
    List<StockAreaEntity> getByIds(List<Long> ids);
}
