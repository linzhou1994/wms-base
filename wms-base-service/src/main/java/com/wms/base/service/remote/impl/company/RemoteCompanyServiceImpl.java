package com.wms.base.service.remote.impl.company;

import com.alibaba.dubbo.config.annotation.Service;
import com.java.utils.exception.BizException;
import com.wms.base.api.model.dto.company.LoginCompanyDTO;
import com.wms.base.api.remote.company.RemoteCompanyService;
import com.wms.base.service.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 17:40
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
@Component
public class RemoteCompanyServiceImpl implements RemoteCompanyService {
    @Autowired
    private CompanyService companyService;

    @Override
    public LoginCompanyDTO getLoginCompany() throws BizException {
        return companyService.getLoginCompany();
    }
}
