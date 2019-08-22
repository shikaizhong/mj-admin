package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.vo.ComplaintVo;

import java.util.Map;

public interface PersonnelService {
    //登录
    RestResult login(Map map);
    //根据id查询用户信息
    RestResult selectInfoByID(Map params);
    //根据tid查询用户信息
    RestResult selectTid(Map params);
    //查询负责人
    RestResult selectComplaintId();
    //查询团队
    RestResult selectTeam(Map params);
    //查询团队无条件
    RestResult selectTeams();

    //根据id查询用户信息远程
    RestResult selectInfoByIDs(Map params);
    //查询负责人远程
    RestResult selectComplaintIds();
    //查询团队远程
    RestResult selectTeamss(Map params);
    //查询团队无条件远程
    RestResult selectTeamsss();


    //查询分页加搜索改进版
    ComplaintVo selectComplaintListOver(Map map);
}
