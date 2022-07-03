package com.wms.base.web.vo.stock;

import lombok.Data;

import java.util.Date;

/**
 * @date : 2022/6/28 23:13
 * @author: linzhou
 * @description : StockAreaEntity
 */
@Data
public class StockAreaVO {
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
    * 所属库
    */
    private Long warehouseId;

    /**
    * 是否失效 0:正常 1：冻结
    */
    private String areaStatus;

    /**
    * 备注
    */
    private String remark;

    /**
    * 创建时间
    */
    private Date createDate;

    /**
    * 创建人id
    */
    private Long createId;

    /**
    * 更新时间
    */
    private Date updateDate;

    /**
    * 修改人id
    */
    private Long updateId;

}