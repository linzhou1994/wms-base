package com.wms.base.web.request.stock;

import com.spring.utils.http.request.PageRequest;
import lombok.Data;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-07-03 18:24
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Data
public class GetStockPositionRequest extends PageRequest {
    /**
     * 库区id
     */
    private List<Long> stockAreaIds;

    /**
     * 库位编码
     */
    private String stockPositionCode;

    /**
     * 库位名称
     */
    private String stockPositionName;

    /**
     * 是否允许混放 1:是 0：否
     */
    private Integer isMixed;

    /**
     * 库区状态 0：正常 1：冻结 2：删除
     */
    private Integer status;

    /**
     * 库位类型：1 正常库位 2 残次库位 3 虚拟库位 4 暂存库位
     */
    private Integer stockPositionType;
}
