package com.wms.base.service.remote.impl.warehouse;

import com.java.utils.exception.BizException;
import com.spring.dubbo.annotation.RpcService;
import com.wms.base.api.model.dto.warehouse.LoginWarehouseDTO;
import com.wms.base.api.remote.warehouse.RemoteWarehouseService;
import com.wms.base.service.service.warehouse.WarehouseService;
import org.springframework.beans.factory.annotation.Autowired;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-27 09:42
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@RpcService
public class RemoteWarehouseServiceImpl implements RemoteWarehouseService {
    @Autowired
    private WarehouseService warehouseService;

    @Override
    public LoginWarehouseDTO getLoginWarehouse() throws BizException {
        return warehouseService.getLoginWarehouseDTO();
    }
}
