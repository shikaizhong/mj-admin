package com.mj.admin.service;

import com.mj.common.result.RestResult;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.Refund;
import com.mj.dao.vo.RefundVo;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

public interface RefundService {
    //查询分页加搜索
    RestResult selectRefund(Map params) throws Exception;

    //添加
    RestResult addRefund(Refund refund) throws ParseException;

    //修改
    RestResult updateRefund(RefundVo refund)throws ParseException;

    //批量删除退款
    RestResult deleteRefund(List<Integer> pkIds);

    //根据旺旺名查询历史记录
    RestResult selectInfoByWangWangNum(Map params) throws Exception;

    //根据id查询详情
//    RestResult selectInfoById(Map params);

    //根据退款用户判断该用户存在不存在
    RestResult selectWang(Refund refund);

    //上传文件
    RestResult upload(MultipartFile file) throws IOException;

    //删除
    RestResult deleteFile(Integer pkId);

    //添加文件
    RestResult addFile(Files files);

    //根据refundId查询历史记录
    RestResult selectFiles(Map params);

    //查询文件列表
//    RestResult selectFileList();

    //customer表中根据旺旺名查询
//    RestResult selectAll();
}
