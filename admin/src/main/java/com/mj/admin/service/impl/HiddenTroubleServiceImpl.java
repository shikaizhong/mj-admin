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
        //格式化时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        //分页
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));

        String result = String.valueOf(params.get("result"));
        if (result == "null"){
            params.put("result",-1);
        }

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

        //时间区间的判断，若前端没有值传输，则为：[, ]
        String a = "[, ]";
        if(!String.valueOf(params.get("dateTime")).equals(a)){
            //获取前端传到后端的时间，并用字符串接受，格式为：[yyyy-MM-dd'T'HH:mm:ss.SSS'Z', yyyy-MM-dd'T'HH:mm:ss.SSS'Z']
            String dateTime = String.valueOf(params.get("dateTime"));
            //获取开始的值
            int index1 = dateTime.indexOf('[');
            //获取字符串之间的逗号所在的位置
            int index2 = dateTime.indexOf(',');
            //获取字符串之间的空格所在的位置
            int index3 = dateTime.indexOf(' ');
            //获取最后的值
            int index4 = dateTime.indexOf(']');
            //截断字符串，获取开始时间的值
            String startTime = dateTime.substring(index1+1,index2);
            //截断字符串，获取结束时间的值
            String endTime = dateTime.substring(index3+1,index4);
            //将开始时间转化为Date类型
            Date date1 = sdf1.parse(startTime);
            calendar.setTime(date1);
            calendar.add(Calendar.HOUR, 8);// 24小时制
            date1 = calendar.getTime();
            //将结束时间转化为Date类型
            Date date2 = sdf1.parse(endTime);
            calendar.setTime(date2);
            calendar.add(Calendar.HOUR, 32);// 24小时制
            date2 = calendar.getTime();
            //将时间传输给Map集合
            params.put("startTime", date1);
            params.put("endTime", date2);
        }else{
            params.put("startTime", null);
            params.put("endTime", null);
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

        //调用查询数据总数的dao层
        List<HiddenTrouble> hiddenTroubles = hiddenTroubleMapper.selectHiddenList(params);
        List<HiddenTroubleVo> result1 = new ArrayList();
        if(!hiddenTroubles.isEmpty()) {
            for (HiddenTrouble listHidden : hiddenTroubles) {
                HiddenTroubleVo hiddenTroubleVo = new HiddenTroubleVo();
                String wangwangnums = listHidden.getWangwangnum();
                hiddenTroubleVo.setWangwangnum(listHidden.getWangwangnum());
                hiddenTroubleVo.setFrequency(listHidden.getFrequency());
                hiddenTroubleVo.setHiddenDate(listHidden.getHiddenDate());
                hiddenTroubleVo.setHiddenContent(listHidden.getHiddenContent());
                hiddenTroubleVo.setIsDelete(listHidden.getIsDelete());
                hiddenTroubleVo.setPkId(listHidden.getPkId());
                hiddenTroubleVo.setResult(listHidden.getResult());
                hiddenTroubleVo.setRemark(listHidden.getRemark());
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
                        result1.add(hiddenTroubleVo);
                    }
            }
        }

        //调用查询的dao层
        Integer total = hiddenTroubleMapper.total(params);
        Map map = new HashMap();
        map.put("list", result1);
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
            Integer frequency = hiddenTroubleMapper.totalWangWangNum(hiddenTrouble.getWangwangnum());
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
            } else {
                String str = hiddenTrouble.gethDate();
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
                    //将修改后的时间传给回访时间
                    hiddenTrouble1.setHiddenDate(date1);
                } else {
                    //如果为false，则执行这里的
                    //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                    long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                    //格式转化
                    String newtime = sdf2.format(rightTime);
                    //将修改后的时间传给回访时间
                    hiddenTrouble1.setHiddenDate(sdf2.parse(newtime));
                }
            }
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
        HiddenTrouble hiddenTrouble1 = hiddenTroubleMapper.selectByPrimaryKey(hiddenTrouble.getPkId());
        hiddenTrouble1.setHiddenContent(hiddenTrouble.getHiddenContent());
        //初始化
        String str = hiddenTrouble.gethDate();
        //通过正则表达式判断前端获取的时间是否为格林威治时间
        String pattern = "^.{3,20}$";
        Pattern r = Pattern.compile(pattern);
        Matcher m = r.matcher(str);
        //若是格林威治时间，则执行else，若不是，则直接执行
        if (m.matches()) {
            Date date1 = sdf2.parse(str);
            long rightTime = (long) (date1.getTime() + 8 * 60 * 60 * 1000);
            String newtime = sdf2.format(rightTime);
            date1 = sdf2.parse(newtime);
            hiddenTrouble1.setHiddenDate(date1);
        } else {
            long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
            String newtime = sdf2.format(rightTime);
            hiddenTrouble1.setHiddenDate(sdf2.parse(newtime));
        }
        hiddenTrouble1.setRemark(hiddenTrouble.getRemark());
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
            hiddenTroubleVo.setResult(list.getResult());
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
