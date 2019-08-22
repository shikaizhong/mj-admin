package com.mj.dao.repository;

import com.mj.dao.entity.User;

import java.util.List;

public interface UserMapper {
    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    int insert(User record);

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    int insertSelective(User record);

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */

    User selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    int updateByPrimaryKeySelective(User record);

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    int updateByPrimaryKey(User record);

    //查找所有用户
    List<User> selectUser();
}