package com.wms.base.api.interceptor.handler;

import com.alibaba.dubbo.config.annotation.Reference;
import com.wms.base.api.model.dto.company.LoginCompanyDTO;
import com.wms.base.api.model.dto.warehouse.LoginWarehouseDTO;
import com.wms.base.api.remote.company.RemoteCompanyService;
import com.wms.base.api.remote.warehouse.RemoteWarehouseService;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.singlesignonapi.annotation.NotLogin;
import com.wms.singlesignonapi.interceptor.handler.LoginHandler;
import org.springframework.core.annotation.AnnotationUtils;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;
import org.springframework.web.method.HandlerMethod;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Objects;

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
@Component
@Order(10)
public class CompanyWarehouseHandler implements LoginHandler {

    @Reference
    private RemoteCompanyService remoteCompanyService;
    @Reference
    private RemoteWarehouseService remoteWarehouseService;

    @Override
    public void preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if (handler instanceof HandlerMethod) {
            HandlerMethod method = (HandlerMethod) handler;
            NotLogin notLogin = AnnotationUtils.findAnnotation(method.getMethod(), NotLogin.class);
            if (Objects.nonNull(notLogin)) {
                return;
            }
            LoginCompanyDTO loginCompany = remoteCompanyService.getLoginCompany();
            LoginWarehouseDTO loginWarehouse = remoteWarehouseService.getLoginWarehouse();
            LoginWarehouseUtils.setLoginWarehouse(loginWarehouse);
            LoginWarehouseUtils.setLoginCompany(loginCompany);
        }
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        LoginWarehouseUtils.remove();
    }
}
