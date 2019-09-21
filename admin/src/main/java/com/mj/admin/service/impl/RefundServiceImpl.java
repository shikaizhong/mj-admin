package com.mj.admin.service.impl;

import com.mj.admin.service.RefundService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.ApiConstant;
import com.mj.dao.annotate.DataSource;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.Refund;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.repository.CustomerMapper;
import com.mj.dao.repository.FilesMapper;
import com.mj.dao.repository.RefundMapper;
import com.mj.dao.repository.ResponsibilityMapper;
import com.mj.dao.vo.RefundVo;
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
/**
 * @Transactional 注解管理事务的实现步骤
 * 因为一个事务里只能存在一个数据源，所以不能使用他
 */
//@Transactional
public class RefundServiceImpl implements RefundService {

    @Autowired
    private RefundMapper refundMapper;

    @Autowired
    private CustomerMapper customerMapper;

    @Autowired
    private FilesMapper filesMapper;

    @Autowired
    private PersonnelServiceImpl personnelServiceImpl;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @Autowired
    private ResponsibilityMapper responsibilityMapper;

    //分页搜索总记录数
    @DataSource(value = "druid")
    @Override
    public RestResult selectRefund(Map params) throws Exception {
        //格式化时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");

        //根据旺旺名查询
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队名查询
        String TeamName = String.valueOf(params.get("TeamName"));
        //店长ID
        String TScustomer = String.valueOf(params.get("TScustomer"));
        //招商顾问ID
        Integer PersonnelID = Integer.valueOf((Integer) params.get("PersonnelID"));

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

        //状态
        String result = String.valueOf(params.get("result"));
        if (result == "null"){
            params.put("result",-1);
        }else{
            params.put("result", result);
        }
        //将条件封装到map集合里
        params.put("wangwangnum", wangwangnum);

//        params.put("shopptype", shopptype);
//        params.put("dz", dz);
//        params.put("zsgw", zsgw);
//        params.put("teamname", teamname);
//        System.out.println("params集合的值："+params);

        //调用dao层
        List<Refund> list = refundMapper.selectRefundList(params);
        //新建一个结果集对象
        List<RefundVo> result1 = new ArrayList();
        for (Refund refund : list) {
            //获取旺旺名
            String wangwangnum1 = refund.getWangwangnum();
            System.out.println("shopptype为:"+shopptype);
            //将旺旺名传到Map集合中，并将SQLServer的查询条件封装到Map集合中
            Map put1 = new HashMap();
            put1.put("wangwangnum", wangwangnum1);
            put1.put("shopptype", shopptype);
            put1.put("username1", username1);
            put1.put("username2", username2);
            put1.put("TeamName", TeamName);
            put1.put("TScustomer", TScustomer);
            put1.put("PersonnelID", PersonnelID);

//            System.out.println("put1集合的值："+put1);
            //根据旺旺名调用personnelServerImpl接口获取数据
            List<SQLServerVo> listVos = personnelServiceImpl.selectByDatebase(put1);
            //新建一个RefundVo对象，用来存放从Refund和SQLServerVo中获取的数据
            RefundVo refundVo = new RefundVo();
            refundVo.setWangwangnum(refund.getWangwangnum());
            refundVo.setRefundCause(refund.getRefundCause());
            refundVo.setRefundChannel(refund.getRefundChannel());
            refundVo.setRefundDate(refund.getRefundDate());
            refundVo.setRemark(refund.getRemark());
            refundVo.setIsDelete(refund.getIsDelete());
            refundVo.setPkId(refund.getPkId());
            refundVo.setResult(refund.getResult());
            refundVo.setRefundAmount(refund.getRefundAmount());
            refundVo.setLevel(refund.getLevel());
            refundVo.setSonLevel(refund.getSonLevel());
//            System.out.println("获取refund里的值后："+refundVo.getRefundDate());
            if (!listVos.isEmpty()) {
                //进sqlserver获取里面的数据
                for (SQLServerVo sqlServerVo : listVos) {
                    refundVo.setDeadline(sqlServerVo.getDeadline());
                    refundVo.setTurnovermoney(sqlServerVo.getTurnovermoney());
                    refundVo.setChildtype(sqlServerVo.getChildtype());
                    refundVo.setCusttype(sqlServerVo.getCusttype());
                    refundVo.setShopptype(sqlServerVo.getShopptype());
                    refundVo.setTeamname(sqlServerVo.getTeamname());
                    refundVo.setUsername1(sqlServerVo.getUsername1());
                    refundVo.setUsername2(sqlServerVo.getUsername2());
                }
                result1.add(refundVo);
            }
        }

        //总数量
        Integer total = refundMapper.selectRefundCount(params);
        //结果集Map集合
        Map map = new HashMap();
        map.put("list", result1);
        map.put("total", total);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();

    }

