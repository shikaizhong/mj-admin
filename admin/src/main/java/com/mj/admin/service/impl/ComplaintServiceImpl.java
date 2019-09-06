package com.mj.admin.service.impl;

import com.mj.admin.datasource.annotation.DataSource;
import com.mj.admin.jdbc.DBHelp;
import com.mj.admin.service.ComplaintService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.ApiConstant;
import com.mj.common.tools.DateUtil;
import com.mj.dao.entity.Complaint;
import com.mj.dao.entity.ComplaintLevel;
import com.mj.dao.entity.Files;
import com.mj.dao.repository.*;
import com.mj.dao.vo.ComplaintVo;
import com.mj.dao.vo.Complaints;
import org.apache.logging.log4j.util.Strings;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

@Service
//@Transactional
public class ComplaintServiceImpl implements ComplaintService {
    @Autowired
    private ComplaintMapper complaintMapper;
    @Autowired
    private CustomerMapper customerMapper;
    @Autowired
    private ComplaintLevelMapper complaintLevelMapper;
    @Autowired
    private HttpServletRequest httpServletRequest;
    @Autowired
    private PersonnelMapper personnelMapper;
    private java.lang.Object Object;
    @Autowired
    private FilesMapper  filesMapper;
    @Autowired
    private PersonnelServiceImpl personnelService;
    //分页搜索总记录数
    @DataSource(value = "druid")
    @Override
    public RestResult selectComplaint(Map params) throws Exception {
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        Integer pagesize = Integer.valueOf(String.valueOf(params.get("pagesize")));
        String keyword = String.valueOf(params.get("keyword"));
        String startTime = String.valueOf(params.get("startTime"));
        String endTime = String.valueOf(params.get("endTime"));
        Integer status = Integer.valueOf(String.valueOf(params.get("status")));
        Integer channels = Integer.valueOf(String.valueOf(params.get("channel")));
        String frequency = String.valueOf(params.get("frequency"));
        String TScustomer = String.valueOf(params.get("TScustomer"));
        System.out.println(TScustomer+"店长id为");
        Integer TechnologyRecruitmentID =Integer.valueOf(String.valueOf(params.get("TechnologyRecruitmentID")));
        Integer PersonnelID = Integer.valueOf(String.valueOf(params.get("PersonnelID")));
        Integer TeamID = Integer.valueOf(String.valueOf(params.get("TeamID")));
        String TeamName = String.valueOf(params.get("TeamName"));
        if (pagesize>=10){
            pagesize = 10;
        }if (pageNum == 1){
            pageNum = 0;
        }else {
            pageNum=(pageNum-1)*pagesize;
        }
        params.put("pageNum",pageNum);
        params.put("pageSize",pagesize);
        params.put("keyword",keyword);
        params.put("status",status);
        if (Strings.isEmpty(startTime)){
            params.put("startTime",startTime);
        }
        if (Strings.isEmpty(endTime)) {
            params.put("endTime", endTime);
        }
        if (channels !=-1){
        params.put("channels",channels);
        }
        if (frequency.isEmpty()) {
            params.put("frequencys", frequency);
        }
        if (Strings.isEmpty(TScustomer)){
//            Integer ts = Integer.parseInt(tscustomers);
            params.put("TScustomer",TScustomer);
        }
        if (Strings.isEmpty(TeamName)){
            params.put("TeamName",TeamName);
        }
        if (TeamID !=-1){
            params.put("TeamID",TeamID);
        }
        if (TechnologyRecruitmentID != -1){
            params.put("TechnologyRecruitmentID",TechnologyRecruitmentID);
        }
        if (PersonnelID !=-1 && PersonnelID != null){
            params.put("PersonnelID",PersonnelID);
        }
        //调用dao层
//        List<ComplaintVo> list = complaintMapper.selectComplaint(params);
        List<ComplaintVo> list = complaintMapper.selectComplaintList(params);
        System.out.println("最上面的循环长度是"+list.size());
        //List<ComplaintVo> complaintVos = personnelService.selectComplaintListOver(list.get(0).getWangwangnum());
        /*for(int i = 0 ; i < list.size() ; i++){
            String wangwangnum =list.get(i).getWangwangnum();
            System.out.println(wangwangnum+"旺旺名为");
                System.out.println("下来了");
                List<ComplaintVo> complaintVos = personnelService.selectComplaintListOver(wangwangnum);
                System.out.println(complaintVos.size()+"集合长度为");
                for (int z =0; z<complaintVos.size();z++){
                    ComplaintVo complaintVo = new ComplaintVo();
                    complaintVo.setWangwangnum(complaintVos.get(z).getWangwangnum());
                    complaintVo.setTechnologyrecruitmentid(complaintVos.get(z).getTechnologyrecruitmentid());
                    complaintVo.setShopptype(complaintVos.get(z).getShopptype());
                    complaintVo.setPersonnelid(complaintVos.get(z).getPersonnelid());
                    complaintVo.setTscustomer(complaintVos.get(z).getTscustomer());
                    complaintVo.setTeamid(complaintVos.get(z).getTeamid());
                    complaintVo.setTeamname(complaintVos.get(z).getTeamname());
                    complaintVo.setUsername(complaintVos.get(z).getUsername());
                    complaintVo.setPname(complaintVos.get(z).getPname());
                    complaintVo.setTename(complaintVos.get(z).getTename());
                    System.out.println(complaintVo.getTscustomer()+"店长id为");
                    list.add(complaintVo);
                }
        }*/
        List<ComplaintVo> result = new ArrayList<>();
        for (ComplaintVo vo:list){
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum",wangwangnum);

            ComplaintVo complaintVos = personnelService.selectComplaintListOver(params);
            ComplaintVo complaintVo = new ComplaintVo();
            complaintVo.setScenerestoration(vo.getScenerestoration());
            complaintVo.setStatus(vo.getStatus());
            complaintVo.setCreateTime(vo.getCreateTime());
            complaintVo.setId(vo.getId());
            complaintVo.setChannel(vo.getChannel());
            complaintVo.setComplaintdate(vo.getComplaintdate());
            complaintVo.setDepartment(vo.getDepartment());
            complaintVo.setWorktype(vo.getWorktype());
            complaintVo.setRemarks(vo.getRemarks());
            complaintVo.setPkId(vo.getPkId());
            complaintVo.setIsStop(vo.getIsStop());
            complaintVo.setIsDelete(vo.getIsDelete());
            complaintVo.setFrequency(vo.getFrequency());
            complaintVo.setContent(vo.getContent());
            complaintVo.setWangwangnum(vo.getWangwangnum());
            complaintVo.setNumber(vo.getNumber());
            complaintVo.setIndustry(vo.getIndustry());
            complaintVo.setFollowPersonel(vo.getFollowPersonel());
            complaintVo.setTurnover(vo.getTurnover());
            complaintVo.setProcessingScheme(vo.getProcessingScheme());
            complaintVo.setFollowProcess(vo.getFollowProcess());
            if (complaintVos !=null) {
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
        //总数量
        Integer total = complaintMapper.selectComplaintCount(params);
        Map map = new HashMap();
        map.put("list",result);
        map.put("total",total);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }
    //添加反馈
    @Transactional
    @DataSource(value = "druid")
    @Override
    public RestResult addComplaint(Complaint complaint) {
            //根据旺旺名来查询该客户反馈次数
            Integer frequency = complaintMapper.sumCustomerComplaint(complaint.getWangwangnum());
            //初始化
            Complaint complaint1 = new Complaint();
            System.out.println(frequency);
            complaint1.setChannel(complaint.getChannel());
            complaint1.setContent(complaint.getContent());
            //反馈次数自动加1
            complaint1.setFrequency(frequency + 1);
            complaint1.setRemarks(complaint.getRemarks());
            complaint1.setNumber(complaint.getNumber());
            complaint1.setTurnover(complaint.getTurnover());
            complaint1.setIndustry(complaint.getIndustry());
            complaint1.setFollowPersonel(complaint.getFollowPersonel());
            complaint1.setProcessingScheme(complaint.getProcessingScheme());
            complaint1.setFollowProcess(complaint.getFollowProcess());
            Files files = new Files();
            files.setComplaintId(complaint1.getPkId());
            complaint1.setComplaintdate(DateUtil.getAfter(complaint.getComplaintdate(), 1));
            System.out.println(complaint1.getComplaintdate() + "时间为");
//            complaint1.setScenerestoration(complaint.getScenerestoration());
            complaint1.setWangwangnum(complaint.getWangwangnum());
            complaint1.setStatus(0);
//        complaint1.setComplaintid(complaint.getComplaintid());
//        complaint1.setComplaintId(complaint.getComplaintId());
            //调用添加方法
            complaintMapper.insertSelective(complaint1);

            //统一返回信息
            return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(complaint1).build();
    }
    //修改反馈信息
    @Transactional
    @DataSource(value = "druid")
    @Override
    public RestResult updateComplaint(Complaint complaint) {
        //根据id查询
        Complaint complaint1 = complaintMapper.selectByPrimaryKey(complaint.getPkId());
//        System.out.println(complaint1+"地址为");
//        //取出地址的所有内容
//        String url = complaint1.getScenerestoration();
//        String removeUrl = complaint.getScenerestoration();
//        //去掉数组库中字符串的[
//        String ss = url.replace("[", "");
//        //去掉数组库中字符串的]
//        String sss = ss.replace("]", "");
//        System.out.println(sss);
//        //去掉传入字符串的[
////        String rr = removeUrl.replace("[", "");
////        //去掉传入字符串的]
////        String rrr = rr.replace("]", "");
////        System.out.println(rrr);
//        //数据库中的字符串去掉传入的字符串
//        String mm = sss.replace(removeUrl, "");
//        System.out.println(mm);
//        String zz = null;
//        //如果最前面有逗号则删除
//        if (mm.startsWith(",")) {
//            zz = mm.substring(1);
//            System.out.println(zz);
//        }
//        //如果最后面有逗号则删除
//        if (mm.endsWith(",")) {
//            System.out.println(zz.length());
//            zz = zz.substring(0, zz.length() - 1);
//            System.out.println(zz);
//        }
//        //用逗号分割去好的字符串
//        String[] strarr = zz.split(",");
//        //stringbuilder便于添加进去
//        StringBuilder stringBuilder = new StringBuilder();
//        //新建一个集合用于存储添加的数组使其和数据库数据保持一致
//        ArrayList arrayList2 = new ArrayList();
//        for (int z = 0; z < strarr.length; z++) {
//            //添加数据仅第一个数组
//            stringBuilder.append(strarr[z]);
//            ArrayList arrayList = new ArrayList();
//            arrayList.add(strarr[z]);
//            //将第一个数组封装到一个大数组中去
//            arrayList2.add(arrayList);
//        }
//        //数组转换成字符串
//        String urls = arrayList2.toString();
//        complaint1.setScenerestoration(urls);
        //初始化
//        complaint1.setComplaintid(complaint.getComplaintid());
//        complaint1.setComplaintId(complaint.getComplaintId());
//        System.out.println("ComplaintId为"+complaint1.getComplaintId());
        System.out.println("时间为"+complaint1.getComplaintdate());
        complaint1.setStatus(complaint.getStatus());
        complaint1.setWangwangnum(complaint.getWangwangnum());
        //文件上传时候修改
//        complaint1.setScenerestoration(complaint.getScenerestoration());
//        complaint1.setResult(complaint.getResult());
//        complaint1.setResponsibility(complaint.getResponsibility());
        complaint1.setRemarks(complaint.getRemarks());
//        complaint1.setLevel(complaint.getLevel());
        complaint1.setContent(complaint.getContent());
        complaint1.setChannel(complaint.getChannel());
        complaint1.setComplaintdate(DateUtil.getAfter(complaint.getComplaintdate(),1));
        System.out.println("到了");
        complaintMapper.updateByPrimaryKeySelective(complaint1);
        return new RestResultBuilder<>().success("修改成功");
    }
    //删除反馈信息
    @Transactional
    @Override
    public RestResult deleteComlaint(List<Integer> pkIds) {
        Integer [] pkId=new Integer[pkIds.size()];

        if(pkIds.size()>0){
            for(int i=0;i<pkIds.size();i++){
                pkId[i]=pkIds.get(i);
                System.out.println(pkId[i]);
            }
            //软删除
            complaintMapper.deleteBatch(pkId);
            return ResultUtils.success("删除成功");
        }
        return ResultUtils.error(1,"删除失败");
    }
    //根据旺旺号查询对应的历史记录
    @Override
    public RestResult selectInfoByWangWangNum(Map params) {
        String wangwangNum = String.valueOf(params.get("wangwangnum"));
        Map map = new HashMap();
        map.put("wangwangnum",wangwangNum);
        List<ComplaintVo> complaints = complaintMapper.selectInfoByWangWangNum(map);
        //新建一个集合来存储所有数据
        List<ComplaintVo> result = new ArrayList<>();
        for (ComplaintVo vo:complaints){
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum",wangwangnum);
            ComplaintVo complaintVos = personnelService.selectComplaintListOver(params);
            ComplaintVo complaintVo = new ComplaintVo();
            complaintVo.setScenerestoration(vo.getScenerestoration());
            complaintVo.setStatus(vo.getStatus());
            complaintVo.setCreateTime(vo.getCreateTime());
            complaintVo.setId(vo.getId());
            complaintVo.setChannel(vo.getChannel());
            complaintVo.setComplaintdate(vo.getComplaintdate());
            complaintVo.setDepartment(vo.getDepartment());
            complaintVo.setWorktype(vo.getWorktype());
            complaintVo.setRemarks(vo.getRemarks());
            complaintVo.setPkId(vo.getPkId());
            complaintVo.setIsStop(vo.getIsStop());
            complaintVo.setIsDelete(vo.getIsDelete());
            complaintVo.setFrequency(vo.getFrequency());
            complaintVo.setContent(vo.getContent());
            complaintVo.setWangwangnum(vo.getWangwangnum());
            if (complaintVos !=null) {
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
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(result ).build();
    }
    //根据complaintId查询历史记录
    @Override
    public RestResult selectFiles(Map params) {
        Integer complaintId = Integer.valueOf((Integer) params.get("complaintId"));
        Map map = new HashMap();
        map.put("complaintId",complaintId);
        List<Files> files = complaintMapper.selectFiles(map);
        return new RestResultBuilder().setCode(0).setMsg("查询成功").setData(files).build();
    }

    //查询大类客诉
    @Override
    public RestResult selectLevel() {
        List<Complaints> complaints = complaintMapper.selectLevel();
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(complaints).build();
    }
    //查询投诉大类对应的投诉小类

    @Override
    public RestResult getLevelName(Map params) {
        if(params.get("parentId") !=null){
            Integer level = Integer.valueOf(String.valueOf(params.get("parentId")));
            params.put("level",level);
            List<ComplaintLevel> complaintLevels =complaintLevelMapper.getLevelName(params);
            System.out.println(complaintLevels.size());
            Map result = new HashMap();
            result.put("list",complaintLevels);
            return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(result).build();
        }
        return new RestResultBuilder().setCode(-1).setMsg("大分类不存在").setData(null).build();
    }
    //上传文件
    @Override
    public RestResult upload(MultipartFile file) throws IOException {
            //获取文件名  场景还原文件名
            String fileName = file.getOriginalFilename();
            String fileNames = fileName;
            System.out.println("文件名为"+fileName);
            //获取文件的后缀名
            String suffixName = fileName.substring(fileName.lastIndexOf("."));
            System.out.println("后缀名为"+suffixName);
            //解决中文问题,linux下中文路径,图片显示问题
            fileName =UUID.randomUUID().toString().replace("-", "") + suffixName+"_"+fileName;
            //返回客户端文件路径图片显示问题
            //情景还原url
            //远程linux服务器的
        String url = "http://192.168.1.112:9090/mj-admin"+"/upload/"+fileName;
            //格式化掉.便于显示
//        String url ="/upload/"+fileName;
            //本地
//            String url ="localhost:8090"+"/upload/"+fileName;
//            Complaint complaintVo1 =  new Complaint();
            Files files = new Files();
            files.setUrl(url);
            files.setName(fileNames);
//            filesMapper.insertSelective(files);
            System.out.println("服务器返回的路径"+url);
            File dest = new File(ApiConstant.UPLOAD_PATH + fileName);//服务器的
//            File dest = new File(ApiConstant.DEV_UPLOAD_PATH+fileName);//本地的
            System.out.println("目录为"+dest);
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
        files1.setFileType(0);
        filesMapper.insertSelective(files1);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(files1).build();
    }

    //删除指定文件
    @Override
    public RestResult deleteFile(Integer pkId) {
        filesMapper.deleteByPrimaryKey(pkId);
        return new RestResultBuilder().setCode(0).success("删除成功");
    }
    //查看用户是否存在
    @Override
    public RestResult exist(Complaint complaint) {
        String wangwangnum = complaint.getWangwangnum();
        System.out.println(wangwangnum);
        Complaint complaint1 = new Complaint();
        String sql = "SELECT WangWangNum FROM Customer WHERE WangWangNum='"+ wangwangnum +"'";
        //得到连接
        Connection connection = null;
        Statement statement = null;
        ResultSet resultSet = null;
        try {
            connection = DBHelp.connection();
            statement =connection.createStatement();
            resultSet = statement.executeQuery(sql);
            if (resultSet.next()){
                complaint1.setWangwangnum(wangwangnum);
            }else {
                return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(),ResultCodeEnum.USER_NOT_FOUND.getMsg());
            }
        }catch (SQLException e){
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //关闭连接
            DBHelp.closeAll(connection,statement,resultSet);
        }

        return new RestResultBuilder().setCode(0).setMsg("查询成功").setData(complaint1).build();
    }
}
