package com.wms.base.service.dao.warehouse;

import com.wms.base.service.model.entity.warehouse.WarehouseUserRelaEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface WarehouseUserRelaMapper {
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
    int insert(WarehouseUserRelaEntity record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(WarehouseUserRelaEntity record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    WarehouseUserRelaEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WarehouseUserRelaEntity record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WarehouseUserRelaEntity record);

    int updateBatch(List<WarehouseUserRelaEntity> list);

    int updateBatchSelective(List<WarehouseUserRelaEntity> list);

    int batchInsert(@Param("list") List<WarehouseUserRelaEntity> list);

    List<WarehouseUserRelaEntity> selectByUserId(@Param("userId") Long userId);
}