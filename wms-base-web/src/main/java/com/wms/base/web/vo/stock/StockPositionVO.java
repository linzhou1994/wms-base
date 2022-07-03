package com.wms.base.web.vo.stock;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库位表
 */
@Data
public class StockPositionVO {
    /**
     * 主键
     */
    private Long id;

    /**
     * 库位编码
     */
    private String stockPositionCode;

    /**
     * 库位名称
     */
    private String stockPositionName;

    /**
     * 最大容量
     */
    private String maxCapacity;

    /**
     * 库区id
     */
    private Long stockAreaId;

    /**
     * 仓库id
     */
    private Long warehouseId;

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
     * 是否允许混放 1:是 0：否
     */
    private Integer isMixed;

    /**
     * 库区状态 0：正常 1：冻结 2：删除
     */
    private Integer status;

    /**
     * 备注
     */
    private String remark;

    /**
     * 库位类型：1 正常库位 2 残次库位 3 虚拟库位 4 暂存库位
     */
    private Integer stockPositionType;

    /**
     * 库位摆放类型 1 平架区，2 平堆区，3 重力架区 4:高架区
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
     * 拣选优先级：1>2
     */
    private Integer pickLevel;

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