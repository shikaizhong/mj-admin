package com.mj.dao.repository;

import com.mj.dao.entity.Responsibility;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.vo.ResponsibilityVo;

import java.util.List;
import java.util.Map;

public interface ResponsibilityMapper {
    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int insert(ResponsibilityWithBLOBs record);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int insertSelective(ResponsibilityWithBLOBs record);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    ResponsibilityWithBLOBs selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int updateByPrimaryKeySelective(ResponsibilityWithBLOBs record);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int updateByPrimaryKeyWithBLOBs(ResponsibilityWithBLOBs record);

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    int updateByPrimaryKey(Responsibility record);
    //查重
    ResponsibilityWithBLOBs selectByComplaintId(Integer complaintId);
    //查询加搜索
    List<ResponsibilityVo> selectResponsiblity(Map params);
//    <!--type为0时,查询投诉信息-->
    List<ResponsibilityVo> selectResponsiblityList(Map params);
//    type为1时,查询隐患信息
    List<ResponsibilityVo> selectHiddenTrouble(Map params);
//    type为2时,查询退款管理
    List<ResponsibilityVo> selectRefund(Map params);
    //使用分页插件来分页
    //测试分页插件
    List<Responsibility> page();
    //投诉总记录数
    Integer selectComplaintCount(Map params);
}