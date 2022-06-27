package com.wms.base.api.utils;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.wms.base.api.context.LoginWarehouseContext;
import com.wms.base.api.dto.company.LoginCompanyDTO;
import com.wms.base.api.dto.warehouse.LoginWarehouseDTO;
import com.wms.base.api.enums.error.WmsBaseApiErrorCodeEnum;
import com.wms.singlesignonapi.utils.LoginUtil;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 20:26
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
public class LoginWarehouseUtils {

    private static final ThreadLocal<LoginWarehouseContext> LOGIN_WAREHOUSE_CONTEXT = ThreadLocal.withInitial(LoginWarehouseContext::new);

    public static void remove() {
        LoginWarehouseContext loginWarehouseContext = getLoginWarehouseContext();
        loginWarehouseContext.setLoginWarehouse(null);
        loginWarehouseContext.setLoginCompany(null);
    }

    public static void setLoginWarehouse(LoginWarehouseDTO loginWarehouse) {
        getLoginWarehouseContext().setLoginWarehouse(loginWarehouse);
    }

    public static void setLoginCompany(LoginCompanyDTO loginCompany) {
        getLoginWarehouseContext().setLoginCompany(loginCompany);
    }

    public static LoginWarehouseDTO getLoginWarehouse() throws BizException {
        LoginWarehouseDTO loginWarehouse = getLoginWarehouseContext().getLoginWarehouse();
        AssertUtil.isNotNull(loginWarehouse, WmsBaseApiErrorCodeEnum.NEED_LOGIN_WAREHOUSE);
        return loginWarehouse;
    }

    public static Long getLoginWarehouseId() throws BizException {
        return getLoginWarehouse().getId();
    }

    public static String getLoginWarehouseName() throws BizException {
        return getLoginWarehouse().getWarehouseName();
    }

    public static LoginCompanyDTO getLoginCompany() throws BizException {
        LoginCompanyDTO loginCompany = getLoginWarehouseContext().getLoginCompany();
        AssertUtil.isNotNull(loginCompany, WmsBaseApiErrorCodeEnum.NEED_LOGIN_COMPANY);
        return loginCompany;
    }

    public static Long getLoginCompanyId() throws BizException {
        return getLoginCompany().getId();
    }

    public static String getLoginCompanyName() throws BizException {
        return getLoginCompany().getCompanyName();
    }

    public static Long getUserId() throws BizException {
        return LoginUtil.getUserId();
    }

    public static String getUserName() throws BizException {
        return LoginUtil.getUserName();
    }

    private static LoginWarehouseContext getLoginWarehouseContext() {
        return LOGIN_WAREHOUSE_CONTEXT.get();
    }


}
