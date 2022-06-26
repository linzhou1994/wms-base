package com.wms.base.service.service.warehouse;

import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;

import java.util.List;

/**
 * @author linzhou
 */
public interface WarehouseService {

    /**
     * 获取当前登录人的仓库列表
     *
     * @return
     */
    List<GetWarehouseListDTO> getWarehouseListDTO();

    /**
     * 登录用户选择登陆的仓库
     *
     * @param warehouseId 要选择的仓库id
     */
    void chooseWareHouse(Long warehouseId);
}
