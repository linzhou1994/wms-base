package com.wms.base.api.remote.company;

import com.java.utils.exception.BizException;
import com.wms.base.api.dto.company.CompanyDTO;

/**
 * @author linzhou
 */
public interface RemoteCompanyService {

    /**
     * 获取当前登录的用户选择的企业
     *
     * @return
     * @throws BizException
     */
    CompanyDTO getLoginCompany() throws BizException;
}
