package com.mj.admin.controller;

import com.mj.admin.service.LoseService;
import com.mj.common.result.RestResult;
import com.mj.dao.entity.Lose;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController
@RequestMapping("/sys/lose")
public class LoseController {
    @Autowired
    private LoseService loseService;

    @RequestMapping(value = "/selectLose", method = RequestMethod.POST)
    public RestResult selectLose(@RequestBody Map params) throws Exception {
        System.out.println("进入Controller");
        return loseService.selectLose(params);
    }

    @RequestMapping(value = "/addLose", method = RequestMethod.POST)
    public RestResult addLose(@RequestBody Lose lose){
        return loseService.addLose(lose);
    }
}
