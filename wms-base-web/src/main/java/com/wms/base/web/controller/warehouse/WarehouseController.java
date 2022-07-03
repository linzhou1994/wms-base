package com.wms.base.web.controller.warehouse;

import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.spring.utils.http.result.Result;
import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;
import com.wms.base.service.model.param.warehouse.CreateWarehouseParam;
import com.wms.base.service.service.warehouse.WarehouseService;
import com.wms.base.web.request.IdRequest;
import com.wms.base.web.request.warehouse.CreateWarehouseRequest;
import com.wms.base.web.vo.warehouse.GetWarehouseListVO;
import com.wms.base.web.vo.warehouse.WarehouseVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
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
    @RequestMapping("getWarehouseList")
    public Result<List<GetWarehouseListVO>> getWarehouseList() throws BizException {
        List<GetWarehouseListDTO> warehouseList = warehouseService.getWarehouseListDTO();
        List<GetWarehouseListVO> data = new ArrayList<>();
        for (GetWarehouseListDTO dto : warehouseList) {
            GetWarehouseListVO copy = BeanCopy.copy(dto, GetWarehouseListVO.class);
            copy.setWarehouseList(BeanCopy.copyList(dto.getWarehouseList(), WarehouseVO.class));
            data.add(copy);
        }


        return Result.success(data);
    }

    /**
     * 登录用户选择登陆的仓库
     *
     * @param idRequest 要选择的仓库id
     * @return
     */
    @PostMapping("chooseWarehouse")
    public Result chooseWarehouse(@RequestBody IdRequest idRequest) throws BizException {
        warehouseService.chooseWarehouse(idRequest.getId());
        return Result.success();
    }

    /**
     * 创建企业
     *
     * @param request
     * @return
     * @throws BizException
     */
    @PostMapping("createWarehouse")
    private Result<Long> createWarehouse(@RequestBody CreateWarehouseRequest request) throws BizException {
        Long warehouse = warehouseService.createWarehouse(BeanCopy.copy(request, CreateWarehouseParam.class));
        return Result.success(warehouse);
    }

}
