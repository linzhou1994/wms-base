package com.wms.base.service.dao.stock;

import com.wms.base.service.model.entity.stock.StockPositionEntity;

import java.util.List;

import com.wms.base.service.model.param.stock.GetStockPositionParam;
import org.apache.ibatis.annotations.Param;

/**
 * @author linzhou
 */
public interface StockPositionMapper {
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
    int insert(StockPositionEntity record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(StockPositionEntity record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    StockPositionEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(StockPositionEntity record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(StockPositionEntity record);

    int updateBatch(List<StockPositionEntity> list);

    int updateBatchSelective(List<StockPositionEntity> list);

    int batchInsert(@Param("list") List<StockPositionEntity> list);

    List<StockPositionEntity> getStockPositionList(@Param("param") GetStockPositionParam param, @Param("warehouseId") Long warehouseId);

    Long getStockPositionListCount(@Param("param") GetStockPositionParam param, @Param("warehouseId") Long warehouseId);

    List<StockPositionEntity> selectByIds(@Param("ids") List<Long> ids);
}