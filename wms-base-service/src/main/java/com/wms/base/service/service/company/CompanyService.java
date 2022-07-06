package com.wms.base.service.service.company;

import com.java.utils.exception.BizException;
import com.wms.base.api.model.dto.company.LoginCompanyDTO;
import com.wms.base.service.model.param.company.CreateCompanyParam;
import com.wms.base.service.model.entity.company.CompanyEntity;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:00
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
public interface CompanyService {

    /**
     * 创建企业
     *
     * @param createCompanyParam
     * @return
     */
    CompanyEntity createCompany(CreateCompanyParam createCompanyParam) throws BizException;

    /**
     * 冻结企业
     *
     * @param companyId
     * @return
     */
    boolean freezeCompany(Long companyId) throws BizException;

    /**
     * 通过id查询企业
     *
     * @param companyId
     * @return
     */
    CompanyEntity getCompanyById(Long companyId);


    /**
     * 当前登录用户选择要登录的企业
     *
     * @param companyId
     */
    void chooseCompany(Long companyId) throws BizException;

    /**
     * 获取登录的企业
     */
    LoginCompanyDTO getLoginCompany() throws BizException;

    /**
     * 通过id获取企业
     *
     * @param companyIds
     * @return
     */
    List<CompanyEntity> getCompanyByIds(List<Long> companyIds);
}
