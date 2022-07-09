package com.wms.base.web.controller.stock;

import com.java.utils.exception.BizException;
import com.spring.utils.bean.BeanCopy;
import com.spring.utils.http.result.PageResult;
import com.spring.utils.http.result.Result;
import com.wms.base.service.model.entity.stock.StockPositionEntity;
import com.wms.base.service.model.param.stock.AddStockPositionBatchItemParam;
import com.wms.base.service.model.param.stock.GetStockPositionParam;
import com.wms.base.service.model.param.stock.UpdateStockPositionParam;
import com.wms.base.service.service.stock.StockPositionService;
import com.wms.base.web.request.stock.AddStockPositionBatchItemRequest;
import com.wms.base.web.request.stock.GetStockPositionRequest;
import com.wms.base.web.request.stock.UpdateStockPositionRequest;
import com.wms.base.web.vo.stock.StockPositionVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 库位管理
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-07-03 16:17
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@RestController
@RequestMapping("stock/position")
public class StockPositionController {

    @Autowired
    private StockPositionService stockPositionService;

    /**
     * 批量添加库位
     *
     * @param requests
     * @return
     */
    @PostMapping("addBatch")
    public Result addStockPositionBatch(@RequestBody List<AddStockPositionBatchItemRequest> requests) throws BizException {

        List<AddStockPositionBatchItemParam> params = BeanCopy.copyList(requests, AddStockPositionBatchItemParam.class);
        stockPositionService.addStockPositionBatch(params);
        return Result.success();

    }

    /**
     * 修改库位
     *
     * @param request
     * @return
     */
    @PostMapping("update")
    public Result update(@RequestBody UpdateStockPositionRequest request) throws BizException {
        UpdateStockPositionParam param = BeanCopy.copy(request, UpdateStockPositionParam.class);
        stockPositionService.update(param);
        return Result.success();
    }

    /**
     * 分页查询库位信息
     *
     * @return
     */
    @PostMapping("getStockPositionList")
    public Result<PageResult<StockPositionVO>> getStockPositionList(@RequestBody GetStockPositionRequest request) throws BizException {

        GetStockPositionParam param = BeanCopy.copy(request, GetStockPositionParam.class);

        PageResult<StockPositionEntity> pageResult = stockPositionService.getStockPositionList(param);
        return Result.success(PageResult.build(pageResult, StockPositionVO.class));
    }


}
