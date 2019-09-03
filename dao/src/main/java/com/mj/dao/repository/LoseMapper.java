package com.mj.dao.repository;

import com.mj.dao.entity.Lose;

import java.util.List;
import java.util.Map;

public interface LoseMapper {
    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int insert(Lose record);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int insertSelective(Lose record);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    Lose selectByPrimaryKey(Integer pkId);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int updateByPrimaryKeySelective(Lose record);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int updateByPrimaryKeyWithBLOBs(Lose record);

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    int updateByPrimaryKey(Lose record);

    //查询，分页
    List<Lose> selectLose(Map params);

    //流失总数
    Integer countLose();

    Integer deleteLoseByPkId(Integer[] pkId);
}