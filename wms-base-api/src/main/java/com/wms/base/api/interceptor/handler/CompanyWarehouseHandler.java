package com.wms.base.api.interceptor.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.alibaba.dubbo.config.annotation.Service;
import com.example.singlesignonapi.interceptor.handler.LoginHandler;
import com.wms.base.api.remote.company.RemoteCompanyService;
import org.springframework.beans.factory.annotation.Autowired;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 20:22
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class CompanyWarehouseHandler implements LoginHandler {

    @Reference
    private RemoteCompanyService remoteCompanyService;

    @Override
    public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        LoginHandler.super.preHandle(request, response, handler);
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginHandler.super.afterCompletion(request, response, handler, ex);
    }
}
