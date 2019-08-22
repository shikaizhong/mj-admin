package com.mj.admin.controller;

import com.mj.admin.service.UserService;
import com.mj.common.result.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/sys/user")
public class UserController {
@Autowired
    private UserService userService;
    /*用户列表*/
    @RequestMapping(value = "/list" ,method = RequestMethod.POST)
    public RestResult list(){
        return userService.selectUser();
    }
    //sqlserve数据库数据
    @RequestMapping(value = "/lists",method = RequestMethod.POST)
    public RestResult lists(){
        return userService.selectUsers();
    }
}