    //添加退款
    @DataSource(value = "druid")
    @Override
    public RestResult addRefund(Refund refund) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        Calendar calendar = new GregorianCalendar();
        //判断旺旺名是否存在
//        System.out.println("获取旺旺名1:" + refund.getWangWangNum());
        String wangwangnum = refund.getWangwangnum();
        Map map = new HashMap();
        map.put("wangwangnum",wangwangnum);
        if (customerServiceImpl.selectByWangWangNum(map).isEmpty()) {
//            //返回信息
////            System.out.println("获取旺旺名2:" + refund.getWangWangNum());
            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(), ResultCodeEnum.USER_NOT_FOUND.getMsg());
        } else {
            //初始化
//            System.out.println("获取旺旺名3:" + refund.getWangWangNum());
            Refund refund1 = new Refund();
            refund1.setWangwangnum(refund.getWangwangnum());
            refund1.setRefundChannel(refund.getRefundChannel());
            refund1.setRemark(refund.getRemark());
            if (refund.gethDate().isEmpty()) {
                Date date = new Date();
//                date = sdf.parse(sdf.format(date));
                refund1.setRefundDate(date);
            } else {
                String str = refund.gethDate();
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
                    refund1.setRefundDate(date1);
                } else {
                    //如果为false，则执行这里的
                    //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                    long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                    //格式转化
                    String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
                    //将修改后的时间传给回访时间
                    refund1.setRefundDate(sdf2.parse(newtime));
                }

            }
            refund1.setRefundCause(refund.getRefundCause());
            refund1.setRefundAmount(refund.getRefundAmount());
            //调用添加的方法
            refundMapper.insertSelective(refund1);
            Refund refund2 = refundMapper.selectPkId();
            ResponsibilityWithBLOBs responsibility = new ResponsibilityWithBLOBs();
            responsibility.setType(2);
            responsibility.setComplaintId(refund2.getPkId());
            responsibilityMapper.insertSelective(responsibility);
            //返回信息
            return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(refund1).build();
        }
    }

    //修改退款信息
    @DataSource(value = "druid")
    @Override
    public RestResult updateRefund(RefundVo refund) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
//        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//        Calendar calendar = new GregorianCalendar();

        //根据ID查询
        RefundVo refund2 = refundMapper.selectBy(refund.getPkId());
        String str = refund.gethDate();
