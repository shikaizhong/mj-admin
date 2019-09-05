package com.mj.admin.controller;

import com.mj.admin.service.ResponsibilityService;
import com.mj.common.result.RestResult;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.util.Map;

@RestController
@RequestMapping("/sys/responsibility")
public class ResponsibilityController {
    @Autowired
    private ResponsibilityService responsibilityService;
    //查询
    @RequestMapping("/list")
    public RestResult list (@RequestBody Map map) throws Exception {
        return responsibilityService.selectResponsiblity(map);
    }
    //分页
    @RequestMapping("/page")
    public PageResult page(@RequestBody PageRequest pageRequest) throws Exception {
        return responsibilityService.pageHelper(pageRequest);
    }
    //修改
    @RequestMapping("/update")
    public  RestResult update(@RequestBody ResponsibilityWithBLOBs responsibilityWithBLOBs) throws ParseException{
        return responsibilityService.updataResponsiblity(responsibilityWithBLOBs);
    }
    //添加文件
    @RequestMapping(value = "/addFile",method = RequestMethod.POST)
    public RestResult addFile(@RequestBody Files files){
        return responsibilityService.addFile(files);
    }

    //根据id查询
    @RequestMapping(value = "/selectById",method = RequestMethod.POST)
    public RestResult selectById(@RequestBody Map params) throws ParseException {
        Integer type = Integer.valueOf(String.valueOf(params.get("type")));
        if (type ==2){
            return responsibilityService.selectInfoByPkId(params);

        }else if (type ==1) {
            return responsibilityService.selectByHId(params);
        }else {
            return responsibilityService.selectById(params);
        }
    }
}

