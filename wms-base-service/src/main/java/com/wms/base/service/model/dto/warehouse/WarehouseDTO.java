package com.wms.base.service.model.dto.warehouse;

import lombok.Data;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 17:01
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class WarehouseDTO {
    /**
     * 仓库id
     */
    private Long id;
    /**
     * 仓库名称
     */
    private String warehouseName;
}
