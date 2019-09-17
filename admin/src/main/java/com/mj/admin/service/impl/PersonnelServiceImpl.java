package com.mj.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mj.admin.constants.AdminConstant;
import com.mj.admin.datasource.annotation.DataSource;
import com.mj.admin.datasource.config.DataSourceSwitch;
import com.mj.admin.redis.JWTRedisDAO;
import com.mj.admin.service.PersonnelService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.JWTUtils;
import com.mj.common.tools.PageUtils;
import com.mj.common.tools.StringUtil;
import com.mj.dao.entity.Personnel;
import com.mj.dao.repository.PersonnelMapper;
import com.mj.dao.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Service
@Transactional
public class PersonnelServiceImpl implements PersonnelService {
    @Autowired
    private PersonnelMapper personnelMapper;
    @Autowired
    private JWTRedisDAO jwtRedisDAO;
    @DataSource(value = "slave1")
    @Override
    @Transactional(rollbackFor = Exception.class)
    public RestResult login(Map map) {
        String account = (String) map.get("username");
        String password = (String) map.get("pwd");
        System.out.println("账户为"+account);
        System.out.println("密码为"+password);
        // 参数校验
        if (StringUtil.isEmpty(account)){
            return ResultUtils.error(ResultCodeEnum.ILLEGAL_ARGUMENT.getCode(),ResultCodeEnum.ILLEGAL_ARGUMENT.getMsg());
        }
        // 验证账户是否存在
        Personnel personnel=personnelMapper.login(account);
        if (null == personnel){
            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(),ResultCodeEnum.USER_NOT_FOUND.getMsg());
        }
        // 验证密码
        System.out.println(personnel.getPwd());
//        String password = (String) map.get("pwd");
        if (!personnel.getPwd().equals(password)){
            return ResultUtils.error(ResultCodeEnum.USER_PASSWORD_NOT_MATCH.getCode(),ResultCodeEnum.USER_PASSWORD_NOT_MATCH.getMsg());
        }
        // 生成 token
        Map map2 = new HashMap();
        map2.put(AdminConstant.ACCOUNT, personnel.getUsername());
        map2.put("time", System.currentTimeMillis());
        String token = JWTUtils.generateToken(AdminConstant.JWT_SALT, map);
//        // 持久化到 Redis
//        jwtRedisDAO.set(AdminConstant.JWT_TOKEN + username, token);
        // 持久化到 Redis
        jwtRedisDAO.set(AdminConstant.JWT_TOKEN + account, token);
        //返回数据
        Map personnel1 = personnelMapper.selectInfo(account);
        Map map1 = new HashMap();
        map1.put("personnel1",personnel1);
        map1.put("token",token);
        return ResultUtils.success(map1);
    }
    //通过id查询
    @DataSource(value = "druid")
    @Override
    public RestResult selectInfoByID(Map params) {
        System.out.println("id为"+params.get("id"));
        Integer id = Integer.valueOf((String) params.get("id"));
        List<ComplaintVo> personnels = personnelMapper.selectInfoByID(id);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(personnels).build();
    }
