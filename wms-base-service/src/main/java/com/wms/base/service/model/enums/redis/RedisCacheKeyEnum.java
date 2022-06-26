package com.wms.base.service.model.enums.redis;


/**
 * redis缓存key枚举
 *
 * @author linzhou
 */

public enum RedisCacheKeyEnum {

    LOGIN_COMPANY_TICKET_CACHE("LOGIN-company-ticket:{ticket}", "登录用户选择的企业缓存", 24 * 60 * 60L),
    LOGIN_WAREHOUSE_TICKET_CACHE("LOGIN-warehouse-ticket:{ticket}", "登录用户选择的仓库缓存", 24 * 60 * 60L),
    COMPANY_BY_ID_CACHE("COMPANY_BY_ID:{companyId}", "企业缓存通过id", 5 * 60L),
    ;
    /**
     * 缓存的key
     */
    private String key;
    /**
     * 备注
     */
    private String msg;
    /**
     * 缓存失效时间单位s
     */
    private Long timeout;

    RedisCacheKeyEnum(String key, String ms, Long timeout) {
        this.key = key;
        this.msg = msg;
        this.timeout = timeout;
    }

    public String getKey(Object... param) {
        return getRedisKey(key, param);
    }

    public String getMsg() {
        return msg;
    }

    public Long getTimeout() {
        return timeout;
    }

    private static String getRedisKey(String str, Object... objects) {
        String rlt = str;
        if (objects != null) {
            for (Object object : objects) {
                rlt = rlt.replaceFirst("\\[.*?]", object == null ? "null" : object.toString());
            }
        }
        return rlt;
    }
}
