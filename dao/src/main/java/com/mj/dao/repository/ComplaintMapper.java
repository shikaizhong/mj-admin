package com.mj.dao.repository;

import com.mj.dao.entity.Complaint;
import com.mj.dao.entity.Files;
import com.mj.dao.vo.ComplaintVo;
import com.mj.dao.vo.Complaints;
import com.mj.dao.vo.ResponsibilityVo;

import java.util.List;
import java.util.Map;

public interface ComplaintMapper {
    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int insert(Complaint record);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int insertSelective(Complaint record);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    Complaint selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int updateByPrimaryKeySelective(Complaint complaint);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int updateByPrimaryKeyWithBLOBs(Complaint record);

    /**
     *
     * @mbg.generated 2019-07-18 14:53:14
     */
    int updateByPrimaryKey(Complaint record);
    //查询分页加搜索
    List<ComplaintVo> selectComplaint(Map params);
    //查询分页加搜索改进版
    List<ComplaintVo> selectComplaintList(Map params);
    //查询总记录数
    Integer selectComplaintCount(Map params);
    //查询指定旺旺反馈总数
    Integer sumCustomerComplaint(String wangwangnum);
    /*批量删除*/
    int deleteBatch(Integer[] pkId);
    //根据用户名查询相应的历史记录
    List<ComplaintVo> selectInfoByWangWangNum(Map params);
    //根据complaintId查询历史记录
    List<Files> selectFiles(Map params);
    //根据大类查询
    List<Complaints> selectLevel();
    int deleteFile(String removeUrl);

    //根据id查询
    List<ComplaintVo> selectById(Map params);


    //通过wangwangnum查询投诉信息
    List<ResponsibilityVo> selelctComplaintByWangWangNum(Map params);
    //通过wangwangnum查询隐患信息
    List<ResponsibilityVo> selectHiddenByWangWangNum(Map params);
    //通过wangwangnum查询退款信息
    List<ResponsibilityVo> selectRefundByWangWangNum(Map params);
}