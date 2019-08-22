package com.mj.admin.controller;


import com.mj.admin.constants.ParamConstant;
import com.mj.admin.params.AdminRequest;
import com.mj.admin.params.AdminUpdateRequest;
import com.mj.admin.service.AdminService;
import com.mj.common.result.RestResult;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

/**
 * Created by Mr.Dxs on 2018/7/13.
 */
@RestController
@RequestMapping(value = "/sys/admin")
@Validated
public class AdminController {

    @Autowired
    private AdminService adminService;

    /**
     * 登录
     * params -->  ukAccount  用户名
     * params -->  password   密码
     * @param map
     */
    @RequestMapping(value = "/logins",method = RequestMethod.POST)
    public RestResult login(@RequestBody Map map){
        return adminService.
                login(map);
    }


    /**
     * 退出
     * @param Authorization
     * @return
     */
    @RequestMapping(value = "/logout",method = RequestMethod.POST)
    public RestResult logout(@RequestHeader("Authorization") String Authorization){
        return adminService.logout(Authorization);
    }



    /**
     * 添加管理员
     * @param adminRequest
     * @param result
     * @return
     */
    @RequestMapping(value = "/save", method = RequestMethod.POST)
    public RestResult save(@RequestBody @Valid AdminRequest adminRequest, BindingResult result) {
        return adminService.saveAdmin(adminRequest);
    }


    /**
     * 批量添加
     * @param adminRequests
     * @param result
     * @return
     */
    @RequestMapping(value = "/batch",method = RequestMethod.POST)
    public RestResult saveBatch(@RequestBody @Valid @Size(min = 1,message = ParamConstant.PARAMS_LIST_NOT_NULL)
                                            List<AdminRequest> adminRequests, BindingResult result){
        return adminService.saveBatch(adminRequests);
    }
    /**
     * 删除、批量删除
     * @param map
     * @return
     */
    @RequestMapping(value = "/delete",method = RequestMethod.POST)
    public RestResult delete(@RequestBody Map map){
        List<Integer> pkIds = (List<Integer>) map.get("pkIds");
        System.out.println(pkIds);
        return adminService.deleteAdmin(pkIds);
    }


    /**
     * 修改信息
     * @param adminUpdateRequest
     * @param result
     * @return
     */
    @RequestMapping(value = "/update",method = RequestMethod.POST)
    public RestResult update(@RequestBody @Valid AdminUpdateRequest adminUpdateRequest, BindingResult result){
        return adminService.updateAdmin(adminUpdateRequest);
    }


    /**
     * 获取管理员信息  pkId / ukAccount
     * @param type
     * @param keys
     * @return
     */
    @RequestMapping(value = "/get",method = RequestMethod.GET)
    public RestResult getAdmin( @RequestParam String type,
                                @RequestParam String keys){
        return adminService.getAdmin(type,keys);
    }


    /**
     * 管理员列表
     * @param map
     */
    @RequiresPermissions("sys:admin:list")
    @RequestMapping(value = "/list",method = RequestMethod.POST)
    public RestResult list(@RequestBody Map map){
        String keyword = (String) map.get("keyword");
        Integer pageNum = (Integer) map.get("pageNum");
        Integer pageSize = (Integer) map.get("pageSize");
        return adminService.listAdmin(keyword, pageNum, pageSize);
    }
}
