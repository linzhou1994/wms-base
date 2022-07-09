package com.wms.base.service.remote.impl.stock;

import com.spring.dubbo.annotation.RpcService;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.api.model.dto.stock.StockAreaDTO;
import com.wms.base.api.remote.stock.RemoteStockAreaService;
import com.wms.base.service.model.entity.stock.StockAreaEntity;
import com.wms.base.service.service.stock.StockAreaService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @date : 2022/7/6 23:26
 * @author: linzhou
 * @description : RemoteStockAreaServiceImpl
 */
@RpcService
public class RemoteStockAreaServiceImpl implements RemoteStockAreaService {
    @Autowired
    private StockAreaService service;

    @Override
    public StockAreaDTO getStockAreaById(Long id) {
        StockAreaEntity areaEntity = service.getById(id);
        return BeanCopy.copy(areaEntity, StockAreaDTO.class);
    }

    @Override
    public List<StockAreaDTO> getStockAreaByIds(List<Long> ids) {
        List<StockAreaEntity> areaEntityList = service.getByIds(ids);
        return BeanCopy.copyList(areaEntityList, StockAreaDTO.class);
    }

    @Override
    public StockAreaDTO getStockAreaByAreaCode(Long warehouseId, String areaCode) {
        StockAreaEntity areaEntity = service.getStockAreaByAreaCode(warehouseId,areaCode);
        return BeanCopy.copy(areaEntity, StockAreaDTO.class);
    }

    @Override
    public List<StockAreaDTO> getStockAreaByAreaCodes(Long warehouseId, List<String> areaCodes) {
        List<StockAreaEntity> areaEntityList = service.getStockAreaByAreaCodes(warehouseId,areaCodes);
        return BeanCopy.copyList(areaEntityList, StockAreaDTO.class);
    }
}
