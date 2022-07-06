package com.wms.base.service.remote.impl.stock;

import com.alibaba.dubbo.config.annotation.Service;
import com.spring.utils.bean.BeanCopy;
import com.wms.base.api.model.dto.stock.StockAreaDTO;
import com.wms.base.api.remote.stock.RemoteStockAreaService;
import com.wms.base.service.model.entity.stock.StockAreaEntity;
import com.wms.base.service.service.stock.StockAreaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

/**
 * @date : 2022/7/6 23:26
 * @author: linzhou
 * @description : RemoteStockAreaServiceImpl
 */
@Service
@Component
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
}
