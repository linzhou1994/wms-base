package com.wms.base.web.controller.company;

import com.java.utils.exception.BizException;
import com.java.utils.result.Result;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.model.param.company.CreateCompanyParam;
import com.wms.base.service.service.company.CompanyService;
import com.wms.base.web.request.IdRequest;
import com.wms.base.web.request.company.CreateCompanyRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 企业管理
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 16:07
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@RestController
@RequestMapping("company")
public class CompanyController {

    @Autowired
    private CompanyService companyService;

    /**
     * 创建企业
     *
     * @param createCompanyParam
     * @return
     * @throws BizException
     */
    @RequestMapping("createCompany")
    public Result<Long> createCompany(@RequestBody CreateCompanyRequest createCompanyParam) throws BizException {

        CreateCompanyParam copy = BeanCopy.copy(createCompanyParam, CreateCompanyParam.class);
        CompanyEntity company = companyService.createCompany(copy);
        return Result.success(company.getId());
    }

    /**
     * 冻结企业
     *
     * @param idRequest 企业id
     * @return
     * @throws BizException
     */
    @RequestMapping("freezeCompany")
    public Result freezeCompany(@RequestBody IdRequest idRequest) throws BizException {

        companyService.freezeCompany(idRequest.getId());
        return Result.success();
    }


    /**
     * 登录用户选择登陆的企业
     * @param idRequest 要登录的企业id
     * @return
     */
    @RequestMapping("chooseCompany")
    public Result chooseCompany(@RequestBody IdRequest idRequest) throws BizException {
        companyService.chooseCompany(idRequest.getId());
        return Result.success();
    }


}