//        System.out.println("从测试环境获取的时间为："+str);
        //正则表达式，判断字符串长度是否在3~20之间
        String pattern = "^.{3,20}$";
        Pattern p = Pattern.compile(pattern);
        Matcher m = p.matcher(str);
        //根据正则表达式判断
        if (m.matches()) {
            //如果为true，则执行这里的
            Date date1 = sdf2.parse(str);
            //格式转化
            String newTime = sdf2.format(date1);
            //将String类型的转化成Date类型
            date1 = sdf2.parse(newTime);
            //将修改后的时间传给回访时间
            refund2.setRefundDate(date1);
        } else {
            long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
            //格式转化
            String newtime = sdf2.format(rightTime);
            refund2.setRefundDate(sdf2.parse(newtime));
        }

        refund2.setRefundChannel(refund.getRefundChannel());
        refund2.setRemark(refund.getRemark());
        refund2.setWangwangnum(refund.getWangwangnum());
        refund2.setRefundCause(refund.getRefundCause());
        refund2.setRefundAmount(refund.getRefundAmount());
        refund2.setLevel(refund.getLevel());
        refund2.setSonLevel(refund.getSonLevel());
        refundMapper.updateAll(refund2);
        return new RestResultBuilder<>().success("修改成功");
    }

    //删除
    @DataSource(value = "druid")
    @Override
    public RestResult deleteRefund(List<Integer> pkIds) {
        Integer[] pkId = new Integer[pkIds.size()];
//        System.out.println("数组长度：" + pkId);
        if (pkIds.size() > 0) {
            for (int i = 0; i < pkIds.size(); i++) {
                pkId[i] = pkIds.get(i);
//                System.out.println("数组值：" + pkId[i]);
            }
            //软删除
            refundMapper.deleteBatch(pkId);
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.error(1, "删除失败");
    }

    //根据id查询详情
//    @DataSource(value = "druid")
//    @Override
//    public RestResult selectInfoById(Map params) {
//        Integer pkId = Integer.valueOf(String.valueOf(params.get("pkId")));
////        System.out.println("222222222P:" + pkId);
//        List<RefundVo> refund = refundMapper.selectInfoByPkId(pkId);
//        for (int i = 0; i < refund.size(); i++) {
//            /**
//             * 从Customer表中获取合同开始时间和结束时间，相减，得到合同期限
//             */
////            Date ServerDeadline = refund.get(i).getServerdeadline();
//////            System.out.println("开始日期："+ServerDeadline);
////            Date ServerDeadlineEnd = refund.get(i).getServerdeadlineend();
//////            System.out.println("结束日期："+ServerDeadlineEnd);
////            Long day = (ServerDeadlineEnd.getTime() - ServerDeadline.getTime()) / (24 * 60 * 60 * 1000);
////            refund.get(i).setDeadline(day);
//        }
//        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(refund).build();
//    }

    //根据旺旺号查询对应的记录
    @DataSource(value = "druid")
    @Override
    public RestResult selectInfoByWangWangNum(Map params) throws Exception {
        //根据旺旺名查询
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队名查询
        String TeamName = String.valueOf(params.get("TeamName"));
        //店长ID
        String TScustomer = String.valueOf(params.get("TScustomer"));
        //招商顾问ID
        Integer PersonnelID = Integer.valueOf((Integer) params.get("PersonnelID"));
        List<Refund> refund = refundMapper.selectInfoByWangWangNum(wangwangnum);

        List<RefundVo> listVo = new ArrayList();

        for (Refund list : refund) {
            RefundVo refundVo = new RefundVo();
//            System.out.println("退款时间为："+list.getRefundDate());
            Map map = new HashMap();
            map.put("wangwangnum", wangwangnum);
            map.put("shopptype", shopptype);
            map.put("username1", username1);
            map.put("username2", username2);
            map.put("TeamName", TeamName);
            map.put("TScustomer",TScustomer);
            map.put("PersonnelID",PersonnelID);
            List<SQLServerVo> sqlServerVo = personnelServiceImpl.selectByDatebase(map);
            refundVo.setWangwangnum(list.getWangwangnum());
            refundVo.setRefundDate(list.getRefundDate());
            refundVo.setRefundCause(list.getRefundCause());
            refundVo.setRefundChannel(list.getRefundChannel());
            refundVo.setRemark(list.getRemark());
            refundVo.setIsDelete(list.getIsDelete());
            refundVo.setPkId(list.getPkId());
            refundVo.setRefundAmount(list.getRefundAmount());
            refundVo.setResult(list.getResult());
            if (!sqlServerVo.isEmpty()) {
                for (SQLServerVo sqlList : sqlServerVo) {
                    refundVo.setDeadline(sqlList.getDeadline());
                    refundVo.setCusttype(sqlList.getCusttype());
                    refundVo.setChildtype(sqlList.getChildtype());
                    refundVo.setShopptype(sqlList.getShopptype());
                    refundVo.setTeamname(sqlList.getTeamname());
                    refundVo.setTurnovermoney(sqlList.getTurnovermoney());
                    refundVo.setUsername1(sqlList.getUsername1());
                    refundVo.setUsername2(sqlList.getUsername2());
                }
                listVo.add(refundVo);
                for(RefundVo llll:listVo){
                }
            }

        }

        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(listVo).build();
    }

    //验证wangwangnum是否存在
    @DataSource(value = "druid")
    @Override
    public RestResult selectWang(Refund refund) {
        String wangwangnum = refund.getWangwangnum();
        Map map = new HashMap();
        map.put("wangwangnum",wangwangnum);
        if (customerServiceImpl.selectByWangWangNum(map).isEmpty()) {
            //返回信息
            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(), ResultCodeEnum.USER_NOT_FOUND.getMsg());
        } else {
            if(refundMapper.selectByRefundWangwangnum(map).size() == 0) {
                return ResultUtils.success(0);
            }else{
                return ResultUtils.error(ResultCodeEnum.ACCOUNT_EXIST.getCode(), ResultCodeEnum.ACCOUNT_EXIST.getMsg());
            }
        }
    }

    @Override
    public RestResult SelectByRefundWangwangnum(Refund refund) {
        String wangwangnum = refund.getWangwangnum();
        Map map = new HashMap();
        map.put("wangwangnum", wangwangnum);
        if(refundMapper.selectByRefundWangwangnum(map).size() == 0) {
            return ResultUtils.success(0);
        }else{
            return null;
        }
    }

    //上传文件
    @Override
    public RestResult upload(MultipartFile file) throws IOException {
        //获取文件名  场景还原文件名
        String fileName = file.getOriginalFilename();

        //获取文件的后缀名
        String suffixName = fileName.substring(fileName.lastIndexOf("."));
        //解决中文问题,linux下中文路径,图片显示问题
        String fileName1 = UUID.randomUUID().toString().replace("-", "") + suffixName;
//        fileName = UUID.randomUUID().toString().replace("-", "") + suffixName;
        //返回客户端文件路径图片显示问题
        //情景还原url
        //远程linux服务器的
//        System.out.println("文件名为"+fileName);
//        String url = "http://localhost:8080" + "/file/" + fileName1;
        String url = "http://192.168.1.112:9090/mj-admin" + "/upload/" + fileName1;
        //格式化掉.便于显示
//        String url ="/upload/"+fileName;
        //本地
//        String url ="localhost:8090"+"/upload/"+fileName;
        Files files = new Files();
//        System.out.println("12121212121:"+files.getRefundId());
        files.setUrl(url);
        files.setName(fileName);
//            filesMapper.insertSelective(files);
//        System.out.println("服务器返回的路径:" + url);
        File dest = new File(ApiConstant.UPLOAD_PATH + fileName1);//服务器的
//        File dest = new File(ApiConstant.DEV_UPLOAD_PATH + fileName1);//本地的
//        System.out.println("目录为:" + dest);
        // 检测是否存在目录
        if (!dest.getParentFile().exists()) {
            dest.getParentFile().mkdirs();
        }
        file.transferTo(dest);
        return new RestResultBuilder().setCode(0).setMsg("长传成功").setData(files).build();
    }

    //添加文件
    @Override
    public RestResult addFile(Files files) {
        Files files1 = new Files();
        files1.setUrl(files.getUrl());
        files1.setName(files.getName());
        files1.setComplaintId(files.getComplaintId());
        files1.setFileType(2);
        filesMapper.insertSelective(files1);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(files1).build();
    }

    //删除指定文件
    @Override
    public RestResult deleteFile(Integer pkId) {
//        System.out.println("pkId为：" + pkId);
        filesMapper.deleteByPrimaryKey(pkId);
        return new RestResultBuilder().setCode(0).success("删除成功");
    }

    //根据relevanceId查询历史记录
    @Override
    public RestResult selectFiles(Map params) {
        System.out.println("获取的值为:"+Integer.valueOf(String.valueOf(params.get("complaintId"))));
        Integer complaintId = Integer.valueOf(String.valueOf(params.get("complaintId")));
//        System.out.println("refundId为111111111:" + refundId);
        Map map = new HashMap();
        map.put("complaintId", complaintId);
        System.out.println("map值为:"+map);
        List<Files> files = refundMapper.selectFiles(map);
        return new RestResultBuilder().setCode(0).setMsg("查询成功").setData(files).build();
    }

}
