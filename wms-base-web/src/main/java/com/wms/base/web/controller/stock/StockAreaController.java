package com.wms.base.web.controller.stock;

import com.java.utils.exception.BizException;
import com.java.utils.result.Result;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.service.model.dto.stock.StockAreaDTO;
import com.wms.base.service.model.param.stock.SaveStockAreaParam;
import com.wms.base.service.service.stock.StockAreaService;
import com.wms.base.web.request.stock.SaveStockAreaRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库区管理
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-29 13:31
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@RestController
@RequestMapping("stock/area")
public class StockAreaController {

    @Autowired
    private StockAreaService stockAreaService;

    /**
     * 保存或者创建库区
     *
     * @param request
     * @return
     * @throws BizException
     */
    @PostMapping("saveStockAreas")
    public Result<StockAreaDTO> saveStockAreas(@RequestBody SaveStockAreaRequest request) throws BizException {

        SaveStockAreaParam param = BeanCopy.copy(request, SaveStockAreaParam.class);

        StockAreaDTO stockAreaDTO = stockAreaService.saveStockAreas(param);
        return Result.success(stockAreaDTO);
    }
}
