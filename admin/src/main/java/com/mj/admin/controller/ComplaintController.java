package com.mj.admin.controller;

import com.mj.admin.service.ComplaintService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.dao.entity.Complaint;
import com.mj.dao.entity.Files;
import com.mj.dao.vo.ComplaintVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;
import java.util.UUID;
/**
 * @Author Simon
 * @Method
 * @Version 1.0
 * @Return
 * @Exception
 * @Date 2019-08-21 0021 09:54:07
 */

/***
 * @RestController 用于写api
 * @Controller 一般用于写后台(有页面)
 */
@RestController
@RequestMapping("/sys/complaint")
public class ComplaintController {
    @Autowired
    private ComplaintService complaintService;
    //分页搜索查询总页数
    @RequestMapping(value="/list",method = RequestMethod.POST)
    public RestResult list (@RequestBody Map map) throws Exception{
        return complaintService.selectComplaint(map);
    }
    //添加反馈
    @RequestMapping(value = "/addComplaint",method = RequestMethod.POST)
    public RestResult addComplaint(@RequestBody Complaint complaint) throws ParseException{
        return complaintService.addComplaint(complaint);
    }
    //修改反馈
    @RequestMapping(value = "/updateComplaint",method = RequestMethod.POST)
    public RestResult updateComplaint(@RequestBody ComplaintVo complaint) throws ParseException{
        return complaintService.updateComplaint(complaint);
    }
    //删除反馈
    @RequestMapping(value = "/deleteComplaint",method = RequestMethod.POST)
    public RestResult deleteComplaint(@RequestBody Map map){
        List<Integer> pkId= (List<Integer>) map.get("pkIds");
        return complaintService.deleteComlaint(pkId);
    }
    //根据wangwangNum查询对应的历史记录
    @RequestMapping(value = "/selectInfoByWangWangNum",method = RequestMethod.POST)
    public RestResult selectInfoByWangWangNum(@RequestBody Map params) throws ParseException{
//        return complaintService.selectInfoByWangWangNum(params);
        return complaintService.selectAllByWangWangNum(params);
    }
    //根据complaintId查询对应的历史记录
    @RequestMapping(value = "/selectFiles",method = RequestMethod.POST)
    public RestResult selectFiles(@RequestBody Map params){
        return complaintService.selectFiles(params);
    }
    //查询客诉大类
    @RequestMapping(value = "/selectLevel",method = RequestMethod.POST)
    public RestResult selectLevel(){
        return complaintService.selectLevel();
    }
    //根据大类查询小类
    @RequestMapping(value = "/getLevelName",method = RequestMethod.POST)
    public RestResult getLevelName(@RequestBody Map params){
        return complaintService.getLevelName(params);
    }
    //上传文件
    @RequestMapping(value = "/upload", method = {RequestMethod.POST,RequestMethod.GET})
    @CrossOrigin(origins    = "*", allowCredentials = "true",allowedHeaders = "",methods = {})
    public RestResult testUploadFile(@RequestParam(value = "file")MultipartFile file)
    {
        System.out.println("进来上传了");
        //指定存放上传文件的目录
        String fileDir = "192.168.1.251:9090/home/file";
        File dir = new File(fileDir);
        //判断目录是否存在,不存在则创建一个目录
        if (!dir.exists()){
            dir.mkdir();
        }
        //生成新的文件名,防止文件名重复而导致文件覆盖
        String originalFileName = file.getOriginalFilename();
        String suffix = originalFileName.substring(originalFileName.lastIndexOf('.'));
        //2、使用UUID生成新文件名
        String newFileName = UUID.randomUUID() + suffix;

        //生成文件
        File files = new File(dir, newFileName);

        //传输内容
        try {
            file.transferTo(files);
            System.out.println("上传文件成功！");
        } catch (IOException e) {
            System.out.println("上传文件失败！");
            e.printStackTrace();
        }

        //至此，文件已经传到了程序运行的服务器上。
        //下面是这篇博客的重点

        //上传至ftp服务器
        //1、上传文件
//        if (UploadToFtp(files)){
//            System.out.println("上传至ftp服务器！");
//        }else {
//            System.out.println("上传至ftp服务器失败!");
//        }
        //2、删除本地文件
//        files.delete();
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(null).build();
    }
    //上传文件到文件服务器并且指定到位置
    @RequestMapping(value = "/uploads",method = {RequestMethod.POST,RequestMethod.GET})
    //Java后台设置全局跨域
    @CrossOrigin(origins    = "*", allowCredentials = "true",allowedHeaders = "",methods = {})
    public RestResult uploadFile(@RequestParam("file")MultipartFile file) throws IOException {
        if(file !=null){
            return complaintService.upload(file);
        }
        return new RestResultBuilder().error("文件不存在!");
    }
    //上传文件到文件服务器并且指定到位置
    @RequestMapping(value = "/deleteFile",method = RequestMethod.POST)
    //Java后台设置全局跨域
    public RestResult deleteFile(@RequestBody Map params){
        Integer pkId = Integer.valueOf((Integer) params.get("pkIds"));
        return complaintService.deleteFile(pkId);
    }
    //添加文件
    @RequestMapping(value = "/addFile",method = RequestMethod.POST)
    public RestResult addFile(@RequestBody Files files){
        return complaintService.addFile(files);
    }
    //查询用户是否存在
    @RequestMapping(value = "/exist",method = RequestMethod.POST)
    public RestResult exist(@RequestBody Complaint complaint){
        return complaintService.exist(complaint);
    }



    //查询所有历史记录
    @RequestMapping(value = "/selectAllByWangWangNum",method = RequestMethod.POST)
    public RestResult selectAllByWangWangNum(@RequestBody Map params) throws ParseException {
        return complaintService.selectAllByWangWangNum(params);
    }
}
