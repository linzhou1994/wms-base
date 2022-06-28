package com.wms.base.service.service.warehouse;

import com.java.utils.exception.BizException;

import java.util.List;

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
 * @date : 2022/6/28 22:32
 * @author: linzhou
 * @description : WarehouseCompanyRelaService
 */
public interface WarehouseCompanyRelaService {

    /**
     * 当前仓库绑定供应商企业
     *
     * @param companyIds 供应商id集合
     */
    void bandCompanyList(List<Long> companyIds) throws BizException;

    /**
     * 前仓库绑定供应商企业
     *
     * @param warehouseId
     * @param companyIds
     */
    void bandCompanyList(Long warehouseId, List<Long> companyIds) throws BizException;

    /**
     * 当前仓库解除供应商企业绑定关系
     *
     * @param companyIds 供应商id集合
     */
    void unBandCompanyList(List<Long> companyIds) throws BizException;

    /**
     * 仓库解除供应商企业绑定关系
     *
     * @param warehouseId
     * @param companyIds
     */
    void unBandCompanyList(Long warehouseId, List<Long> companyIds) throws BizException;
}
