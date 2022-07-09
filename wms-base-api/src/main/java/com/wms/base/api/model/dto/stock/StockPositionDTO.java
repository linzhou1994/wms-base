package com.wms.base.api.model.dto.stock;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 库位表
 */
public class StockPositionDTO {
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

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getStockPositionCode() {
        return stockPositionCode;
    }

    public void setStockPositionCode(String stockPositionCode) {
        this.stockPositionCode = stockPositionCode;
    }

    public String getStockPositionName() {
        return stockPositionName;
    }

    public void setStockPositionName(String stockPositionName) {
        this.stockPositionName = stockPositionName;
    }

    public String getMaxCapacity() {
        return maxCapacity;
    }

    public void setMaxCapacity(String maxCapacity) {
        this.maxCapacity = maxCapacity;
    }

    public Long getStockAreaId() {
        return stockAreaId;
    }

    public void setStockAreaId(Long stockAreaId) {
        this.stockAreaId = stockAreaId;
    }

    public Long getWarehouseId() {
        return warehouseId;
    }

    public void setWarehouseId(Long warehouseId) {
        this.warehouseId = warehouseId;
    }

    public BigDecimal getLength() {
        return length;
    }

    public void setLength(BigDecimal length) {
        this.length = length;
    }

    public BigDecimal getWidth() {
        return width;
    }

    public void setWidth(BigDecimal width) {
        this.width = width;
    }

    public BigDecimal getHeight() {
        return height;
    }

    public void setHeight(BigDecimal height) {
        this.height = height;
    }

    public BigDecimal getCapacity() {
        return capacity;
    }

    public void setCapacity(BigDecimal capacity) {
        this.capacity = capacity;
    }

    public Integer getIsMixed() {
        return isMixed;
    }

    public void setIsMixed(Integer isMixed) {
        this.isMixed = isMixed;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getStockPositionType() {
        return stockPositionType;
    }

    public void setStockPositionType(Integer stockPositionType) {
        this.stockPositionType = stockPositionType;
    }

    public Integer getStockPositionPutType() {
        return stockPositionPutType;
    }

    public void setStockPositionPutType(Integer stockPositionPutType) {
        this.stockPositionPutType = stockPositionPutType;
    }

    public String getAisle() {
        return aisle;
    }

    public void setAisle(String aisle) {
        this.aisle = aisle;
    }

    public String getScale() {
        return scale;
    }

    public void setScale(String scale) {
        this.scale = scale;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public Integer getPickLevel() {
        return pickLevel;
    }

    public void setPickLevel(Integer pickLevel) {
        this.pickLevel = pickLevel;
    }

    public Date getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Date createDate) {
        this.createDate = createDate;
    }

    public Long getCreateId() {
        return createId;
    }

    public void setCreateId(Long createId) {
        this.createId = createId;
    }

    public Date getUpdateDate() {
        return updateDate;
    }

    public void setUpdateDate(Date updateDate) {
        this.updateDate = updateDate;
    }

    public Long getUpdateId() {
        return updateId;
    }

    public void setUpdateId(Long updateId) {
        this.updateId = updateId;
    }
}