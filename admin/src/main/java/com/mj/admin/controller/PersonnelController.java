package com.mj.admin.controller;

import com.mj.admin.service.PersonnelService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;
import com.mj.dao.vo.ResponsibilityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/sys/personnel")
@Validated
public class PersonnelController {
    @Autowired
    private PersonnelService personnelService;
    /**
     * 登录
     * params -->  account  用户名
     * params -->  password   密码
     * @param map
     */
    @RequestMapping(value = "/login",method = RequestMethod.POST)
    public RestResult login(@RequestBody Map map){
        System.out.println("进入controller");
        return personnelService.
                login(map);
    }
    //通过id查询信息
    @RequestMapping(value = "/selectInfoByID",method = RequestMethod.POST)
    public RestResult selectInfoByID(@RequestBody Map params){
        return personnelService.selectInfoByID(params);
    }
    //查询责任人
    @RequestMapping(value = "/selectComplaintId",method = RequestMethod.POST)
    public RestResult selectComplaintId(){
        return personnelService.selectComplaintId();
    }
    //查询团队
    @RequestMapping(value = "/selectTeam",method = RequestMethod.POST)
    public RestResult selectTeam(@RequestBody Map params){
        return personnelService.selectTeam(params);
    }
    //查询团队
    @RequestMapping(value = "/selectTeams",method = RequestMethod.POST)
    public RestResult selectTeams(){
        return personnelService.selectTeams();
    }


    //远程数据库数据
    //通过id查询信息
    @RequestMapping(value = "/selectInfoByIDs",method = RequestMethod.POST)
    public RestResult selectInfoByIDs(@RequestBody Map params){
        return personnelService.selectInfoByIDs(params);
    }
    //查询责任人
    @RequestMapping(value = "/selectComplaintIds",method = RequestMethod.POST)
    public RestResult selectComplaintIds(){
        return personnelService.selectComplaintIds();
    }
    //查询团队
    @RequestMapping(value = "/selectTeamss",method = RequestMethod.POST)
    public RestResult selectTeamss(@RequestBody Map params){
        return personnelService.selectTeamss(params);
    }
    //查询团队
    @RequestMapping(value = "/selectTeamsss",method = RequestMethod.POST)
    public RestResult selectTeamsss(){
        return personnelService.selectTeamsss();
    }

    //查詢
    /*@RequestMapping(value = "/tests",method = RequestMethod.POST)
    public RestResult tests(Map params){
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        List<ComplaintVo> list =personnelService.selectComplaintListOver(wangwangnum);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(list).build();
    }*/


    //测试分页插件
    @RequestMapping(value ="/testPage",method = RequestMethod.POST)
    public PageResult findPage(@RequestBody PageRequest pageRequest) throws Exception {
        return personnelService.testPageHelper(pageRequest);
    }

    @RequestMapping(value = "/tests",method = RequestMethod.POST)
    public RestResult tests(@RequestBody Map map){
        ResponsibilityVo list =personnelService.selectResponsibilityList(map);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(list).build();
    }





    //查询refund所需数据
    @RequestMapping(value = "/selectRefund", method = RequestMethod.POST)
    public List selectRefund(@RequestBody Map params) throws Exception {
        return personnelService.selectByDatebase(params);
    }
    //查询店铺类型
    @RequestMapping(value = "/selectShopType",method = RequestMethod.POST)
    public RestResult selectShopType(){
        return personnelService.selectShopType();
    }
    //查询团队名称
    @RequestMapping(value = "/selectOnleTeam",method = RequestMethod.POST)
    public RestResult selectOnleTeam(){
        return personnelService.selectOnleTeam();
    }
}
