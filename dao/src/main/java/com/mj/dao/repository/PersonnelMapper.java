package com.mj.dao.repository;

import com.mj.dao.entity.Personnel;
import com.mj.dao.vo.*;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface PersonnelMapper {
    /**
     *
     * @mbg.generated 2019-07-16 15:28:39
     */
    int insert(Personnel record);

    /**
     *
     * @mbg.generated 2019-07-16 15:28:39
     */
    int insertSelective(Personnel record);

//    @DataSource("other")
    //用户登录
    Personnel login(@Param("username")String username);

    //根据账户查询
    Map selectInfo(@Param("username")String username);
    //通过id查询信息本地
    List<ComplaintVo> selectInfoByID(Integer id);
    //通过id查询信息远程
    List<ComplaintVo> selectInfoByIDs(Integer id);
    //通过tid查询信息本地
    List<ComplaintVo> selectInfoTID(Integer tid);
    //通过tid查询信息远程
    List<ComplaintVo> selectInfoTIDs(Integer tid);
    //查询负责人本地
    List<PersonnelVo> selectComplaintId();
    //查询负责人远程
    List<PersonnelVo> selectComplaintIds();
    //查询团队本地
    List<ComplaintVo> selectTeam(Integer id);
    //查询团队远程
    List<ComplaintVo> selectTeamss(Integer id);
    //查询团队本地
    List<TeamVo> selectTeams();
    //查询团队远程ss
    List<TeamVo> selectTeamsss();
    List<Personnel> all();


    ComplaintVo selectComplaintListOver(Map map);

    //从sqlserver带出来判责要的数据
    ResponsibilityVo selectResponsibilityList(Map map);

    //测试分页插件
    List<Personnel> test();


    //一个条件查询
    ComplaintVo selectByPkId(Map map);




    //查询退款，隐患，流失
    List<SQLServerVo> selectBySQL(Map map);
}