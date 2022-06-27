package com.wms.base.api.enums.error;

import com.java.utils.enums.SystemEnum;
import com.java.utils.exception.ErrorCode;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:14
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
public enum WmsBaseApiErrorCodeEnum implements ErrorCode {


    NEED_LOGIN_COMPANY("000001", "请先选择企业"),
    NEED_LOGIN_WAREHOUSE("000002", "请先选择仓库"),

    ;
    private String code;
    private String msg;

    WmsBaseApiErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return SystemEnum.SSO_SYSTEM.getCode() + this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
