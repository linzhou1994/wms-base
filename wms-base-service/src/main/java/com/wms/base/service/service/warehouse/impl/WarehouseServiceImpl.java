package com.wms.base.service.service.warehouse.impl;

import com.wms.base.service.model.dto.warehouse.GetWarehouseListDTO;
import com.wms.base.service.service.warehouse.WarehouseService;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-26 18:04
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class WarehouseServiceImpl implements WarehouseService {
    @Override
    public List<GetWarehouseListDTO> getWarehouseListDTO() {

        return null;
    }

    @Override
    public void chooseWareHouse(Long warehouseId) {

    }
}
