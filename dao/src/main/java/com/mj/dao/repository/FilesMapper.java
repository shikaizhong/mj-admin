package com.mj.dao.repository;

import com.mj.dao.entity.Files;

public interface FilesMapper {
    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    int insert(Files record);

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    int insertSelective(Files record);

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    Files selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    int updateByPrimaryKeySelective(Files record);

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    int updateByPrimaryKey(Files record);
}