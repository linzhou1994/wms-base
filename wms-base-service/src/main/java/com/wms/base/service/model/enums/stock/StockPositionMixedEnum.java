package com.wms.base.service.model.enums.stock;

/**
 * 是否允许混放
 *
 * @author linzhou
 */
public enum StockPositionMixedEnum {
    ALLOW(1, "允许"),
    UN_ALLOW(0, "不允许"),
    ;
    private Integer code;
    private String msg;

    StockPositionMixedEnum(Integer code, String msg) {
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
