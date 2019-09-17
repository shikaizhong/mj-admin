package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Complaint;
import com.mj.dao.entity.Files;
import com.mj.dao.vo.ComplaintVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface ComplaintService {
    //查询分页加搜索
    RestResult selectComplaint(Map params) throws Exception;
    //添加
    RestResult addComplaint(Complaint complaint);
    //修改
    RestResult updateComplaint(ComplaintVo complaint);
    //批量删除反馈
    RestResult deleteComlaint(List<Integer> pkIds);
    //根据旺旺名查询历史记录
    RestResult selectInfoByWangWangNum(Map params);
    //根据complaintId查询历史记录
    RestResult selectFiles(Map params);
    //查询投诉大类
    RestResult selectLevel();
    //查询投诉小类
    RestResult getLevelName(Map params);
    //上传文件
    RestResult upload(MultipartFile file) throws IOException;
    //删除
    RestResult deleteFile(Integer pkId);
    //添加文件
    RestResult addFile(Files files);
    //查看用户是否存在
    RestResult exist(Complaint complaint);


    //通过wangwangnum查询出所有记录
    RestResult selectAllByWangWangNum(Map params) throws ParseException;
}
