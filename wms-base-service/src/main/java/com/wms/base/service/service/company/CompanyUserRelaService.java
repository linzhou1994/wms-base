package com.wms.base.service.service.company;

import com.java.utils.exception.BizException;

import java.util.List;

/**
 * 企业员工关联
 *
 * @author linzhou
 */
public interface CompanyUserRelaService {

    /**
     * 绑定企业与员工的关系
     *
     * @param companyId
     * @param userIds
     */
    void bandCompanyUser(Long companyId, List<Long> userIds) throws BizException;
}
