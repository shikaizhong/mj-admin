package com.mj.dao.repository;

import com.mj.dao.entity.HiddenTrouble;

import java.util.List;
import java.util.Map;

public interface HiddenTroubleMapper {
    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int insert(HiddenTrouble record);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int insertSelective(HiddenTrouble record);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    HiddenTrouble selectByPrimaryKey(Integer pkId);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int updateByPrimaryKeySelective(HiddenTrouble record);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int updateByPrimaryKeyWithBLOBs(HiddenTrouble record);

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    int updateByPrimaryKey(HiddenTrouble record);

    //查询，搜索，分页
    List<HiddenTrouble> selectHiddenList(Map params);

    //数据总数
    Integer total(Map params);

    //根据旺旺名查询该用户的隐患总数
    Integer totalWangWangNum(String wangWangNum);

    //删除
    Integer deleteHidden(Integer[] pkId);

    //根据旺旺名查询历史记录
    List selectByWangWangNum(String wangWangNum);

    //根据pkId查询详情
    List selectByPkId(Integer pkId);

    //根据hiddenId查询文件列表
    List selectFiles(Map params);

    //根据id查询隐患详情
    List<HiddenTrouble> selectById(Map params);

}