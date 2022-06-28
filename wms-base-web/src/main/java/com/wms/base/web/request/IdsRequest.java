package com.wms.base.web.request;

import lombok.Data;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 16:14
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class IdsRequest {
    /**
     * 业务ids
     */
    private List<Long> ids;
}
