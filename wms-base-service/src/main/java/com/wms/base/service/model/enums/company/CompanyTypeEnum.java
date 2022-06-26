package com.wms.base.service.model.enums.company;

/**
 * @author linzhou
 */
public enum CompanyTypeEnum {

    warehouse(0,"仓储公司"),
    supplier(1,"供应商"),
    ;
    private Integer code;
    private String msg;

    CompanyTypeEnum(Integer code, String msg) {
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
