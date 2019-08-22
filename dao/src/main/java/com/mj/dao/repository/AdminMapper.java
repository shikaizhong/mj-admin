package com.mj.dao.repository;

import com.mj.dao.entity.Admin;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface AdminMapper {
    int deleteByPrimaryKey(Integer pkId);

    int insert(Admin record);

    int insertSelective(Admin record);

    Admin selectByPrimaryKey(Integer pkId);

    int updateByPrimaryKeySelective(Admin record);

    int updateByPrimaryKey(Admin record);

    // *** 自定义 ***

    Admin getByAuthenticatorUkAccount(@Param("ukAccount") String ukAccount);

    Map getAdminByUkAccount(String ukAccount);


    int deleteBatch(Integer[] pkIds);


    /**
     * 列表
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
}