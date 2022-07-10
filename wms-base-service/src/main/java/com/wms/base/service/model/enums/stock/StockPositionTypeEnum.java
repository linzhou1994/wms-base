package com.wms.base.service.model.enums.stock;

/**
 * 库位类型
 *
 * @author linzhou
 */

public enum StockPositionTypeEnum {
    ENABLE(1, "正常库位"),
    DEFECTIVE(2, "残次库位"),
    VIRTUAL(3, "虚拟库位"),
    TEMPORARY_STORAGE(4, "暂存库位"),
    ;
    private Integer code;
    private String msg;

    StockPositionTypeEnum(Integer code, String msg) {
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
