package com.wms.base.service.model.enums.company;

/**
 * @author linzhou
 */
public enum CompanyTypeEnum {

    WAREHOUSE("0","仓储公司"),
    SUPPLIER("1","供应商"),
    ;
    private String code;
    private String msg;

    CompanyTypeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public String getMsg() {
        return msg;
    }

}
