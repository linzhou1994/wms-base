package com.wms.base.service.service.warehouse;

import com.java.utils.exception.BizException;
import com.wms.base.service.model.entity.warehouse.WarehouseUserRelaEntity;

import java.util.List;

/**
 * @author linzhou
 */
public interface WarehouseUserRelaService {
    /**
     * 获取当前用绑定的仓库信息
     *
     * @return
     */
    List<WarehouseUserRelaEntity> getBandWarehouseIds() throws BizException;

    /**
     * 仓库绑定员工
     *
     * @param warehouseId
     * @param userIds
     */
    void bandWarehouseUser(Long warehouseId, List<Long> userIds) throws BizException;
}