//通过tid查询
    @DataSource(value = "druid")
    @Override
    public RestResult selectTid(Map params) {
        Integer id = Integer.valueOf((String) params.get("tid"));
        List<ComplaintVo> personnels = personnelMapper.selectInfoTID(id);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(personnels).build();
    }

    //查询负责人
    @DataSource(value = "druid")
    @Override
    public RestResult selectComplaintId() {
        List<PersonnelVo> selectComplaintId = personnelMapper.selectComplaintId();
//        List<Personnel> selectComplaintId = personnelMapper.all();
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(selectComplaintId).build();
    }
    //查询团队
    @DataSource(value = "druid")
    @Override
    public RestResult selectTeam(Map params) {
        Integer id = Integer.valueOf((String) params.get("id"));
        List<ComplaintVo> selectTeam = personnelMapper.selectTeam(id);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(selectTeam).build();
    }
    @Override
    @DataSource(value = "druid")
    public RestResult selectTeams() {
        List<TeamVo> teamVos = personnelMapper.selectTeams();
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(teamVos).build();
    }

    //远程,对应上面的本地功能
    @DataSource(value = "slave1")
    @Override
    public RestResult selectInfoByIDs(Map params) {
        Integer id = Integer.valueOf((String) params.get("id"));
        List<ComplaintVo> personnels = personnelMapper.selectInfoByIDs(id);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(personnels).build();
    }
    @DataSource(value = "slave1")
    @Override
    public RestResult selectComplaintIds() {
        List<PersonnelVo> selectComplaintId = personnelMapper.selectComplaintIds();
//        List<Personnel> selectComplaintId = personnelMapper.all();
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(selectComplaintId).build();
    }
    @DataSource(value = "slave1")
    @Override
    public RestResult selectTeamss(Map params) {
        Integer id = Integer.valueOf((String) params.get("id"));
        List<ComplaintVo> selectTeam = personnelMapper.selectTeamss(id);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(selectTeam).build();
    }
    @DataSource(value = "slave1")
    @Override
    public RestResult selectTeamsss() {
        List<TeamVo> teamVos = personnelMapper.selectTeamsss();
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(teamVos).build();
    }



    @DataSource(value = "slave1")
    @Override
    public ComplaintVo selectComplaintListOver(Map map) {
        return personnelMapper.selectComplaintListOver(map);
    }
    @DataSource(value = "slave1")
    @Override
    public ComplaintVo selectByPkId(Map map) {
        return personnelMapper.selectByPkId(map);
    }

    //一个条件查询
    @DataSource(value = "slave1")


    //测试分页插件
    @Override
    public PageResult testPageHelper(PageRequest pageRequest) throws Exception {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }

    private PageInfo<Personnel> getPageInfo(PageRequest pageRequest) throws Exception {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Personnel> personnels = personnelMapper.test();
        for(Personnel p:personnels){
            System.out.println(p.getUsername());
        }
        DataSourceSwitch.change("druid");
        return new PageInfo<Personnel>(personnels);
  }
    @DataSource(value = "slave1")
    @Override
    public ResponsibilityVo selectResponsibilityList(Map map) {
        Integer PersonnelID = Integer.valueOf((Integer) map.get("PersonnelID"));
        String TScustomer = String.valueOf(map.get("TScustomer"));
        //根据团队名查询
        String TeamName = String.valueOf(map.get("TeamName"));
        if (TeamName ==""){
            map.put("TeamName",null);
        }else if (TeamName == "null"){
            map.put("TeamName", null);
        }else {
            map.put("TeamName",TScustomer);
        }
        if(TScustomer == "null"){
            map.put("TScustomer", null);
        }else if(TScustomer == ""){
            map.put("TScustomer", null);
        }else {
            map.put("TScustomer",TScustomer);
        }
        if (PersonnelID == -1){
            map.put("PersonnelID",-1);
        }else if (PersonnelID == null){
            map.put("PersonnelID",-1);
        }
        return personnelMapper.selectResponsibilityList(map);
    }

    //根据旺旺名查询退款数据
    @DataSource(value = "slave1")
    @Override
    public List selectByDatebase(Map params) throws ParseException {
        //根据旺旺名查询
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队名查询
        String TeamName = String.valueOf(params.get("TeamName"));
        //店长ID
        String TScustomer = String.valueOf(params.get("TScustomer"));
        //招商顾问ID
        Integer PersonnelID = Integer.valueOf((Integer) params.get("PersonnelID"));

        params.put("wangwangnum", wangwangnum);
        Map map = new HashMap();
        if(!wangwangnum.isEmpty()){
            map.put("wangwangnum",wangwangnum);
        }
        if(!shopptype.isEmpty() && shopptype !="null"){
            map.put("shopptype", shopptype);
        }
        if(!username1.isEmpty() && username1 !="null"){
            map.put("username1", username1);
        }
        if(!username2.isEmpty() && username2 !="null"){
            map.put("username2", username2);
        }
        if(!TeamName.isEmpty() && TeamName !="null"){
            map.put("TeamName", TeamName);
        }
        if(TScustomer == "null"){
            map.put("TScustomer", null);
        }else if(TScustomer == ""){
            map.put("TScustomer", null);
        }else {
            map.put("TScustomer",TScustomer);
        }
        if (PersonnelID == -1){
            map.put("PersonnelID",-1);
        }else if (PersonnelID == null) {
            map.put("PersonnelID", -1);
        }else {
            map.put("PersonnelID",PersonnelID);
        }
        List<SQLServerVo> list = personnelMapper.selectBySQL(map);
        for(SQLServerVo sqlServerVo : list){
            SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
            String serverdeadline = sqlServerVo.getServerdeadline();
            String serverdeadlineend = sqlServerVo.getServerdeadlineend();
            if (serverdeadline != null && serverdeadlineend != null && !serverdeadline.equals("null") && !serverdeadlineend.equals("null")) {
                if (!serverdeadline.isEmpty() && !serverdeadlineend.isEmpty()) {
                    int index1 = serverdeadline.indexOf(' ');
                    int index2 = serverdeadlineend.indexOf(' ');
                    if (index1 > 9) {
                        serverdeadline = serverdeadline.substring(0, index1 - 1);
                    }
                    if (index2 > 9) {
                        serverdeadlineend = serverdeadlineend.substring(0, index2 - 1);
                    }
                    serverdeadline = serverdeadline.replaceAll("/", "-");
                    serverdeadlineend = serverdeadlineend.replaceAll("/", "-");
                    serverdeadline = serverdeadline.replace('.', '-');
                    serverdeadlineend = serverdeadlineend.replace('.', '-');
                    Date date1 = sdf.parse(serverdeadline);
                    Date date2 = sdf.parse(serverdeadlineend);
                    Long day = (date2.getTime() - date1.getTime()) / (24 * 60 * 60 * 1000);
                    if (day < 0) {
                        day = day + 365;
                    }
                    sqlServerVo.setDeadline(day);
                } else {
                    sqlServerVo.setDeadline(0L);
                }
            }
        }
        return list;
    }
}
