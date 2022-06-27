package com.wms.base.web.request.warehouse;

import lombok.Data;

/**
 * 仓库表
 */
@Data
public class CreateWarehouseRequest {

    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库编码
     */
    private String warehouseCode;


}