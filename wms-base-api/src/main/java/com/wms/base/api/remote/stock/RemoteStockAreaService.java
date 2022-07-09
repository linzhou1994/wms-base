package com.wms.base.api.remote.stock;

import com.wms.base.api.model.dto.stock.StockAreaDTO;

import java.util.List;

/**
 * 库区管理 远程接口
 *
 * @date : 2022/7/6 23:17
 * @author: linzhou
 * @description : RemoteStockAreaService
 */
public interface RemoteStockAreaService {
    /**
     * 通过id获取库区
     *
     * @param id
     * @return
     */
    StockAreaDTO getStockAreaById(Long id);

    /**
     * 通过ids获取库区集合
     *
     * @param ids
     * @return
     */
    List<StockAreaDTO> getStockAreaByIds(List<Long> ids);

    /**
     * 通过库区编码查询库区
     *
     * @param warehouseId
     * @param areaCode
     * @return
     */
    StockAreaDTO getStockAreaByAreaCode(Long warehouseId, String areaCode);

    /**
     * 通过库区编码查询库区列表
     *
     * @param warehouseId
     * @param areaCodes
     * @return
     */
    List<StockAreaDTO> getStockAreaByAreaCodes(Long warehouseId, List<String> areaCodes);
}
