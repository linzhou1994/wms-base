package com.wms.base.api.remote.company;

import com.java.utils.exception.BizException;
import com.wms.base.api.model.dto.company.LoginCompanyDTO;

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
    LoginCompanyDTO getLoginCompany() throws BizException;
}
