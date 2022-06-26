package com.wms.base.web.controller.warehouse;

import com.java.utils.result.Result;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.api.annotation.NotLoginCompany;
import com.wms.base.api.annotation.NotLoginWarehouse;
import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;
import com.wms.base.service.service.warehouse.WarehouseService;
import com.wms.base.web.request.IdRequest;
import com.wms.base.web.vo.warehouse.GetWarehouseListVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 仓库管理
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
@RequestMapping("warehouse")
public class WarehouseController {

    @Autowired
    private WarehouseService warehouseService;

    /**
     * 获取当前用户的仓库列表
     *
     * @return
     */
    @NotLoginCompany
    @RequestMapping("getWareHouseList")
    public Result<List<GetWarehouseListVo>> getWareHouseList() {
        List<GetWarehouseListDTO> warehouseList = warehouseService.getWarehouseListDTO();
        return Result.success(BeanCopy.copyList(warehouseList, GetWarehouseListVo.class));
    }

    /**
     * 登录用户选择登陆的仓库
     *
     * @param idRequest 要选择的仓库id
     * @return
     */
    @NotLoginCompany
    @RequestMapping("chooseWareHouse")
    public Result chooseWareHouse(@RequestBody IdRequest idRequest) {
        warehouseService.chooseWareHouse(idRequest.getId());
        return Result.success();
    }


}
