package com.wms.base.service.dao.company;

import com.wms.base.service.model.entity.company.CompanyEntity;

import java.util.List;

import org.apache.ibatis.annotations.Param;

public interface CompanyMapper {
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
    int insert(CompanyEntity record);

    /**
     * insert record to table selective
     *
     * @param record the record
     * @return insert count
     */
    int insertSelective(CompanyEntity record);

    /**
     * select by primary key
     *
     * @param id primary key
     * @return object by primary key
     */
    CompanyEntity selectByPrimaryKey(Long id);

    /**
     * update record selective
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKeySelective(CompanyEntity record);

    /**
     * update record
     *
     * @param record the updated record
     * @return update count
     */
    int updateByPrimaryKey(CompanyEntity record);

    int updateBatch(List<CompanyEntity> list);

    int updateBatchSelective(List<CompanyEntity> list);

    int batchInsert(@Param("list") List<CompanyEntity> list);

    /**
     * 根据企业编码查找企业
     *
     * @param companyCode
     * @return
     */
    CompanyEntity selectByCompanyCode(@Param("companyCode") String companyCode);

    /**
     * 修改企业状态
     *
     * @param companyId
     * @param status
     * @return
     */
    int updateComPanyStatus(@Param("companyId") Long companyId, @Param("status") Integer status);

    List<CompanyEntity> selectByIds(@Param("companyIds") List<Long> companyIds);
}