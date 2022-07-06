package com.wms.base.api.context;

import com.wms.base.api.model.dto.company.LoginCompanyDTO;
import com.wms.base.api.model.dto.warehouse.LoginWarehouseDTO;
import lombok.Data;

import java.io.Serializable;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 20:23
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class LoginWarehouseContext implements Serializable {
    /**
     * 登陆的且也信息
     */
    private LoginCompanyDTO loginCompany;
    /**
     * 登陆的仓库信息
     */
    private LoginWarehouseDTO loginWarehouse;
}
