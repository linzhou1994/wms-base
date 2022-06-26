package com.wms.base.service.remote.impl.company;

import com.java.utils.exception.BizException;
import com.spring.dubbo.annotation.RpcService;
import com.wms.base.api.remote.company.RemoteCompanyService;
import com.wms.base.api.dto.company.CompanyDTO;
import com.wms.base.service.service.company.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;

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
@RpcService
public class RemoteCompanyServiceImpl implements RemoteCompanyService {
    @Autowired
    private CompanyService companyService;

    @Override
    public CompanyDTO getLoginCompany() throws BizException {
        return companyService.getLoginCompany();
    }
}
