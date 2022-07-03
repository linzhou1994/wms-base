package com.wms.base.service.model.param.stock;

import lombok.Data;

import java.math.BigDecimal;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-07-03 18:07
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class UpdateStockPositionParam {

    /**
     * 库位id
     */
    private Long id;

    /**
     * 库位名称
     */
    private String stockPositionName;

    /**
     * 最大容量
     */
    private String maxCapacity;

    /**
     * 长
     */
    private BigDecimal length;

    /**
     * 宽
     */
    private BigDecimal width;

    /**
     * 高
     */
    private BigDecimal height;

    /**
     * 体积
     */
    private BigDecimal capacity;

    /**
     * 是否允许混放 1:是 0：否,默认0
     */
    private Integer isMixed;

    /**
     * 库区状态 0：正常 1：冻结 2：删除，默认0
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 库位类型：1 正常库位 2 残次库位 3 虚拟库位 4 暂存库位 默认0
     */
    private Integer stockPositionType;

    /**
     * 库位摆放类型 1 平架区，2 平堆区，3 重力架区 4:高架区 默认0
     */
    private Integer stockPositionPutType;

    /**
     * 通道
     */
    private String aisle;

    /**
     * 刻度
     */
    private String scale;

    /**
     * 层次
     */
    private String level;

    /**
     * 拣选优先级：1>2 默认1
     */
    private Integer pickLevel;

}
