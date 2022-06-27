package com.wms.base.service.service.warehouse.impl;

import com.java.utils.exception.BizException;
import com.wms.base.service.dao.warehouse.WarehouseUserRelaMapper;
import com.wms.base.service.model.entity.warehouse.WarehouseUserRelaEntity;
import com.wms.base.service.model.enums.rela.RelaStatusEnum;
import com.wms.base.service.service.warehouse.WarehouseUserRelaService;
import com.wms.singlesignonapi.utils.LoginUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * CopyRight : <company domain>
 * Project :  wms-base
 * Comments : <对此类的描述，可以引用系统设计中的描述>
 * JDK version : JDK1.8
 * Create Date : 2022-06-27 11:40
 *
 * @author : linzhou
 * @version : 1.0
 * @since : 1.0
 */
@Service
public class WarehouseUserRelaServiceImpl implements WarehouseUserRelaService {
    @Autowired
    private WarehouseUserRelaMapper warehouseUserRelaMapper;
    @Override
    public List<WarehouseUserRelaEntity> getBandWarehouseIds() throws BizException {
        Long userId = LoginUtil.getUserId();
        return warehouseUserRelaMapper.selectByUserId(userId)
                .stream()
                .filter(o-> Objects.equals(o.getStatus(), RelaStatusEnum.ALLOW_LOGIN.getCode()))
                .collect(Collectors.toList());
    }
}
