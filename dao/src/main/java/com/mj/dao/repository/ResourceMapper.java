package com.mj.dao.repository;

import com.mj.dao.entity.Resource;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface ResourceMapper {
    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int deleteByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insert(Resource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int insertSelective(Resource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    Resource selectByPrimaryKey(Integer pkId);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKeySelective(Resource record);

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    int updateByPrimaryKey(Resource record);



    // 自定义


    /**
     * 根据 名称 查找
     * @param ukName
     * @return
     */
    @Select("select * from sys_resource where uk_name=#{ukName} and delete_flag=0")
    Resource getResourceByUkName(String ukName);

    @Select("select pk_id from sys_resource where parent_id=#{parentId} and delete_flag=0")
    List<Integer> selectChildpkIds(Integer parentId);


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
     * 获取所有资源列表
     * @return
     */
    @Select("select " +
            "pk_id as pkId," +
            "parent_id as parentId, " +
            "uk_name as title, " +
            "path," +
            "perms," +
            "Type," +
            "order_num as orderNum from sys_resource where delete_flag=0 order by orderNum ")
    List<Map> getAll();

    @Select("select pk_id as pkId, uk_name as ukName from sys_resource where delete_flag=0 and Type=0 order by order_num;")
    List<Map> parentList();


    /**
     * 获取 指定角色的 权限列表
     * @param roleIds
     * @return
     */
    List<Resource> getResourcesByRoleId(List<Integer> roleIds);
}