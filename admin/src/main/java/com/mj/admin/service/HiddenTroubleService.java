package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.HiddenTrouble;
import com.mj.dao.vo.HiddenTroubleVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface HiddenTroubleService {

    //总查询，搜索，分页
    RestResult selectHidden(Map params) throws Exception;

    //添加
    RestResult addHidden(HiddenTrouble hiddenTrouble)throws ParseException;

    //删除
    RestResult deleteHidden(List<Integer> pkIds);

    //修改
    RestResult updateHidden(HiddenTroubleVo hiddenTrouble)throws ParseException;

    //根据旺旺名查看历史记录
    RestResult selectInfoByWangWangNum(Map params)throws ParseException;

    //根据pkId查询详情
    RestResult selectInfoByPkId(Map params);

    //根据旺旺名查询该用户是否存在
    RestResult selectByWangWangNum(HiddenTrouble hiddenTrouble);

    //上传文件
    RestResult upload(MultipartFile file) throws IOException;

    //添加文件
    RestResult addFile(Files files);

    //删除文件
    RestResult deleteFile(Integer pkId);

    //根据hiddenId查询文件列表
    RestResult selectFile(Map params);
}
