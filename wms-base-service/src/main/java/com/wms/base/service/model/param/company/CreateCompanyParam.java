package com.wms.base.service.model.param.company;

import lombok.Data;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:02
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class CreateCompanyParam {
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
    private List<Integer> companyType;
}
