package com.wms.base.service.service.company.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.wms.base.service.dao.company.CompanyUserRelaMapper;
import com.wms.base.service.model.enums.company.CompanyStatusEnum;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.model.entity.company.CompanyUserRelaEntity;
import com.wms.base.service.model.enums.rela.RelaStatusEnum;
import com.wms.base.service.service.company.CompanyService;
import com.wms.base.service.service.company.CompanyUserRelaService;
import com.wms.singlesignonapi.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:31
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class CompanyUserRelaServiceImpl implements CompanyUserRelaService {

    @Autowired
    private CompanyUserRelaMapper companyUserRelaMapper;

    @Autowired
    private CompanyService companyService;

    @Override
    public void bandCompanyUser(Long companyId, List<Long> userIds) throws BizException {
        AssertUtil.isNotNull(companyId, WmsBaseErrorCodeEnum.COMPANY_ID_IS_NOT_NULL);
        AssertUtil.isNotEmpty(userIds, WmsBaseErrorCodeEnum.COMPANY_USER_IDS_IS_NOT_NULL);
        CompanyEntity company = companyService.getCompanyById(companyId);
        AssertUtil.isNotNull(company, WmsBaseErrorCodeEnum.COMPANY_NOT_EXISTS);
        AssertUtil.isEquals(company.getCompanyStatus(), CompanyStatusEnum.ALLOW_LOGIN.getCode()
                , WmsBaseErrorCodeEnum.COMPANY_IS_FREEZE);

        Long loginUserId = LoginUtil.getUserId();

        List<CompanyUserRelaEntity> needBandRelaList = new ArrayList<>(userIds.size());
        for (Long userId : userIds) {
            CompanyUserRelaEntity entity = new CompanyUserRelaEntity();
            entity.setCompanyId(companyId);
            entity.setUserId(userId);
            entity.setCreateId(loginUserId);
            entity.setStatus(RelaStatusEnum.ALLOW_LOGIN.getCode());
            Date now = new Date();
            entity.setCreateDate(now);
            entity.setUpdateDate(now);
            needBandRelaList.add(entity);

        }
        companyUserRelaMapper.batchInsert(needBandRelaList);
    }

    @Override
    public List<Long> getBandCompanyId() throws BizException {
        Long userId = LoginUtil.getUserId();

       List<CompanyUserRelaEntity> entities = companyUserRelaMapper.selectByUserId(userId,RelaStatusEnum.ALLOW_LOGIN.getCode());


        return entities.stream()
                .map(CompanyUserRelaEntity::getCompanyId)
                .distinct()
                .collect(Collectors.toList());
    }
}
