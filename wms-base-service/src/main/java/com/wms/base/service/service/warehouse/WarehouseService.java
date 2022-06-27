package com.wms.base.service.service.warehouse;

import com.java.utils.exception.BizException;
import com.wms.base.api.dto.warehouse.LoginWarehouseDTO;
import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;
import com.wms.base.service.model.entity.warehouse.WarehouseEntity;
import com.wms.base.service.model.param.warehouse.CreateWarehouseParam;

import java.util.List;

/**
 * @author linzhou
 */
public interface WarehouseService {

    /**
     * 创建仓库
     *
     * @param createWarehouseParam
     * @return
     * @throws BizException
     */
    Long createWarehouse(CreateWarehouseParam createWarehouseParam) throws BizException;

    /**
     * 获取当前登录人的仓库列表
     *
     * @return
     */
    List<GetWarehouseListDTO> getWarehouseListDTO() throws BizException;

    /**
     * 登录用户选择登陆的仓库
     *
     * @param warehouseId 要选择的仓库id
     */
    void chooseWarehouse(Long warehouseId) throws BizException;

    /**
     * 获取当前登录的仓库信息
     *
     * @return
     */
    LoginWarehouseDTO getLoginWarehouseDTO() throws BizException;

    /**
     * 通过仓库id获取仓库信息
     *
     * @param warehouseIds
     * @return
     */
    List<WarehouseEntity> getWarehouseByIds(List<Long> warehouseIds);

    /**
     * 通过仓库id获取仓库信息
     *
     * @param warehouseId
     * @return
     */
    WarehouseEntity getWarehouseById(Long warehouseId);
}
