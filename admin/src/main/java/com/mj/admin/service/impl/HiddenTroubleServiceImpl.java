package com.mj.admin.service.impl;

import com.mj.admin.datasource.annotation.DataSource;
import com.mj.admin.service.HiddenTroubleService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.ApiConstant;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.HiddenTrouble;
import com.mj.dao.repository.FilesMapper;
import com.mj.dao.repository.HiddenTroubleMapper;
import com.mj.dao.vo.HiddenTroubleVo;
import com.mj.dao.vo.SQLServerVo;
import org.apache.commons.lang.ObjectUtils;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
//@Transactional
public class HiddenTroubleServiceImpl implements HiddenTroubleService {

    @Autowired
    private HiddenTroubleMapper hiddenTroubleMapper;

    @Autowired
    private FilesMapper filesMapper;

    @Autowired
    private PersonnelServiceImpl personnelServiceImpl;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    //查询，搜索，分页
    @DataSource(value = "druid")
    @Override
    public RestResult selectHidden(Map params) throws Exception {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        //分页
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        String status = String.valueOf(params.get("status"));


        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队名查询
        String teamname = String.valueOf(params.get("teamname"));
        //根据旺旺名查询
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        //根据隐患次数查询
        String frequency = String.valueOf(params.get("frequency"));

        //根据开始时间，结束时间查询
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar calendar = new GregorianCalendar();
        String str1 = ObjectUtils.toString(params.get("startTime"), "");
        if(!StringUtils.isNotBlank(str1)){
            Date startTime = sdf2.parse("2000-1-1 00:00:00");
            params.put("startTime", startTime);
        }else{
            String startTime = String.valueOf(params.get("startTime"));
            String pattern = "^.{3,20}$";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(startTime);
            //根据正则表达式判断
            if (m.matches()) {
                Date date1 = sdf2.parse(startTime);
                long rightTime = (long) (date1.getTime() + 8 * 60 * 60 * 1000);
                String newTime = sdf2.format(rightTime);
                date1 = sdf2.parse(newTime);
                params.put("startTime", date1);
            } else {
                Date date1 = new Date();
                long rightTime = (long) (sdf1.parse(startTime).getTime() + 8 * 60 * 60 * 1000);
                String newTime = sdf2.format(rightTime);
                date1 = sdf2.parse(newTime);
                params.put("startTime", date1);
            }
        }

        String str2 = ObjectUtils.toString(params.get("endTime"), "");
        if(!StringUtils.isNotBlank(str2)){
            Date endTime = sdf2.parse("2099-12-31 23:59:59");
            params.put("endTime", endTime);
        }else{
            String endTime = String.valueOf(params.get("endTime"));
            String pattern = "^.{3,20}$";
            Pattern p = Pattern.compile(pattern);
            Matcher m = p.matcher(endTime);
            //根据正则表达式判断
            if (m.matches()) {
                Date date1 = sdf2.parse(endTime);
                long rightTime = (long) (date1.getTime() + 8 * 60 * 60 * 1000);
                String newTime = sdf2.format(rightTime);
                date1 = sdf2.parse(newTime);
                params.put("startTime", date1);
            } else {
                Date date1 = new Date();
                long rightTime = (long) (sdf1.parse(endTime).getTime() + 8 * 60 * 60 * 1000);
                String newTime = sdf2.format(rightTime);
                date1 = sdf2.parse(newTime);
                params.put("endTime", date1);
            }
        }

        if (pageNum == 1) {
            pageNum = 0;
        } else {
            pageNum = (pageNum - 1) * pageSize;
        }

        params.put("pageNum", pageNum);
        params.put("pageSize", pageSize);
        if (!wangwangnum.isEmpty()) {
            params.put("wangwangnum", wangwangnum);
        }
        if (frequency == "null") {
            params.put("frequency", null);
        }
        if(status == "null"){
            params.put("status", -1);
        }

        //调用查询数据总数的dao层
        List<HiddenTrouble> hiddenTroubles = hiddenTroubleMapper.selectHiddenList(params);
        List<HiddenTroubleVo> result = new ArrayList();
        if(!hiddenTroubles.isEmpty()) {
            for (HiddenTrouble listHidden : hiddenTroubles) {
                HiddenTroubleVo hiddenTroubleVo = new HiddenTroubleVo();
                String wangwangnums = listHidden.getWangwangnum();
                hiddenTroubleVo.setWangwangnum(listHidden.getWangwangnum());
                hiddenTroubleVo.setFrequency(listHidden.getFrequency());
                hiddenTroubleVo.setHiddenDate(listHidden.getHiddenDate());
                hiddenTroubleVo.setHiddenContent(listHidden.getHiddenContent());
                hiddenTroubleVo.setIsDelete(listHidden.getIsDelete());
                hiddenTroubleVo.setLevel(listHidden.getLevel());
                hiddenTroubleVo.setPkId(listHidden.getPkId());
                hiddenTroubleVo.setRemark(listHidden.getRemark());
                hiddenTroubleVo.setStatus(listHidden.getStatus());
                Map map = new HashMap();
                if(!wangwangnums.isEmpty()){
                    map.put("wangwangnum", wangwangnums);
                }
                if(!username1.isEmpty()){
                    map.put("username1", username1);
                }
                if(!username2.isEmpty()){
                    map.put("username2", username2);
                }
                if(!shopptype.isEmpty()){
                    map.put("shopptype", shopptype);
                }
                if(!teamname.isEmpty()){
                    map.put("teamname", teamname);
                }
                List<SQLServerVo> sqlServerVo = personnelServiceImpl.selectByDatebase(map);
                    if (!sqlServerVo.isEmpty()) {
                        for (SQLServerVo listVo : sqlServerVo) {
                            hiddenTroubleVo.setCusttype(listVo.getCusttype());
                            hiddenTroubleVo.setChildtype(listVo.getChildtype());
                            hiddenTroubleVo.setShopptype(listVo.getShopptype());
                            hiddenTroubleVo.setTeamname(listVo.getTeamname());
                            hiddenTroubleVo.setUsername1(listVo.getUsername1());
                            hiddenTroubleVo.setUsername2(listVo.getUsername2());
                        }
                        result.add(hiddenTroubleVo);
                    }


            }
        }

        //调用查询的dao层
        Integer total = hiddenTroubleMapper.total(params);
        Map map = new HashMap();
        map.put("list", result);
        map.put("total", total);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }

