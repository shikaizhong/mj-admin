package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;

import java.text.ParseException;
import java.util.Map;

public interface ResponsibilityService {
    //查询
    RestResult selectResponsiblity(Map params) throws Exception;
    //使用分页插件来分页分页插件
    PageResult pageHelper(PageRequest pageRequest) throws Exception;
    //修改
    RestResult updataResponsiblity(ResponsibilityWithBLOBs responsibilityWithBLOBs)throws ParseException;
    //添加文件
    RestResult addFile(Files files);

    //根据id查询投诉信息
    RestResult selectById(Map params);

    //根据id查询退款信息
    RestResult selectInfoByPkId(Map params) throws ParseException;

    //根据id查询隐患信息
    RestResult selectByHId(Map params) throws ParseException;
}
