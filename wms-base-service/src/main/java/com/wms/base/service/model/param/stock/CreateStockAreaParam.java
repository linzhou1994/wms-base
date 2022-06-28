package com.wms.base.service.model.param.stock;

import lombok.Data;
/**
 * @date : 2022/6/28 23:13
 * @author: linzhou
 * @description : StockArea
 */
@Data
public class CreateStockAreaParam {

    /**
    * 库区编号
    */
    private String areaCode;

    /**
    * 库区名称
    */
    private String areaName;

    /**
    * 库区类型：1：拣货区 2：备货区
    */
    private String areaType;

    /**
    * 所属库
    */
    private Long warehouseId;

    /**
    * 备注
    */
    private String remark;

}