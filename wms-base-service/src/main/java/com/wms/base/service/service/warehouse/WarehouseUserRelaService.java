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

    /**
     * 对当前登录仓库绑定用户
     *
     * @param userIds
     * @throws BizException
     */
    void bandWarehouseUser(List<Long> userIds) throws BizException;


    /**
     * 仓库解绑员工
     *
     * @param warehouseId
     * @param userIds
     */
    void unBandWarehouseUser(Long warehouseId, List<Long> userIds) throws BizException;

    /**
     * 对当前登录仓库仓库解绑员工
     *
     * @param userIds
     * @throws BizException
     */
    void unBandWarehouseUser(List<Long> userIds) throws BizException;
}
