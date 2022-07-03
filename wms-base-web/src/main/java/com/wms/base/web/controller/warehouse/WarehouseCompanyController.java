package com.wms.base.web.controller.warehouse;

import com.java.utils.exception.BizException;
import com.spring.utils.http.result.Result;
import com.wms.base.service.service.warehouse.WarehouseCompanyRelaService;
import com.wms.base.web.request.IdsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仓库供应商管理
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 16:58
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@RestController
@RequestMapping("warehouse/company")
public class WarehouseCompanyController {

    @Autowired
    private WarehouseCompanyRelaService warehouseCompanyRelaService;

    /**
     * 仓库绑定供应商企业
     *
     * @param idsRequest 供应商企业id
     * @return
     */
    @PostMapping("bandCompanyList")
    public Result bandCompanyList(@RequestBody IdsRequest idsRequest) throws BizException {
        warehouseCompanyRelaService.bandCompanyList(idsRequest.getIds());
        return Result.success();
    }

    /**
     * 仓库解除供应商企业绑定关系
     *
     * @param idsRequest 供应商企业id
     * @return
     */
    @PostMapping("unBandCompanyList")
    public Result unBandCompanyList(@RequestBody IdsRequest idsRequest) throws BizException {
        warehouseCompanyRelaService.unBandCompanyList(idsRequest.getIds());
        return Result.success();
    }


}
