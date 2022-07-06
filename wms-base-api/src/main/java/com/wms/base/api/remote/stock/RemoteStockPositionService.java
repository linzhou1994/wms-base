package com.wms.base.api.remote.stock;

import com.wms.base.api.model.dto.stock.StockPositionDTO;

import java.util.List;

/**
 * 库位管理远程接口
 *
 * @date : 2022/7/6 23:19
 * @author: linzhou
 * @description : RemoteStockPositionService
 */
public interface RemoteStockPositionService {
    /**
     * 通过库位id获取库位
     *
     * @param id
     * @return
     */
    StockPositionDTO getStockPositionById(Long id);

    /**
     * 通过库位id获取库位列表
     *
     * @param ids
     * @return
     */
    List<StockPositionDTO> getStockPositionByIds(List<Long> ids);

    /**
     * 通过库位编码获取库位
     *
     * @param warehouseId
     * @param stockPositionCode
     * @return
     */
    StockPositionDTO getStockPositionByCode(Long warehouseId, String stockPositionCode);

    /**
     * 通过库位编码查询库位列表
     *
     * @param warehouseId
     * @param stockPositionCodes
     * @return
     */
    List<StockPositionDTO> getStockPositionByCodes(Long warehouseId, List<String> stockPositionCodes);
}
