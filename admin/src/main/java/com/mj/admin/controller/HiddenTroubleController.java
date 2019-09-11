package com.mj.admin.controller;

import com.mj.admin.service.HiddenTroubleService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.HiddenTrouble;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.text.ParseException;
import java.util.List;
import java.util.Map;


@RestController
@RequestMapping("/sys/hidden")
public class HiddenTroubleController {

    @Autowired
    private HiddenTroubleService hiddenTroubleService;

    //查询，分页，搜索
    @RequestMapping(value = "/selectHidden", method = RequestMethod.POST)
    public RestResult selectHiddenController(@RequestBody Map params) throws Exception {
        return hiddenTroubleService.selectHidden(params);
    }

    //添加隐患
    @RequestMapping(value = "/addHidden", method = RequestMethod.POST)
    public RestResult addHiddenController(@RequestBody HiddenTrouble hiddenTrouble1) throws ParseException {
        return hiddenTroubleService.addHidden(hiddenTrouble1);
    }

    //修改隐患
    @RequestMapping(value = "updateHidden", method = {RequestMethod.POST,RequestMethod.GET})
    public RestResult updateHiddenController(@RequestBody HiddenTrouble hiddenTrouble) throws ParseException {
        return hiddenTroubleService.updateHidden(hiddenTrouble);
    }

    //删除反馈
    @RequestMapping(value = "/deleteHidden", method = RequestMethod.POST)
    public RestResult deleteHiddenController(@RequestBody Map map) {
        List<Integer> pkId = (List<Integer>) map.get("pkIds");
        return hiddenTroubleService.deleteHidden(pkId);
    }

    //根据旺旺名查询历史记录
    @RequestMapping(value = "/selectByWangWangNum", method = RequestMethod.POST)
    public RestResult selectByWangWangNumController(@RequestBody Map params) throws ParseException {
        return hiddenTroubleService.selectInfoByWangWangNum(params);
    }

    //根据pkId查询详情
    @RequestMapping(value = "/selectByPkId", method = RequestMethod.POST)
    public RestResult selectByPkIdController(@RequestBody Map params) {
        return hiddenTroubleService.selectInfoByPkId(params);
    }

    //根据旺旺名查询该用户是否存在
    @RequestMapping(value = "/selectYN", method = RequestMethod.POST)
    public RestResult selectByWangWangNum(@RequestBody HiddenTrouble hiddenTrouble) {
        return hiddenTroubleService.selectByWangWangNum(hiddenTrouble);
    }

    //上传文件到文件服务器并且指定到位置
    @RequestMapping(value = "/uploads", method = {RequestMethod.POST, RequestMethod.GET})
    //Java后台设置全局跨域
    @CrossOrigin(origins = "*", allowCredentials = "true", allowedHeaders = "", methods = {})
    public RestResult uploadFile(@RequestParam("file") MultipartFile file) throws IOException {
        if (file != null) {
            return hiddenTroubleService.upload(file);
        }
        return new RestResultBuilder().error("文件不存在!");
    }

    //上传文件属性到文件表中
    @RequestMapping(value = "/addFiles",method = RequestMethod.POST)
    public RestResult addFileController(@RequestBody Files files){
        return hiddenTroubleService.addFile(files);
    }

    //删除文件
    @RequestMapping(value="/deleteFiles",method = RequestMethod.POST)
    public RestResult deleteFileController (@RequestBody Map params){
        Integer pkId = Integer.valueOf(String.valueOf(params.get("pkId")));
        return hiddenTroubleService.deleteFile(pkId);
    }

    //根据hiddenId查询文件列表
    @RequestMapping(value = "/selectFiles",method = RequestMethod.POST)
    public RestResult selectFileController (@RequestBody Map params){
        return hiddenTroubleService.selectFile(params);
    }
}
