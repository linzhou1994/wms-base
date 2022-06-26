package com.wms.base.service.model.entity.warehouse;

import java.util.Date;

/**
    * 仓库表
    */
public class WarehouseEntity {
    private Long id;

    /**
    * 仓库名称
    */
    private String warehouseName;

    /**
    * 仓库编码
    */
    private String warehouseCode;

    /**
    * 所属公司id
    */
    private Long companyId;

    /**
    * 仓库状态 0：正常 1：冻结
    */
    private Byte warehouseStatus;

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

    public String getWarehouseName() {
        return warehouseName;
    }

    public void setWarehouseName(String warehouseName) {
        this.warehouseName = warehouseName;
    }

    public String getWarehouseCode() {
        return warehouseCode;
    }

    public void setWarehouseCode(String warehouseCode) {
        this.warehouseCode = warehouseCode;
    }

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Byte getWarehouseStatus() {
        return warehouseStatus;
    }

    public void setWarehouseStatus(Byte warehouseStatus) {
        this.warehouseStatus = warehouseStatus;
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