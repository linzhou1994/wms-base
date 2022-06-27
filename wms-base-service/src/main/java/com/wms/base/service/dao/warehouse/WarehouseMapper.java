package com.wms.base.service.dao.warehouse;

import com.wms.base.service.model.entity.warehouse.WarehouseEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarehouseMapper {
    /**
     * delete by primary key
     *
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     *
     * @param record the record
     * @return insert count
     */
    int insert(WarehouseEntity record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(WarehouseEntity record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    WarehouseEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WarehouseEntity record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WarehouseEntity record);

    int updateBatch(List<WarehouseEntity> list);

    int updateBatchSelective(List<WarehouseEntity> list);

    int batchInsert(@Param("list") List<WarehouseEntity> list);

    List<WarehouseEntity> selectByIds(@Param("warehouseIds") List<Long> warehouseIds);

    WarehouseEntity selectByWarehouseCode(@Param("warehouseCode") String warehouseCode);
}