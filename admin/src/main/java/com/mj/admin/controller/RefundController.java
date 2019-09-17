package com.mj.admin.controller;

import com.mj.admin.service.RefundService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.Refund;
import com.mj.dao.vo.RefundVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/sys/refund")
public class RefundController {
    @Autowired
    private RefundService refundService;

    //分页查询加搜索
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public RestResult list(@RequestBody Map map) throws Exception {
        return refundService.selectRefund(map);
    }

    //添加反馈
    @RequestMapping(value = "/addRefund", method = RequestMethod.POST)
    public RestResult addRefund(@RequestBody Refund refund) throws ParseException {
        return refundService.addRefund(refund);
    }

    //修改反馈
    @RequestMapping(value = "/updateRefund", method = RequestMethod.POST)
    public RestResult updateRefund(@RequestBody RefundVo refund)throws ParseException{
        return refundService.updateRefund(refund);
    }

    //删除反馈
    @RequestMapping(value = "/deleteRefund", method = RequestMethod.POST)
    public RestResult deleteRefund(@RequestBody Map map) {
        List<Integer> pkId = (List<Integer>) map.get("pkIds");
        return refundService.deleteRefund(pkId);
    }

    //根据id查询详情
//    @RequestMapping(value = "/selectInfoById", method = RequestMethod.POST)
//    public RestResult selectInfoById(@RequestBody Map params) {
//        return refundService.selectInfoById(params);
//    }

    //根据wangwangNum查询对应的历史记录
    @RequestMapping(value = "/selectInfoByWangWangNum", method = RequestMethod.POST)
    public RestResult selectInfoByWangWangNum(@RequestBody Map params) throws Exception {
        return refundService.selectInfoByWangWangNum(params);
    }

    //文件上传
//    @RequestMapping(value = "/upload", method = {RequestMethod.POST, RequestMethod.GET})
//    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "", methods = {})
//    public RestResult testUploadFile(@RequestParam(value = "file") MultipartFile file) throws Exception {
//        return refundService.testUploadFile(file);
//    }

    //根据旺旺名查询该旺旺名是否存在
    @RequestMapping(value = "/selectWang", method = RequestMethod.POST)
    public RestResult selectWang(@RequestBody Refund refund) {
//        System.out.println("controller:"+params);
        return refundService.selectWang(refund);
    }

    //上传文件到文件服务器并且指定到位置
    @RequestMapping(value = "/uploads", method = {RequestMethod.POST, RequestMethod.GET})
    //Java后台设置全局跨域
    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "", methods = {})
    public RestResult uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            return refundService.upload(file);
        }
        return new RestResultBuilder().error("文件不存在!");
    }

    //删除
    @RequestMapping(value = "/deleteFile", method = RequestMethod.POST)
    //Java后台设置全局跨域
    public RestResult deleteFile(@RequestBody Map params) {
        Integer pkId = Integer.valueOf(String.valueOf(params.get("pkId")));
//        System.out.println("controller,pkId为:" + pkId);
        return refundService.deleteFile(pkId);
    }

    //添加文件
    @RequestMapping(value = "/addFile", method = RequestMethod.POST)
    public RestResult addFile(@RequestBody Files files) {
        return refundService.addFile(files);
    }

    //根据refundId查询文件链接列表
    @RequestMapping(value = "/listFile", method = RequestMethod.POST)
    public RestResult listFile(@RequestBody Map params) {
        return refundService.selectFiles(params);
    }

    //根据pkId查询文件列表的值
//    @RequestMapping(value = "/listFileAll", method = RequestMethod.POST)
//    public RestResult selectFileList() {
//        return refundService.selectFileList();
//    }

    //根据旺旺名查询值，在customer表中
//    @RequestMapping(value = "/selectAll",method = RequestMethod.POST)
//    public RestResult selectAll(){
//        return refundService.selectAll();
//    }
}
