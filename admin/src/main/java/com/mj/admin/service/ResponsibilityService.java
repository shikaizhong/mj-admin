package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;

import java.util.Map;

public interface ResponsibilityService {
    //查询
    RestResult selectResponsiblity(Map params) throws Exception;
    //使用分页插件来分页分页插件
    PageResult pageHelper(PageRequest pageRequest) throws Exception;
    //修改
    RestResult updataResponsiblity(ResponsibilityWithBLOBs responsibilityWithBLOBs);
    //添加文件
    RestResult addFile(Files files);

    //根据id查询
    RestResult selectById(Map params);
}
