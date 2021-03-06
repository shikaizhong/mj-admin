package com.mj.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mj.admin.service.ResponsibilityService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.tools.PageUtils;
import com.mj.dao.entity.*;
import com.mj.dao.repository.*;
import com.mj.dao.vo.*;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
//@Transactional
public class ResponsibilityServiceImpl implements ResponsibilityService {
    @Autowired
    private ResponsibilityMapper responsibilityMapper;
    @Autowired
    private PersonnelServiceImpl personnelService;
    @Autowired
    private FilesMapper filesMapper;
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private RefundMapper refundMapper;
    @Autowired
    private HiddenTroubleMapper hiddenTroubleMapper;
    @Autowired
    private ComplaintLevelMapper complaintLevelMapper;
    private Map params;

    //查询搜索弃用
    @Override
    public RestResult selectResponsiblity(Map params) throws Exception {
        //格式化时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        Integer typess = Integer.valueOf(String.valueOf(params.get("type")));
        String PersonnelID = String.valueOf(params.get("PersonnelID"));
        String keyword = String.valueOf(params.get("keyword"));
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
        String TeamName = String.valueOf(params.get("TeamName"));
        if (TeamName == "") {
            params.put("TeamName", null);
        }
        String results = String.valueOf(params.get("result"));
        if (results == "null") {
            params.put("result", -1);
        }else if(results.equals("5")){
            params.put("result", null);
        }
        String grade = String.valueOf(params.get("grade"));
        if (grade == "") {
            params.put("grade", null);
        }
        params.put("type", typess);
        params.put("keyword", keyword);
        List<ResponsibilityVo> list = responsibilityMapper.selectResponsiblity(params);
        List<ResponsibilityVo> result = new ArrayList<ResponsibilityVo>();
        //循环拿数据
        for (ResponsibilityVo vo : list) {
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum", wangwangnum);
            ResponsibilityVo responsibilityVo = new ResponsibilityVo();
            ResponsibilityVo responsibilityVos = personnelService.selectResponsibilityList(params);
            //取出mysql数据库数据
            responsibilityVo.setBasic(vo.getBasic());
            responsibilityVo.setChannel(vo.getChannel());
            responsibilityVo.setComplaintdate(vo.getComplaintdate());
            responsibilityVo.setComplaintId(vo.getComplaintId());
            responsibilityVo.setComplaintName(vo.getComplaintName());
            responsibilityVo.setCreateTime(vo.getCreateTime());
            responsibilityVo.setDeal(vo.getDeal());
            responsibilityVo.setGrade(vo.getGrade());
            if (vo.getLevel() != null) {
                responsibilityVo.setLevel(vo.getLevel());
            }
            responsibilityVo.setSonLevel(vo.getSonLevel());
            responsibilityVo.setParentName(vo.getParentName());
            responsibilityVo.setParentId(vo.getParentId());
//            responsibilityVo.setComplaintId(vo.getPkId());
            //责任人
            responsibilityVo.setResponsibilityer(vo.getResponsibilityer());
            //判责人员
            responsibilityVo.setResponsibilityor(vo.getResponsibilityor());
            responsibilityVo.setResult(vo.getResult());
            responsibilityVo.setSummary(vo.getSummary());
            responsibilityVo.setType(vo.getType());
            responsibilityVo.setWangwangnum(vo.getWangwangnum());
            if (responsibilityVos != null) {
                responsibilityVo.setPersonnelid(responsibilityVos.getPersonnelid());
                responsibilityVo.setPname(responsibilityVos.getPname());
                responsibilityVo.setPteamname(responsibilityVos.getPteamname());
                responsibilityVo.setTscustomer(responsibilityVos.getTscustomer());
                responsibilityVo.setTename(responsibilityVos.getTename());
                responsibilityVo.setTeamname(responsibilityVos.getTeamname());
                responsibilityVo.setShopptype(responsibilityVos.getShopptype());
                responsibilityVo.setServerdeadline(responsibilityVos.getServerdeadline());
                result.add(responsibilityVo);
            }
        }
        String types = String.valueOf(params.get("type"));
        Integer type = Integer.parseInt(types);
        Integer total = 0;
        if (type == 0) {
            total = responsibilityMapper.selectComplaintCount(params);
        }
        Map map = new HashMap();
        map.put("list", result);
        map.put("total", total);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }

