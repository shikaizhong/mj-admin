package com.mj.admin.controller;

import com.mj.admin.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/customer")
@Validated
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @RequestMapping(value = "/selectByWangWangNum", method = {RequestMethod.POST, RequestMethod.GET})
    public List selectInfoWangWangNum(@RequestBody Map params){
        return customerService.selectByWangWangNum(params);
    }
}
