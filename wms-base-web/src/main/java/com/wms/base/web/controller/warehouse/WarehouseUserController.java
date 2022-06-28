package com.wms.base.web.controller.warehouse;

import com.java.utils.exception.BizException;
import com.java.utils.result.Result;
import com.wms.base.service.service.warehouse.WarehouseUserRelaService;
import com.wms.base.web.request.IdsRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仓库员工管理
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
@RequestMapping("warehouse/user")
public class WarehouseUserController {

    @Autowired
    private WarehouseUserRelaService warehouseUserRelaService;

    /**
     * 仓库绑定员工
     *
     * @param idsRequest
     * @return
     * @throws BizException
     */
    @PostMapping("bandUserList")
    public Result bandUserList(@RequestBody IdsRequest idsRequest) throws BizException {
        warehouseUserRelaService.bandWarehouseUser(idsRequest.getIds());
        return Result.success();
    }

    /**
     * 仓库解除员工
     *
     * @param idsRequest
     * @return
     * @throws BizException
     */
    @PostMapping("unBandUserList")
    public Result unBandUserList(@RequestBody IdsRequest idsRequest) throws BizException {
        warehouseUserRelaService.unBandWarehouseUser(idsRequest.getIds());
        return Result.success();
    }


}