    //添加隐患
    @DataSource(value = "druid")
    @Override
    public RestResult addHidden(HiddenTrouble hiddenTrouble) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = new GregorianCalendar();

        //判断旺旺名是否存在
        Map map = new HashMap();
        String wangwangnum = hiddenTrouble.getWangwangnum();
        map.put("wangwangnum",wangwangnum);
        if (customerServiceImpl.selectByWangWangNum(map).isEmpty()) {
            return ResultUtils.error(ResultCodeEnum.ROLE_NOT_FOUND.getCode(), ResultCodeEnum.ROLE_NOT_FOUND.getMsg());
        } else {
            //查询该旺旺名的隐患总数
//            System.out.println("hiddenTrouble为:" + hiddenTrouble);
            Integer frequency = hiddenTroubleMapper.totalWangWangNum(hiddenTrouble.getWangwangnum());
//            System.out.println("frequency为：" + frequency);
            //初始化
            HiddenTrouble hiddenTrouble1 = new HiddenTrouble();
            hiddenTrouble1.setWangwangnum(hiddenTrouble.getWangwangnum());
            if (frequency == null) {
                frequency = 0;
            }
            hiddenTrouble1.setFrequency(frequency + 1);
            hiddenTrouble1.setHiddenContent(hiddenTrouble.getHiddenContent());
            hiddenTrouble1.setRemark(hiddenTrouble.getRemark());
            //时间格式处理
            if (hiddenTrouble.getHiddenDate() == null) {
                Date date = new Date();
                hiddenTrouble1.setHiddenDate(date);
//                System.out.println("date为:" + hiddenTrouble1.getHiddenDate());
            } else {
                String str = hiddenTrouble.gethDate();
//        System.out.println("从测试环境获取的时间为："+str);
                //正则表达式，判断字符串长度是否在3~20之间
                String pattern = "^.{3,20}$";
                Pattern p = Pattern.compile(pattern);
                Matcher m = p.matcher(str);
                //根据正则表达式判断
                if (m.matches()) {
                    //如果为true，则执行这里的
                    Date date1 = sdf2.parse(str);
                    //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                    long rightTime = (long) (date1.getTime() + 8 * 60 * 60 * 1000);
                    //格式转化
                    String newTime = sdf2.format(rightTime);
                    //将String类型的转化成Date类型
                    date1 = sdf2.parse(newTime);
//            System.out.println("时间为（正常）："+date1);
                    //将修改后的时间传给回访时间
                    hiddenTrouble1.setHiddenDate(date1);
                } else {
                    //如果为false，则执行这里的
                    //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                    long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                    //格式转化
                    String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
                    //将修改后的时间传给回访时间
                    hiddenTrouble1.setHiddenDate(sdf2.parse(newtime));
                }
            }
//            System.out.println("hiddenTrouble1为：" + hiddenTrouble1);

            //调用添加的dao层
            hiddenTroubleMapper.insertSelective(hiddenTrouble1);

            return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(hiddenTrouble1).build();
        }
    }

    //删除隐患
    @DataSource(value = "druid")
    @Override
    public RestResult deleteHidden(List<Integer> pkIds) {
        Integer[] pkId = new Integer[pkIds.size()];
//        System.out.println("数组长度：" + pkId);
        if (pkIds.size() > 0) {
            for (int i = 0; i < pkIds.size(); i++) {
                pkId[i] = pkIds.get(i);
//                System.out.println("数组值：" + pkId[i]);
            }
            //软删除
            hiddenTroubleMapper.deleteHidden(pkId);
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.error(1, "删除失败");
    }

    //修改
    @DataSource(value = "druid")
    @Override
    public RestResult updateHidden(HiddenTrouble hiddenTrouble) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = new GregorianCalendar();
        HiddenTrouble hiddenTrouble1 = hiddenTroubleMapper.selectByPrimaryKey(hiddenTrouble.getPkId());
//        System.out.println("从前端获取的时间为："+hiddenTrouble.getHiddenDate());
        hiddenTrouble1.setHiddenContent(hiddenTrouble.getHiddenContent());
//        calendar.setTime(hiddenTrouble.getHiddenDate());
//        calendar.add(calendar.DATE, 1);
//        hiddenTrouble1.setRemark(hiddenTrouble.getRemark());
//        hiddenTrouble1.setHiddenDate(calendar.getTime());
//        System.out.println("隐患时间为："+hiddenTrouble.getHiddenDate());
        String str = hiddenTrouble.gethDate();
//        System.out.println("从测试环境获取的时间为："+str);
        //正则表达式，判断字符串长度是否在3~20之间
        String pattern = "^.{3,20}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        //根据正则表达式判断
        if (m.matches()) {
            //如果为true，则执行这里的
            Date date1 = sdf2.parse(str);
            //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
            long rightTime = (long) (date1.getTime() + 8 * 60 * 60 * 1000);
            //格式转化
            String newTime = sdf2.format(rightTime);
            //将String类型的转化成Date类型
            date1 = sdf2.parse(newTime);
//            System.out.println("时间为（正常）："+date1);
            //将修改后的时间传给回访时间
            hiddenTrouble1.setHiddenDate(date1);
        } else {
            //如果为false，则执行这里的
            //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
            long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
            //格式转化
            String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
            //将修改后的时间传给回访时间
            hiddenTrouble1.setHiddenDate(sdf2.parse(newtime));
        }

//        hiddenTrouble1.setHiddenDate(hiddenTrouble.getHiddenDate());
//        System.out.println("隐患修改后的时间为："+hiddenTrouble1.getHiddenDate());
        hiddenTrouble1.setRemark(hiddenTrouble.getRemark());
//        System.out.println("修改时间为："+calendar.getTime());
        //调用修改的dao方法
        hiddenTroubleMapper.updateByPrimaryKeySelective(hiddenTrouble1);
        return new RestResultBuilder<>().success("修改成功");
    }

    //根据旺旺名查询历史记录
    @DataSource(value = "druid")
    @Override
    public RestResult selectInfoByWangWangNum(Map params) throws ParseException {
        //根据旺旺名查询
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队名查询
        String teamname = String.valueOf(params.get("teamname"));
//        System.out.println("Refund_旺旺名为:" + wangwangnum);
        List<HiddenTrouble> hiddenTrouble = hiddenTroubleMapper.selectByWangWangNum(wangwangnum);

        List<HiddenTroubleVo> listVo = new ArrayList();

        for (HiddenTrouble list : hiddenTrouble) {
            HiddenTroubleVo hiddenTroubleVo = new HiddenTroubleVo();
//            System.out.println("退款时间为："+list.getRefundDate());
            Map map = new HashMap();
            map.put("wangwangnum", wangwangnum);
            map.put("shopptype", shopptype);
            map.put("username1", username1);
            map.put("username2", username2);
            map.put("teamname", teamname);
//            System.out.println("Refund_map集合里的数据：" + map);
            List<SQLServerVo> sqlServerVo = personnelServiceImpl.selectByDatebase(map);
//            System.out.println("干啥呢？不想好了？");
            hiddenTroubleVo.setWangwangnum(list.getWangwangnum());
            hiddenTroubleVo.setHiddenDate(list.getHiddenDate());
            hiddenTroubleVo.setFrequency(list.getFrequency());
            hiddenTroubleVo.setRemark(list.getRemark());
            hiddenTroubleVo.setIsDelete(list.getIsDelete());
            hiddenTroubleVo.setHiddenContent(list.getHiddenContent());
            hiddenTroubleVo.setPkId(list.getPkId());
            hiddenTroubleVo.setLevel(list.getLevel());
            hiddenTroubleVo.setStatus(list.getStatus());
            hiddenTroubleVo.setHiddenDate(list.getHiddenDate());
//            System.out.println("Refund_获取refund里的值后：" + refundVo);
            if (!sqlServerVo.isEmpty()) {
                for (SQLServerVo sqlList : sqlServerVo) {
                    hiddenTroubleVo.setCusttype(sqlList.getCusttype());
                    hiddenTroubleVo.setChildtype(sqlList.getChildtype());
                    hiddenTroubleVo.setShopptype(sqlList.getShopptype());
                    hiddenTroubleVo.setTeamname(sqlList.getTeamname());
                    hiddenTroubleVo.setUsername1(sqlList.getUsername1());
                    hiddenTroubleVo.setUsername2(sqlList.getUsername2());
//                    System.out.println("Refund_获取sqlserver里的值后：" + refundVo.getRefundDate());

                }
//                System.out.println("Refund_获取sqlserver里的值后11111：" + refundVo.getRefundDate());
                listVo.add(hiddenTroubleVo);
            }
        }
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(listVo).build();
    }

    //根据pkId查询详情
    @DataSource(value = "druid")
    @Override
    public RestResult selectInfoByPkId(Map params) {
        Integer pkId = Integer.valueOf(String.valueOf(params.get("pkId")));
        //调用dao层
        List<HiddenTroubleVo> hiddenTroubleVo = hiddenTroubleMapper.selectByPkId(pkId);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(hiddenTroubleVo).build();
    }

    //根据旺旺名查询该用户存不存在
    @Override
    public RestResult selectByWangWangNum(HiddenTrouble hiddenTrouble) {
        String wangwangnum = hiddenTrouble.getWangwangnum();
        Map map = new HashMap();
        map.put("wangwangnum", wangwangnum);
        if(customerServiceImpl.selectByWangWangNum(map).isEmpty()){
            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(), ResultCodeEnum.USER_NOT_FOUND.getMsg());
        } else {
            return ResultUtils.error(ResultCodeEnum.ACCOUNT_EXIST.getCode(), ResultCodeEnum.ACCOUNT_EXIST.getMsg());
        }
    }

    //上传文件
    @Override
    public RestResult upload(MultipartFile file) throws IOException {
        //获取文件名
        String fileName = file.getOriginalFilename();
        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //解决文件中文名称问题
        String fileName1 = UUID.randomUUID().toString().replace("-", "") + suffixName;
        //文件地址
//        String url = "http://localhost:8080" + "/file/" + fileName1;
        String url = "http://192.168.1.112:9090/mj-admin" + "/upload/" + fileName1;

        Files files = new Files();

        files.setUrl(url);
        files.setName(fileName);
        File dest = new File(ApiConstant.UPLOAD_PATH + fileName1);//服务器的
        //文件长传的地址，本地
//        File dest = new File(ApiConstant.DEV_UPLOAD_PATH + fileName1);

        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return new RestResultBuilder().setCode(0).setMsg("上传成功").setData(files).build();
    }

    //添加文件
    @Override
    public RestResult addFile(Files files){
        Files files1 = new Files();
        files1.setName(files.getName());
        files1.setUrl(files.getUrl());
        files1.setFileType(3);
        files1.setComplaintId(files.getComplaintId());
        filesMapper.insertSelective(files1);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(files1).build();
    }

    //删除文件
    @Override
    public RestResult deleteFile(Integer pkId){
        filesMapper.deleteByPrimaryKey(pkId);
        return new RestResultBuilder().setCode(0).success("删除成功");
    }

    //根据hiddenId查询文件列表
    @Override
    public RestResult selectFile(Map params){
        Integer complaintId = Integer.valueOf(String.valueOf(params.get("complaintId")));
        Map map = new HashMap();
        map.put("complaintId",complaintId);
        List<Files> list = hiddenTroubleMapper.selectFiles(map);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(list).build();
    }
}
