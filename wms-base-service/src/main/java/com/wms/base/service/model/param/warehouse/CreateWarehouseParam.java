package com.wms.base.service.model.param.warehouse;

import lombok.Data;

/**
 * 仓库表
 */
@Data
public class CreateWarehouseParam {

    /**
     * 仓库名称
     */
    private String warehouseName;
    /**
     * 仓库编码
     */
    private String warehouseCode;


}