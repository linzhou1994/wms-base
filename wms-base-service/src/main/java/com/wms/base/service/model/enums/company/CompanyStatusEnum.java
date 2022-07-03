package com.wms.base.service.model.enums.company;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 14:28
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0 企业账号状态类
 */
public enum CompanyStatusEnum {
    ENABLE(0,"正常"),
    FREEZE(1,"冻结"),
    ;
    private Integer code;
    private String msg;

    CompanyStatusEnum(Integer code, String msg) {
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
