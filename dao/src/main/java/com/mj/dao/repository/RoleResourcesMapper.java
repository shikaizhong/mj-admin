package com.mj.dao.repository;

import com.mj.dao.entity.RoleResource;
import org.apache.ibatis.annotations.Delete;

public interface RoleResourcesMapper {
    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insert(RoleResource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insertSelective(RoleResource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    RoleResource selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKeySelective(RoleResource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKey(RoleResource record);


    // **** 自定义 ****

    @Delete("delete from sys_role_resource where role_id=#{roleId}")
    int deleteByRoleId(Integer roleId);

    @Delete("delete from sys_role_resource where resource_id=#{resourceId}")
    int deleteByResourceId(Integer resourceId);


}