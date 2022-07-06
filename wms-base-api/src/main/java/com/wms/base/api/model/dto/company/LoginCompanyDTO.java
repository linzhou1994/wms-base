package com.wms.base.api.model.dto.company;

import java.io.Serializable;
import java.util.Date;

/**
 * 公司id
 */
public class LoginCompanyDTO implements Serializable {
    private Long id;

    /**
     * 仓库名称
     */
    private String companyName;

    /**
     * 仓库编码
     */
    private String companyCode;

    /**
     * 多选英文都好隔开 企业类型 0：仓储公司 1：获取供应商
     */
    private String companyType;

    /**
     * 企业状态 0：正常 1：冻结
     */
    private Integer companyStatus;

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

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public String getCompanyCode() {
        return companyCode;
    }

    public void setCompanyCode(String companyCode) {
        this.companyCode = companyCode;
    }

    public String getCompanyType() {
        return companyType;
    }

    public void setCompanyType(String companyType) {
        this.companyType = companyType;
    }

    public Integer getCompanyStatus() {
        return companyStatus;
    }

    public void setCompanyStatus(Integer companyStatus) {
        this.companyStatus = companyStatus;
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