package com.wms.base.service.model.param.stock;

import lombok.Data;
/**
 * @date : 2022/6/28 23:13
 * @author: linzhou
 * @description : StockArea
 */
@Data
public class SaveStockAreaParam {

    private Long id;

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
     * 是否失效 0:正常 1：冻结
     */
    private String areaStatus;


    /**
    * 备注
    */
    private String remark;

}