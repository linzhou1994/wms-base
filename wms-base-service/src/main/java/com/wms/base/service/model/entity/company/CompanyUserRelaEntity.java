package com.wms.base.service.model.entity.company;

import java.util.Date;

/**
    * 用户-企业关联表
    */
public class CompanyUserRelaEntity {
    private Long id;

    /**
    * 企业id
    */
    private Long companyId;

    /**
    * 用户id
    */
    private Long userId;

    /**
    * 关联状态 0：正常 1：解除
    */
    private Byte status;

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

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public Byte getStatus() {
        return status;
    }

    public void setStatus(Byte status) {
        this.status = status;
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