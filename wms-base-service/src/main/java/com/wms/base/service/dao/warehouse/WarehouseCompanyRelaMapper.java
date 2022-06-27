package com.wms.base.service.dao.warehouse;

import com.wms.base.service.model.entity.warehouse.WarehouseCompanyRelaEntity;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface WarehouseCompanyRelaMapper {
    /**
     * delete by primary key
     * @param id primaryKey
     * @return deleteCount
     */
    int deleteByPrimaryKey(Long id);

    /**
     * insert record to table
     * @param record the record
     * @return insert count
     */
    int insert(WarehouseCompanyRelaEntity record);

    /**
     * insert record to table selective
     * @param record the record
     * @return insert count
     */
    int insertSelective(WarehouseCompanyRelaEntity record);

    /**
     * select by primary key
     * @param id primary key
     * @return object by primary key
     */
    WarehouseCompanyRelaEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(WarehouseCompanyRelaEntity record);

    /**
     * update record
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(WarehouseCompanyRelaEntity record);

    int updateBatch(List<WarehouseCompanyRelaEntity> list);

    int updateBatchSelective(List<WarehouseCompanyRelaEntity> list);

    int batchInsert(@Param("list") List<WarehouseCompanyRelaEntity> list);
}