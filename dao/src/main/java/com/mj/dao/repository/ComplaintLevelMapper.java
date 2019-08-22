package com.mj.dao.repository;

import com.mj.dao.entity.ComplaintLevel;

import java.util.List;
import java.util.Map;

public interface ComplaintLevelMapper {
    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    int insert(ComplaintLevel record);

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    int insertSelective(ComplaintLevel record);

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    ComplaintLevel selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    int updateByPrimaryKeySelective(ComplaintLevel record);

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    int updateByPrimaryKey(ComplaintLevel record);
    //查看小类列表
    List<ComplaintLevel> getLevelName(Map params);
}