package com.wms.base.service.service.stock;

import com.java.utils.exception.BizException;
import com.wms.base.service.model.dto.stock.StockAreaDTO;
import com.wms.base.service.model.param.stock.SaveStockAreaParam;


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
}
