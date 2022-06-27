package com.wms.base.service.dao.company;

import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.model.entity.company.CompanyUserRelaEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyUserRelaMapper {
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
    int insert(CompanyUserRelaEntity record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CompanyUserRelaEntity record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CompanyUserRelaEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CompanyUserRelaEntity record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CompanyUserRelaEntity record);

    int updateBatch(List<CompanyUserRelaEntity> list);

    int updateBatchSelective(List<CompanyUserRelaEntity> list);

    int batchInsert(@Param("list") List<CompanyUserRelaEntity> list);

    List<CompanyUserRelaEntity> selectByUserId(@Param("userId") Long userId, @Param("status") Integer status);

    List<CompanyUserRelaEntity> selectByUserIdsAndCompanyId(@Param("userIds") List<Long> userIds, @Param("companyId") Long companyId);

    int updateStatusByUserIdsAndCompanyId(@Param("userIds") List<Long> userIds, @Param("companyId") Long companyId, @Param("status") Integer status);
}