    //使用分页插件分页
    @Override
    public PageResult pageHelper(PageRequest pageRequest) throws Exception {
        return PageUtils.getPageResult(pageRequest, getPageInfo(pageRequest));
    }

    private PageInfo<Responsibility> getPageInfo(PageRequest pageRequest) throws Exception {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Responsibility> responsibilities = responsibilityMapper.page();

        return new PageInfo<Responsibility>(responsibilities);
    }

    @Transactional
    @Override
    //修改判责信息
    public RestResult updataResponsiblity(ResponsibilityWithBLOBs responsibilityWithBLOBs) throws ParseException {
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd HH:mm");
        ResponsibilityWithBLOBs responsibilityWithBLOBs1 = responsibilityMapper.selectByComplaintId(responsibilityWithBLOBs.getAspId());
//        System.out.println("传入的时间为"+responsibilityWithBLOBs.getCreateTime());
        //如果实体里面有数据则是修改
        if (responsibilityWithBLOBs1 != null) {
            //如果是无责或者待定的状态产生联动
            if (responsibilityWithBLOBs.getResult() == 1) {
                responsibilityWithBLOBs1.setResult(responsibilityWithBLOBs.getResult());
                responsibilityWithBLOBs1.setLevel(0);
                responsibilityWithBLOBs1.setSonLevel(0);
                responsibilityWithBLOBs1.setResponsibilityer(0);
                responsibilityWithBLOBs1.setGrade(0);
                responsibilityWithBLOBs1.setBasic(responsibilityWithBLOBs.getBasic());
                responsibilityWithBLOBs1.setDeal(responsibilityWithBLOBs.getDeal());
                responsibilityWithBLOBs1.setSummary(responsibilityWithBLOBs.getSummary());
                responsibilityWithBLOBs1.setResponsibilityor(responsibilityWithBLOBs.getResponsibilityor());
                responsibilityWithBLOBs1.setType(responsibilityWithBLOBs.getType());
                String str1 = responsibilityWithBLOBs.gethDate();
                if (!StringUtils.isNotBlank(str1)) {
                    Date date = new Date();
                    responsibilityWithBLOBs.setCreateTime(date);
                } else {
                    String str = responsibilityWithBLOBs.gethDate();
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
                        responsibilityWithBLOBs1.setCreateTime(date1);
                    } else {
                        //如果为false，则执行这里的
                        //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                        long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                        //格式转化
                        String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
                        //将修改后的时间传给回访时间
                        responsibilityWithBLOBs1.setCreateTime(sdf2.parse(newtime));
                    }
                }
                responsibilityMapper.updateByPrimaryKeySelective(responsibilityWithBLOBs1);
            } else {
                responsibilityWithBLOBs1.setResult(responsibilityWithBLOBs.getResult());
                responsibilityWithBLOBs1.setResponsibilityer(responsibilityWithBLOBs.getResponsibilityer());
                responsibilityWithBLOBs1.setGrade(responsibilityWithBLOBs.getGrade());
                responsibilityWithBLOBs1.setType(responsibilityWithBLOBs.getType());
                responsibilityWithBLOBs1.setLevel(responsibilityWithBLOBs.getLevel());
                responsibilityWithBLOBs1.setSonLevel(responsibilityWithBLOBs.getSonLevel());
                responsibilityWithBLOBs1.setBasic(responsibilityWithBLOBs.getBasic());
                responsibilityWithBLOBs1.setDeal(responsibilityWithBLOBs.getDeal());
                responsibilityWithBLOBs1.setSummary(responsibilityWithBLOBs.getSummary());
                responsibilityWithBLOBs1.setResponsibilityor(responsibilityWithBLOBs.getResponsibilityor());
                responsibilityWithBLOBs1.setType(responsibilityWithBLOBs.getType());
                String str1 = responsibilityWithBLOBs.gethDate();
                if (!StringUtils.isNotBlank(str1)) {
                    Date date = new Date();
//                date = sdf.parse(sdf.format(date));
                    responsibilityWithBLOBs1.setCreateTime(date);
                } else {
                    String str = responsibilityWithBLOBs.gethDate();
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
                        responsibilityWithBLOBs1.setCreateTime(date1);
                    } else {
                        //如果为false，则执行这里的
                        //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                        long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                        //格式转化
                        String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
                        //将修改后的时间传给回访时间
                        responsibilityWithBLOBs1.setCreateTime(sdf2.parse(newtime));
                    }
                }
            }
            responsibilityMapper.updateByPrimaryKeySelective(responsibilityWithBLOBs1);
        }
        //如果实体里面没有数据则是增加
        if (responsibilityWithBLOBs1 == null) {
            ResponsibilityWithBLOBs responsibilityWithBLOBs2 = new ResponsibilityWithBLOBs();
            responsibilityWithBLOBs2.setBasic(responsibilityWithBLOBs.getBasic());
            responsibilityWithBLOBs2.setDeal(responsibilityWithBLOBs.getDeal());
            responsibilityWithBLOBs2.setSummary(responsibilityWithBLOBs.getSummary());
            responsibilityWithBLOBs2.setLevel(responsibilityWithBLOBs.getLevel());
            responsibilityWithBLOBs2.setSonLevel(responsibilityWithBLOBs.getSonLevel());
            responsibilityWithBLOBs2.setResult(responsibilityWithBLOBs.getResult());
            responsibilityWithBLOBs2.setResponsibilityer(responsibilityWithBLOBs.getResponsibilityer());
            responsibilityWithBLOBs2.setResponsibilityor(responsibilityWithBLOBs.getResponsibilityor());
            responsibilityWithBLOBs2.setGrade(responsibilityWithBLOBs.getGrade());
            responsibilityWithBLOBs2.setComplaintId(responsibilityWithBLOBs.getComplaintId());
            responsibilityWithBLOBs2.setType(responsibilityWithBLOBs.getType());
            if (responsibilityWithBLOBs.gethDate().isEmpty()) {
                Date date = new Date();
//                date = sdf.parse(sdf.format(date));
                responsibilityWithBLOBs2.setCreateTime(date);
            } else {
                String str = responsibilityWithBLOBs.gethDate();
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
                    responsibilityWithBLOBs2.setReDate(date1);
                } else {
                    //如果为false，则执行这里的
                    //从前端iview获取的时间为格林威治时间，所以需要加上8个小时为本地时间
                    long rightTime = (long) (sdf1.parse(str).getTime() + 8 * 60 * 60 * 1000);
                    //格式转化
                    String newtime = sdf2.format(rightTime);
//            System.out.println("时间为（格林威治时间）："+sdf2.parse(newtime));
                    //将修改后的时间传给回访时间
                    responsibilityWithBLOBs2.setReDate(sdf2.parse(newtime));
                }

            }
            responsibilityMapper.insertSelective(responsibilityWithBLOBs2);
        }
        return new RestResultBuilder<>().success("操作成功");
    }

    //添加文件
    @Transactional
    @Override
    public RestResult addFile(Files files) {
        Files files1 = new Files();
        files1.setUrl(files.getUrl());
        files1.setName(files.getName());
        files1.setComplaintId(files.getComplaintId());
        files1.setFileType(1);
        filesMapper.insertSelective(files1);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(files1).build();
    }

    //根据id查询投诉信息
    @Override
    public RestResult selectById(Map params) {
        List<ComplaintVo> list = complaintMapper.selectById(params);
        List<ComplaintVo> result = new ArrayList<>();
        for (ComplaintVo vo : list) {
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum", wangwangnum);
            ComplaintVo complaintVos = personnelService.selectByPkId(params);
            ComplaintVo complaintVo = new ComplaintVo();
            complaintVo.setScenerestoration(vo.getScenerestoration());
            complaintVo.setResult(vo.getResult());
            complaintVo.setCreateTime(vo.getCreateTime());
            complaintVo.setId(vo.getId());
            complaintVo.setChannel(vo.getChannel());
            complaintVo.setComplaintdate(vo.getComplaintdate());
            complaintVo.setDepartment(vo.getDepartment());
            complaintVo.setWorktype(vo.getWorktype());
            complaintVo.setRemark(vo.getRemark());
//            complaintVo.setPkId(vo.getPkId());
            complaintVo.setIsStop(vo.getIsStop());
            complaintVo.setIsDelete(vo.getIsDelete());
            complaintVo.setFrequency(vo.getFrequency());
            complaintVo.setContent(vo.getContent());
            complaintVo.setWangwangnum(vo.getWangwangnum());
            if (complaintVos != null) {
                complaintVo.setTechnologyrecruitmentid(complaintVos.getTechnologyrecruitmentid());
                complaintVo.setShopptype(complaintVos.getShopptype());
                complaintVo.setPersonnelid(complaintVos.getPersonnelid());
                complaintVo.setTscustomer(complaintVos.getTscustomer());
                complaintVo.setTeamid(complaintVos.getTeamid());
                complaintVo.setTeamname(complaintVos.getTeamname());
                complaintVo.setUsername(complaintVos.getUsername());
                complaintVo.setPname(complaintVos.getPname());
                complaintVo.setTename(complaintVos.getTename());
                result.add(complaintVo);
            }
        }
        Map map = new HashMap();
        map.put("list", result);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }

    //根据id查询退款信息
    @Override
    public RestResult selectInfoByPkId(Map params) throws ParseException {
        List<Refund> list = refundMapper.selectInfoByPkId(params);
        List<RefundVo> result = new ArrayList<>();
        for (Refund vo : list) {
            RefundVo refundVo = new RefundVo();
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum", wangwangnum);
            List<SQLServerVo> sqlServerVo = personnelService.selectByDatebase(params);
            refundVo.setWangwangnum(vo.getWangwangnum());
            refundVo.setRefundDate(vo.getRefundDate());
            refundVo.setRefundCause(vo.getRefundCause());
            refundVo.setRefundChannel(vo.getRefundChannel());
            refundVo.setRemark(vo.getRemark());
            refundVo.setIsDelete(vo.getIsDelete());
//            refundVo.setPkId(vo.getPkId());
            refundVo.setRefundAmount(vo.getRefundAmount());
            refundVo.setResult(vo.getResult());
            if (!sqlServerVo.isEmpty()) {
                for (SQLServerVo sqlList : sqlServerVo) {
                    refundVo.setDeadline(sqlList.getDeadline());
                    refundVo.setCusttype(sqlList.getCusttype());
                    refundVo.setChildtype(sqlList.getChildtype());
                    refundVo.setShopptype(sqlList.getShopptype());
                    refundVo.setTeamname(sqlList.getTeamname());
                    refundVo.setUsername1(sqlList.getUsername1());
                    refundVo.setUsername2(sqlList.getUsername2());
                }
            }
            result.add(refundVo);
        }
        Map map = new HashMap();
        map.put("list", result);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }

    //根据id查询隐患信息

    @Override
    public RestResult selectByHId(Map params) throws ParseException {
        List<HiddenTrouble> hiddenTroubles = hiddenTroubleMapper.selectById(params);
        List<HiddenTroubleVo> result = new ArrayList();
        if (!hiddenTroubles.isEmpty()) {
            for (HiddenTrouble listHidden : hiddenTroubles) {
                HiddenTroubleVo hiddenTroubleVo = new HiddenTroubleVo();
                String wangwangnum = listHidden.getWangwangnum();
                hiddenTroubleVo.setWangwangnum(listHidden.getWangwangnum());
                hiddenTroubleVo.setFrequency(listHidden.getFrequency());
                hiddenTroubleVo.setHiddenDate(listHidden.getHiddenDate());
                hiddenTroubleVo.setHiddenContent(listHidden.getHiddenContent());
                hiddenTroubleVo.setIsDelete(listHidden.getIsDelete());
//                hiddenTroubleVo.setPkId(listHidden.getPkId());
                hiddenTroubleVo.setRemark(listHidden.getRemark());
                hiddenTroubleVo.setResult(listHidden.getResult());
                params.put("wangwangnum", wangwangnum);
                List<SQLServerVo> sqlServerVo = personnelService.selectByDatebase(params);
                if (!sqlServerVo.isEmpty()) {
                    for (SQLServerVo listVo : sqlServerVo) {
                        hiddenTroubleVo.setCusttype(listVo.getCusttype());
                        hiddenTroubleVo.setChildtype(listVo.getChildtype());
                        hiddenTroubleVo.setShopptype(listVo.getShopptype());
                        hiddenTroubleVo.setTeamname(listVo.getTeamname());
                        hiddenTroubleVo.setUsername1(listVo.getUsername1());
                        hiddenTroubleVo.setUsername2(listVo.getUsername2());
                    }
                }
                result.add(hiddenTroubleVo);
            }
        }
        Map map = new HashMap();
        map.put("list", result);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }


    //查询所有信息

    @Override
    public RestResult selectAll(Map params) throws ParseException {
        Integer PersonnelID = Integer.valueOf((Integer) params.get("PersonnelID"));
        String keyword = String.valueOf(params.get("keyword"));
        String channel = String.valueOf(params.get("channel"));
        String frequency = String.valueOf(params.get("frequency"));
        String TScustomer = String.valueOf(params.get("TScustomer"));
        params.put("TScustomer",TScustomer);
        params.put("PersonnelID", PersonnelID);

        //格式化时间
        Calendar calendar = Calendar.getInstance();
        SimpleDateFormat sdf1 = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss.SSS'Z'");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
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
        if(channel == "null"){
            params.put("channel",-1);
        }
        if (frequency =="null"){
            params.put("frequency",-1);
        }
        String TeamName = String.valueOf(params.get("TeamName"));
        if (TeamName == "") {
            params.put("TeamName", null);
        }
        String results = String.valueOf(params.get("result"));
        if (results == "null") {
            params.put("result", -1);
        }else{
            params.put("result", results);
        }
        String grade = String.valueOf(params.get("grade"));
        if (grade == "") {
            params.put("grade", null);
        }
        params.put("keyword", keyword);
        //投诉数据
        List<ResponsibilityVo> list = responsibilityMapper.selectResponsiblityList(params);
        //隐患数据
        List<ResponsibilityVo> list1 = responsibilityMapper.selectHiddenTrouble(params);
        //退款数据
        List<ResponsibilityVo> list2 = responsibilityMapper.selectRefund(params);
        //存放投诉数据
        List<ResponsibilityVo> result = new ArrayList<ResponsibilityVo>();
        //循环拿数据
        for (ResponsibilityVo vo : list) {
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum", wangwangnum);
            ResponsibilityVo responsibilityVo = new ResponsibilityVo();
            ResponsibilityVo responsibilityVos = personnelService.selectResponsibilityList(params);
            //取出mysql数据库数据
            responsibilityVo.setBasic(vo.getBasic());
            responsibilityVo.setChannel(vo.getChannel());
            responsibilityVo.setComplaintId(vo.getComplaintId());
            responsibilityVo.setComplaintName(vo.getComplaintName());
            responsibilityVo.setReDate(vo.getCreateTime());
            responsibilityVo.setDeal(vo.getDeal());
            responsibilityVo.setGrade(vo.getGrade());
            responsibilityVo.setTime(vo.getComplaintdate());
            System.out.println("");
            responsibilityVo.setAspId(vo.getAspId());

            if (vo.getLevel() != null) {
                responsibilityVo.setLevel(vo.getLevel());
            }
            responsibilityVo.setSonLevel(vo.getSonLevel());
            responsibilityVo.setParentName(vo.getParentName());
            responsibilityVo.setParentId(vo.getParentId());
            responsibilityVo.setComplaintId(vo.getPkId());
            //责任人
            responsibilityVo.setResponsibilityer(vo.getResponsibilityer());
            //判责人员
            responsibilityVo.setResponsibilityor(vo.getResponsibilityor());
            responsibilityVo.setResult(vo.getResult());
            responsibilityVo.setSummary(vo.getSummary());
            responsibilityVo.setType(vo.getComplaintType());
            responsibilityVo.setWangwangnum(vo.getWangwangnum());
            if (responsibilityVos != null) {
                responsibilityVo.setPersonnelid(responsibilityVos.getPersonnelid());
                responsibilityVo.setPname(responsibilityVos.getPname());
                responsibilityVo.setPteamname(responsibilityVos.getPteamname());
                responsibilityVo.setTscustomer(responsibilityVos.getTscustomer());
                responsibilityVo.setTename(responsibilityVos.getTename());
                responsibilityVo.setTeamname(responsibilityVos.getTeamname());
                responsibilityVo.setShopptype(responsibilityVos.getShopptype());
                responsibilityVo.setServerdeadline(responsibilityVos.getServerdeadline());
                result.add(responsibilityVo);
            }
        }
        if (!list1.isEmpty()) {
            for (ResponsibilityVo listHidden : list1) {
                String wangwangnum = listHidden.getWangwangnum();
                params.put("wangwangnum", wangwangnum);
                List<SQLServerVo> sqlServerVos = personnelService.selectByDatebase(params);
                ResponsibilityVo responsibilityVo = new ResponsibilityVo();
                responsibilityVo.setWangwangnum(listHidden.getWangwangnum());
                responsibilityVo.setHiddenContent(listHidden.getHiddenContent());
                responsibilityVo.setReDate(listHidden.getCreateTime());
                responsibilityVo.setTime(listHidden.getHiddenDate());
                responsibilityVo.setResult(listHidden.getResult());
                responsibilityVo.setRemark(listHidden.getRemark());
                responsibilityVo.setFrequency(listHidden.getFrequency());
                responsibilityVo.setComplaintId(listHidden.getPkId());
                responsibilityVo.setAspId(listHidden.getAspId());
                if (listHidden.getLevel() != null) {
                    responsibilityVo.setLevel(listHidden.getLevel());
                }
                responsibilityVo.setSonLevel(listHidden.getSonLevel());
                responsibilityVo.setResponsibilityer(listHidden.getResponsibilityer());
                responsibilityVo.setResponsibilityor(listHidden.getResponsibilityor());
                responsibilityVo.setSummary(listHidden.getSummary());
                responsibilityVo.setBasic(listHidden.getBasic());
                responsibilityVo.setDeal(listHidden.getDeal());
                responsibilityVo.setComplaintId(listHidden.getComplaintId());
                responsibilityVo.setType(listHidden.getHiddenType());
                responsibilityVo.setComplaintName(listHidden.getComplaintName());
                responsibilityVo.setParentName(listHidden.getParentName());
                responsibilityVo.setExternalCause(listHidden.getExternalCause());
                responsibilityVo.setGrade(listHidden.getGrade());
                if (sqlServerVos.size() != 0) {
                    for (SQLServerVo sqlServerVo : sqlServerVos) {
                        responsibilityVo.setCusttype(sqlServerVo.getCusttype());
                        responsibilityVo.setChildtype(sqlServerVo.getChildtype());
                        responsibilityVo.setPname(sqlServerVo.getUsername2());
                        responsibilityVo.setTename(sqlServerVo.getUsername1());
                        responsibilityVo.setTeamname(sqlServerVo.getTeamname());
                        responsibilityVo.setShopptype(sqlServerVo.getShopptype());
                        responsibilityVo.setServerdeadline(sqlServerVo.getServerdeadline());

                    }
                    result.add(responsibilityVo);
                }

            }
        }
        if (!list2.isEmpty()){
            for (ResponsibilityVo listRefund : list2){
                String wangwangnum = listRefund.getWangwangnum();
                params.put("wangwangnum", wangwangnum);
                List<SQLServerVo> sqlServerVos = personnelService.selectByDatebase(params);
                ResponsibilityVo responsibilityVo = new ResponsibilityVo();
                    responsibilityVo.setWangwangnum(listRefund.getWangwangnum());
                    responsibilityVo.setRemark(listRefund.getRemark());
                    responsibilityVo.setRefundCause(listRefund.getRefundCause());
                    responsibilityVo.setRefundChannel(listRefund.getRefundChannel());
                    responsibilityVo.setReDate(listRefund.getCreateTime());
                    responsibilityVo.setRemark(listRefund.getRemark());
                    responsibilityVo.setRefundAmount(listRefund.getRefundAmount());
                    responsibilityVo.setComplaintId(listRefund.getPkId());
                    responsibilityVo.setTime(listRefund.getRefundDate());

                if (listRefund.getLevel() != null) {
                    responsibilityVo.setLevel(listRefund.getLevel());
                }
                responsibilityVo.setAspId(listRefund.getAspId());
                responsibilityVo.setResult(listRefund.getResult());
                responsibilityVo.setDeadline(listRefund.getDeadline());
                responsibilityVo.setSonLevel(listRefund.getSonLevel());
                responsibilityVo.setResponsibilityer(listRefund.getResponsibilityer());
                responsibilityVo.setResponsibilityor(listRefund.getResponsibilityor());
                responsibilityVo.setSummary(listRefund.getSummary());
                responsibilityVo.setBasic(listRefund.getBasic());
                responsibilityVo.setDeal(listRefund.getDeal());
                responsibilityVo.setComplaintId(listRefund.getComplaintId());
                responsibilityVo.setType(listRefund.getRefundType());
                responsibilityVo.setComplaintName(listRefund.getComplaintName());
                responsibilityVo.setParentName(listRefund.getParentName());
                responsibilityVo.setExternalCause(listRefund.getExternalCause());
                responsibilityVo.setGrade(listRefund.getGrade());
                if (sqlServerVos.size() != 0) {
                    for(SQLServerVo sqlServerVo : sqlServerVos) {
                        responsibilityVo.setCusttype(sqlServerVo.getCusttype());
                        responsibilityVo.setChildtype(sqlServerVo.getChildtype());
                        responsibilityVo.setPname(sqlServerVo.getUsername2());
                        responsibilityVo.setTename(sqlServerVo.getUsername1());
                        responsibilityVo.setTeamname(sqlServerVo.getTeamname());
                        responsibilityVo.setShopptype(sqlServerVo.getShopptype());
                        responsibilityVo.setDeadline(sqlServerVo.getDeadline());
                        responsibilityVo.setServerdeadline(sqlServerVo.getServerdeadline());
                    }
                    result.add(responsibilityVo);
                }
            }
        }
        Integer total1 = complaintMapper.selectComplaintCount(params);
        Integer total2 = hiddenTroubleMapper.total(params);
        Integer total3 = refundMapper.selectRefundCount(params);
        Integer total = total1 + total2 + total3;
        Map map = new HashMap();
        map.put("list", result);
        map.put("total", total);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }

    //修改客诉类别
    @Override
    public RestResult updataLevel(ComplaintLevel complaintLevel) {
        ComplaintLevel complaintLevel1 = complaintLevelMapper.selectByPrimaryKey(complaintLevel.getPkId());
        complaintLevel1.setParentId(complaintLevel.getParentId());
        complaintLevel1.setPkId(complaintLevel.getPkId());
        complaintLevel1.setExternalCause(complaintLevel.getExternalCause());
        complaintLevelMapper.updateByPrimaryKeySelective(complaintLevel1);
        return new RestResultBuilder<>().success("修改成功");
    }
}
