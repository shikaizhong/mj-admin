package com.mj.dao.repository;

import com.mj.dao.entity.Files;
import com.mj.dao.entity.Refund;
import com.mj.dao.vo.RefundVo;

import java.util.List;
import java.util.Map;

public interface RefundMapper {
    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int deleteByPrimaryKey(Integer refundId);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int insert(Refund record);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int insertSelective(Refund record);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    Refund selectByPrimaryKey(Integer pkId);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int updateByPrimaryKeySelective(Refund record);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int updateByPrimaryKeyWithBLOBs(Refund record);

    /**
     * @mbg.generated 2019-08-08 14:15:51
     */
    int updateByPrimaryKey(Refund record);

    //查询分页加搜索
//    List<RefundVo> selectRefund(Map params);

    //查询t_refund表中所有数据
//    List<RefundVo> selectRefundAll(Map params);

    //查询分页加搜索
    List<Refund> selectRefundList(Map params);

    //查询总记录数
    Integer selectRefundCount(Map params);

    /*批量删除*/
    int deleteBatch(Integer[] pkId);

    //根据用户名查询相应的历史记录
    List<Refund> selectInfoByWangWangNum(String wangWangNum);

    //根据pk_id查询详情
    List<Refund> selectInfoByPkId(Map params);

    //根据refundId查询历史记录
    List<Files> selectFiles(Map params);

    //修改客诉类别
    int updateAll(RefundVo refundVo);
    //查看
    RefundVo selectBy(Integer pkId);
}