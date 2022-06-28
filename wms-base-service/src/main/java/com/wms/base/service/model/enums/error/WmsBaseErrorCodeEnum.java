package com.wms.base.service.model.enums.error;

import com.java.utils.enums.SystemEnum;
import com.java.utils.exception.ErrorCode;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 15:14
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
public enum WmsBaseErrorCodeEnum implements ErrorCode {


    /****************10开头企业相关错误码*******************/
    COMPANY_CODE_ALREADY_EXISTS("100001", "企业编码已存在"),
    COMPANY_CODE_IS_NOT_BLANK("100002", "企业编码不能为空"),
    COMPANY_TYPE_IS_NOT_NULL("100003", "企业类型不能为空"),
    COMPANY_NAME_IS_NOT_NULL("100004", "企业名称不能为空"),
    COMPANY_ID_IS_NOT_NULL("100005", "企业id不能为空"),
    COMPANY_USER_IDS_IS_NOT_NULL("100006", "企业员工不能为空"),
    COMPANY_NOT_EXISTS("100007", "企业不存在"),
    COMPANY_IS_FREEZE("100008", "企业已不可用"),
    USER_IS_NOT_COMPANY_STAFF("100009", "您不是该企业的员工"),


    /*****************20开头仓库相关错误码***************/
    USER_IS_NOT_WAREHOUSE_STAFF("200001", "您不是该仓库的员工"),
    WAREHOUSE_IS_FREEZE("200002", "该仓库不可用"),
    WAREHOUSE_NOT_EXISTS("200003", "仓库不存在"),
    WAREHOUSE_NAME_IS_NOT_BLANK("200004","仓库名称不能为空"),
    WAREHOUSE_CODE_IS_NOT_BLANK("200005","仓库编码不能为空"),
    WAREHOUSE_CODE_EXISTS("200006","仓库编码已存在"),
    WAREHOUSE_USER_IDS_IS_NOT_NULL("100007", "仓库员工不能为空"),
    WAREHOUSE_COMPANY_IDS_NOT_NULL("100008", "仓库供应商不能为空"),

    ;
    private String code;
    private String msg;

    WmsBaseErrorCodeEnum(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    @Override
    public String getCode() {
        return SystemEnum.SSO_SYSTEM.getCode() + this.code;
    }

    @Override
    public String getMsg() {
        return this.msg;
    }
}
