package com.wms.base.service.service.company.impl;

import com.example.singlesignonapi.utils.LoginUtil;
import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.service.dao.company.CompanyMapper;
import com.wms.base.api.dto.company.CompanyDTO;
import com.wms.base.service.model.param.company.CreateCompanyParam;
import com.wms.base.service.model.enums.company.CompanyStatusEnum;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.redis.RedisCacheKeyEnum;
import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.service.company.CompanyService;
import com.wms.base.service.service.company.CompanyUserRelaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.Collections;
import java.util.Objects;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:07
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class CompanyServiceImpl implements CompanyService {

    @Autowired
    private CompanyMapper companyMapper;
    @Autowired
    private CompanyUserRelaService companyUserRelaService;
    @Resource
    private RedisTemplate<String, Long> redisTemplate;

    @Override
    public CompanyEntity createCompany(CreateCompanyParam createCompanyParam) throws BizException {
        //校验创建企业参数
        checkCreateCompany(createCompanyParam);
        //创建企业
        return doCreateCompany(createCompanyParam);
    }

    @Override
    public boolean freezeCompany(Long companyId) throws BizException {
        CompanyEntity company = getCompanyById(companyId);
        AssertUtil.isNotNull(company, WmsBaseErrorCodeEnum.COMPANY_NOT_EXISTS);
        companyMapper.updateComPanyStatus(companyId, CompanyStatusEnum.FREEZE.getCode());
        return false;
    }

    @Override
    public CompanyEntity getCompanyById(Long companyId) {
        if (Objects.isNull(companyId) || companyId <= 0L) {
            return null;
        }
        return companyMapper.selectByPrimaryKey(companyId);
    }

    @Override
    public void chooseCompany(Long companyId) throws BizException {
        String ticket = LoginUtil.getLoginContext().getTicket();
        CompanyEntity company = getCompanyById(companyId);
        AssertUtil.isNotNull(company, WmsBaseErrorCodeEnum.COMPANY_NOT_EXISTS);
        AssertUtil.isNotEquals(company.getCompanyStatus(), CompanyStatusEnum.ALLOW_LOGIN.getCode()
                , WmsBaseErrorCodeEnum.COMPANY_IS_FREEZE);
        refreshChooseCompany(companyId, ticket);
    }


    @Override
    public CompanyDTO getLoginCompany() throws BizException {
        String ticket = LoginUtil.getLoginContext().getTicket();
        String redisKey = RedisCacheKeyEnum.LOGIN_COMPANY_TICKET_CACHE.getKey(ticket);
        Long companyId = redisTemplate.boundValueOps(redisKey).get();

        CompanyEntity company = getCompanyById(companyId);
        AssertUtil.isNotNull(company, WmsBaseErrorCodeEnum.COMPANY_NOT_EXISTS);
        AssertUtil.isNotEquals(company.getCompanyStatus(), CompanyStatusEnum.ALLOW_LOGIN.getCode()
                , WmsBaseErrorCodeEnum.COMPANY_IS_FREEZE);
        refreshChooseCompany(companyId, ticket);

        return BeanCopy.copy(company, CompanyDTO.class);
    }


    /**
     * 创建企业
     *
     * @param createCompanyParam
     * @return
     * @throws BizException
     */
    private CompanyEntity doCreateCompany(CreateCompanyParam createCompanyParam) throws BizException {
        //创建企业
        CompanyEntity companyEntity = BeanCopy.copy(createCompanyParam, CompanyEntity.class);
        String companyType = createCompanyParam.getCompanyType().stream().map(String::valueOf).collect(Collectors.joining(","));
        companyEntity.setCompanyType(companyType);
        companyEntity.setCompanyStatus(CompanyStatusEnum.ALLOW_LOGIN.getCode());

        Long userId = LoginUtil.getUserId();
        companyEntity.setCreateId(userId);

        companyMapper.insertSelective(companyEntity);
        //绑定员工和企业的关系
        companyUserRelaService.bandCompanyUser(companyEntity.getId(), Collections.singletonList(userId));

        return companyEntity;
    }

    /**
     * 校验创建企业参数
     *
     * @param createCompanyParam
     * @throws BizException
     */
    private void checkCreateCompany(CreateCompanyParam createCompanyParam) throws BizException {
        //企业编码不能为空
        AssertUtil.isNotBlank(createCompanyParam.getCompanyCode(), WmsBaseErrorCodeEnum.COMPANY_CODE_IS_NOT_BLANK);
        //企业类型不能为空
        AssertUtil.isNotEmpty(createCompanyParam.getCompanyType(), WmsBaseErrorCodeEnum.COMPANY_TYPE_IS_NOT_NULL);
        //企业名称不能为空
        AssertUtil.isNotBlank(createCompanyParam.getCompanyName(), WmsBaseErrorCodeEnum.COMPANY_NAME_IS_NOT_NULL);

        CompanyEntity companyEntity = companyMapper.selectByCompanyCode(createCompanyParam.getCompanyCode());
        //企业编码已存在
        AssertUtil.isNull(companyEntity, WmsBaseErrorCodeEnum.COMPANY_CODE_ALREADY_EXISTS);
    }

    /**
     * 刷新选择企业的过期时间
     *
     * @param companyId
     * @param ticket
     */
    private void refreshChooseCompany(Long companyId, String ticket) {
        String redisKey = RedisCacheKeyEnum.LOGIN_COMPANY_TICKET_CACHE.getKey(ticket);
        redisTemplate.boundValueOps(redisKey)
                .set(companyId, RedisCacheKeyEnum.LOGIN_COMPANY_TICKET_CACHE.getTimeout(), TimeUnit.HOURS);
    }
}
