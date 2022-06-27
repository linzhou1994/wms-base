package com.wms.base.web;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 13:57
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@SpringBootApplication
@ComponentScan(basePackages = {"com.wms.base"})
@MapperScan("com.wms.base.service.dao")
public class WmsBaseWebApplication {
    public static void main(String[] args) {
        SpringApplication.run(WmsBaseWebApplication.class, args);
    }
}
