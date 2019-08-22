package com.mj.dao.repository;

import com.mj.dao.entity.Role;
import org.apache.ibatis.annotations.Select;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.Map;

@Component
public interface RoleMapper {
    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insert(Role record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insertSelective(Role record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    Role selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKeySelective(Role record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKey(Role record);


    // 自定义


    /**
     * 分页列表
     * @param queryMap
     * @return
     */
    List<Map> listPage(Map queryMap);


    /**
     * 统计
     * @param queryMap
     * @return
     */
    Integer countPage(Map queryMap);


    /**
     * 所有角色列表
     * @return
     */
    @Select("select sr.pk_id,sr.uk_name from sys_role as sr order by sr.create_time desc")
    List<Map> getAll();


    /**
     * 获取角色用户的 资源列表 ID
     * 此处关联 resource 表 防止 资源被删除
     * @param roleId
     * @return
     */
    @Select("SELECT \n" +
            "  sr.`pk_id` \n" +
            "FROM\n" +
            "  sys_role_resource AS srr \n" +
            "  LEFT JOIN sys_resource AS sr \n" +
            "    ON srr.`resource_id` = sr.`pk_id` \n" +
            "WHERE srr.`role_id` = #{roleId}")
    List<Integer> getRoleHaveResourceListId(Integer roleId);


    /**
     * 获取 指定管理员 角色列表
     * @param adminId
     * @return
     */
//    @Select("")
    List<Role> getRolesByAdminId(int adminId);

}