package com.wms.base.service.remote.impl.stock;

import com.spring.dubbo.annotation.RpcService;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.api.model.dto.stock.StockPositionDTO;
import com.wms.base.api.remote.stock.RemoteStockPositionService;
import com.wms.base.service.model.entity.stock.StockPositionEntity;
import com.wms.base.service.service.stock.StockPositionService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @date : 2022/7/6 23:33
 * @author: linzhou
 * @description : RemoteStockPositionServiceImpl
 */
@RpcService
public class RemoteStockPositionServiceImpl implements RemoteStockPositionService {
    @Autowired
    private StockPositionService stockPositionService;

    @Override
    public StockPositionDTO getStockPositionById(Long id) {
        StockPositionEntity entity = stockPositionService.getById(id);
        return BeanCopy.copy(entity, StockPositionDTO.class);
    }

    @Override
    public List<StockPositionDTO> getStockPositionByIds(List<Long> ids) {
        List<StockPositionEntity> positionEntities = stockPositionService.getByIds(ids);
        return BeanCopy.copyList(positionEntities, StockPositionDTO.class);
    }

    @Override
    public StockPositionDTO getStockPositionByCode(Long warehouseId, String stockPositionCode) {
        StockPositionEntity entity = stockPositionService.getStockPositionByCode(warehouseId,stockPositionCode);
        return BeanCopy.copy(entity, StockPositionDTO.class);
    }

    @Override
    public List<StockPositionDTO> getStockPositionByCodes(Long warehouseId, List<String> stockPositionCodes) {
        List<StockPositionEntity> positionEntities = stockPositionService.getStockPositionByCodes(warehouseId,stockPositionCodes);
        return BeanCopy.copyList(positionEntities, StockPositionDTO.class);
    }
}
