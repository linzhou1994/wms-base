package com.wms.base.api.remote.warehouse;


import com.java.utils.exception.BizException;
import com.wms.base.api.model.dto.warehouse.LoginWarehouseDTO;

/**
 * @author linzhou
 */
public interface RemoteWarehouseService {

    /**
     * 获取当前登录的仓库
     *
     * @return
     */
    LoginWarehouseDTO getLoginWarehouse() throws BizException;
}
