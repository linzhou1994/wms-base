package com.wms.base.service.dao.stock;

import com.wms.base.service.model.entity.stock.StockAreaEntity;

import java.util.List;

import com.wms.base.service.model.param.stock.GetStockAreaListParam;
import org.apache.ibatis.annotations.Param;

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
 * @date : 2022/6/28 23:13
 * @author: linzhou
 * @description : StockAreaMapper
 */
public interface StockAreaMapper {
    int deleteByPrimaryKey(Long id);

    int insert(StockAreaEntity record);

    int insertSelective(StockAreaEntity record);

    StockAreaEntity selectByPrimaryKey(Long id);

    int updateByPrimaryKeySelective(StockAreaEntity record);

    int updateByPrimaryKey(StockAreaEntity record);

    int updateBatch(List<StockAreaEntity> list);

    int updateBatchSelective(List<StockAreaEntity> list);

    int batchInsert(@Param("list") List<StockAreaEntity> list);

    List<StockAreaEntity> getStockAreaList(@Param("param") GetStockAreaListParam param, @Param("warehouseId") Long warehouseId);

    Long getStockAreaListCount(@Param("param") GetStockAreaListParam param, @Param("warehouseId") Long warehouseId);

    List<StockAreaEntity> selectByIds(@Param("ids") List<Long> ids);
}