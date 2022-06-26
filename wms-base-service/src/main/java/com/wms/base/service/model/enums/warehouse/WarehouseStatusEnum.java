package com.wms.base.service.model.enums.warehouse;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 14:28
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0 仓库账号状态类
 */
public enum WarehouseStatusEnum {
    ALLOW_LOGIN(0,"正常"),
    FREEZE(1,"冻结"),
    ;
    private Integer code;
    private String msg;

    WarehouseStatusEnum(Integer code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public Integer getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }
}
