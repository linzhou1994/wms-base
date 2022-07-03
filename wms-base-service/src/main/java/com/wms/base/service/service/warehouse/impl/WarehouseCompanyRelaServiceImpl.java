package com.wms.base.service.service.warehouse.impl;

import com.java.utils.assertutil.AssertUtil;
import com.java.utils.exception.BizException;
import com.wms.base.api.utils.LoginWarehouseUtils;
import com.wms.base.service.dao.warehouse.WarehouseCompanyRelaMapper;
import com.wms.base.service.model.entity.company.CompanyEntity;
import com.wms.base.service.model.entity.warehouse.WarehouseCompanyRelaEntity;
import com.wms.base.service.model.entity.warehouse.WarehouseEntity;
import com.wms.base.service.model.enums.company.CompanyTypeEnum;
import com.wms.base.service.model.enums.error.WmsBaseErrorCodeEnum;
import com.wms.base.service.model.enums.rela.RelaStatusEnum;
import com.wms.base.service.service.company.CompanyService;
import com.wms.base.service.service.warehouse.WarehouseCompanyRelaService;
import com.wms.base.service.service.warehouse.WarehouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

/**
 * ////////////////////////////////////////////////////////////////////
 * //                          _ooOoo_                               //
 * //                         o8888888o                              //
 * //                         88" . "88                              //
 * //                         (| ^_^ |)                              //
 * //                         O\  =  /O                              //
 * //                      ____/`---'\____                           //
 * //                    .'  \\|     |//  `.                         //
 * //                   /  \\|||  :  |||//  \                        //
 * //                  /  _||||| -:- |||||-  \                       //
 * //                  |   | \\\  -  /// |   |                       //
 * //                  | \_|  ''\---/''  |   |                       //
 * //                  \  .-\__  `-`  ___/-. /                       //
 * //                ___`. .'  /--.--\  `. . ___                     //
 * //              ."" '<  `.___\_<|>_/___.'  >'"".                  //
 * //            | | :  `- \`.;`\ _ /`;.`/ - ` : | |                 //
 * //            \  \ `-.   \_ __\ /__ _/   .-` /  /                 //
 * //      ========`-.____`-.___\_____/___.-`____.-'========         //
 * //                           `=---='                              //
 * //      ^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^^        //
 * //         佛祖保佑           永无BUG           永不修改              //
 * //          佛曰:                                                  //
 * //                 写字楼里写字间，写字间里程序员;                      //
 * //                 程序人员写程序，又拿程序换酒钱.                      //
 * //                 酒醒只在网上坐，酒醉还来网下眠;                      //
 * //                 酒醉酒醒日复日，网上网下年复年.                      //
 * //                 但愿老死电脑间，不愿鞠躬老板前;                      //
 * //                 奔驰宝马贵者趣，公交自行程序员.                      //
 * //                 别人笑我忒疯癫，我笑自己命太贱;                      //
 * //                 不见满街漂亮妹，哪个归得程序员?                      //
 * ////////////////////////////////////////////////////////////////////
 *
 * @date : 2022/6/28 22:33
 * @author: linzhou
 * @description : 仓库与企业关联处理
 */
@Service
@Slf4j
public class WarehouseCompanyRelaServiceImpl implements WarehouseCompanyRelaService {

    @Autowired
    private WarehouseCompanyRelaMapper warehouseCompanyRelaMapper;
    @Autowired
    private WarehouseService warehouseService;
    @Autowired
    private CompanyService companyService;

    @Override
    public void bandCompanyList(List<Long> companyIds) throws BizException {
        Long warehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        bandCompanyList(warehouseId, companyIds);
    }

    @Override
    public void bandCompanyList(Long warehouseId, List<Long> companyIds) throws BizException {
        AssertUtil.isNotEmpty(companyIds, WmsBaseErrorCodeEnum.WAREHOUSE_COMPANY_IDS_NOT_NULL);
        WarehouseEntity warehouse = warehouseService.getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);

        List<CompanyEntity> companyList = companyService.getCompanyByIds(companyIds)
                .stream()
                .filter(o -> Objects.equals(o.getCompanyType(), CompanyTypeEnum.SUPPLIER.getCode()))
                .collect(Collectors.toList());
        AssertUtil.isNotEmpty(companyList, WmsBaseErrorCodeEnum.WAREHOUSE_COMPANY_IDS_NOT_NULL);

        List<Long> needBandCompanyIds = companyList.stream()
                .map(CompanyEntity::getId)
                .collect(Collectors.toList());

        Long loginUserId = LoginWarehouseUtils.getUserId();
        Date now = new Date();

        List<WarehouseCompanyRelaEntity> needInsertList = new ArrayList<>(needBandCompanyIds.size());
        for (Long companyId : needBandCompanyIds) {
            WarehouseCompanyRelaEntity entity = new WarehouseCompanyRelaEntity();
            entity.setCompanyId(companyId);
            entity.setWarehouseId(warehouseId);
            entity.setStatus(RelaStatusEnum.ENABLE.getCode());
            entity.setCreateId(loginUserId);
            entity.setCreateDate(now);
            entity.setUpdateDate(now);
            needInsertList.add(entity);
        }

        warehouseCompanyRelaMapper.batchInsert(needInsertList);
    }

    @Override
    public void unBandCompanyList(List<Long> companyIds) throws BizException {
        Long warehouseId = LoginWarehouseUtils.getLoginWarehouseId();
        unBandCompanyList(warehouseId, companyIds);
    }

    @Override
    public void unBandCompanyList(Long warehouseId, List<Long> companyIds) throws BizException {
        AssertUtil.isNotEmpty(companyIds, WmsBaseErrorCodeEnum.WAREHOUSE_COMPANY_IDS_NOT_NULL);
        WarehouseEntity warehouse = warehouseService.getWarehouseById(warehouseId);
        AssertUtil.isNotNull(warehouse, WmsBaseErrorCodeEnum.WAREHOUSE_NOT_EXISTS);

        warehouseCompanyRelaMapper.updateStatusByWarehouseIdAndCompanyIds(RelaStatusEnum.FREEZE.getCode(), warehouseId,companyIds);
    }
}
