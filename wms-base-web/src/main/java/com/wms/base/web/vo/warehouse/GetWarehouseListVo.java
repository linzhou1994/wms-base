package com.wms.base.web.vo.warehouse;

import lombok.Data;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 17:00
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class GetWarehouseListVo {
    /**
     * 企业id
     */
    private Long companyId;
    /**
     * 企业名称
     */
    private String companyName;
    /**
     * 仓库列表
     */
    private List<WarehouseVo> warehouseList;
}
