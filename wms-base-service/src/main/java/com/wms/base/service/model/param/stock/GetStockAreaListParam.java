package com.wms.base.service.model.param.stock;

import com.spring.utils.http.request.PageRequest;
import lombok.Data;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-07-03 16:46
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class GetStockAreaListParam extends PageRequest {
    /**
     * 库区编号
     */
    private String areaCode;

    /**
     * 库区名称
     */
    private String areaName;
}
