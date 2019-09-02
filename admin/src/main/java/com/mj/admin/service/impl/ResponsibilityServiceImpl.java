package com.mj.admin.service.impl;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.mj.admin.service.ResponsibilityService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.tools.PageUtils;
import com.mj.dao.entity.Files;
import com.mj.dao.entity.Responsibility;
import com.mj.dao.entity.ResponsibilityWithBLOBs;
import com.mj.dao.repository.ComplaintMapper;
import com.mj.dao.repository.FilesMapper;
import com.mj.dao.repository.ResponsibilityMapper;
import com.mj.dao.vo.ComplaintVo;
import com.mj.dao.vo.PageRequest;
import com.mj.dao.vo.PageResult;
import com.mj.dao.vo.ResponsibilityVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

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
    //查询搜索
    @Override
    public RestResult selectResponsiblity(Map params) throws Exception {
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        if (pageSize>=10){
            pageSize = 10;
        }if (pageNum == 1){
            pageNum = 0;
        }else {
            pageNum=(pageNum-1)*pageSize;
        }
        params.put("pageNum",pageNum);
        params.put("pageSize",pageSize);

        List<ResponsibilityVo> list = responsibilityMapper.selectResponsiblity(params);
        List<ResponsibilityVo> result = new ArrayList<ResponsibilityVo>();
        //循环拿数据
        for(ResponsibilityVo vo:list){
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum",wangwangnum);
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
            if (vo.getLevel() != null){
                responsibilityVo.setLevel(vo.getLevel());
            }
            responsibilityVo.setSonLevel(vo.getSonLevel());
            responsibilityVo.setParentName(vo.getParentName());
            responsibilityVo.setParentId(vo.getParentId());
            responsibilityVo.setPkId(vo.getPkId());
            //责任人
            responsibilityVo.setResponsibilityer(vo.getResponsibilityer());
            //判责人员
            responsibilityVo.setResponsibilityor(vo.getResponsibilityor());
            responsibilityVo.setResult(vo.getResult());
            responsibilityVo.setSummary(vo.getSummary());
            responsibilityVo.setType(vo.getType());
            responsibilityVo.setWangwangnum(vo.getWangwangnum());
            if (responsibilityVos != null){
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
        Integer type = Integer.valueOf((Integer) params.get("type"));
        Integer total = 0;
        if (type == 0){
            total = responsibilityMapper.selectComplaintCount(params);
        }
        Map map = new HashMap();
        map.put("list",result);
        map.put("total",total);
        return  new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }
    //使用分页插件分页
    @Override
    public PageResult pageHelper(PageRequest pageRequest) throws Exception {
        return PageUtils.getPageResult(pageRequest,getPageInfo(pageRequest));
    }
    private PageInfo<Responsibility> getPageInfo(PageRequest pageRequest) throws Exception {
        int pageNum = pageRequest.getPageNum();
        int pageSize = pageRequest.getPageSize();
        PageHelper.startPage(pageNum, pageSize);
        List<Responsibility> responsibilities = responsibilityMapper.page();
        for(Responsibility p:responsibilities){
            System.out.println(p.getType());
            System.out.println("进来哦弟弟");
        }
        return new PageInfo<Responsibility>(responsibilities);
    }
    @Transactional
    @Override
    //修改判责信息
    public RestResult updataResponsiblity(ResponsibilityWithBLOBs responsibilityWithBLOBs) {
        ResponsibilityWithBLOBs responsibilityWithBLOBs1 = responsibilityMapper.selectByComplaintId(responsibilityWithBLOBs.getComplaintId());
        //如果实体里面有数据则是修改
        if (responsibilityWithBLOBs1 !=null){
            responsibilityWithBLOBs1.setBasic(responsibilityWithBLOBs.getBasic());
            responsibilityWithBLOBs1.setDeal(responsibilityWithBLOBs.getDeal());
            responsibilityWithBLOBs1.setSummary(responsibilityWithBLOBs.getSummary());
            responsibilityWithBLOBs1.setLevel(responsibilityWithBLOBs.getLevel());
            responsibilityWithBLOBs1.setSonLevel(responsibilityWithBLOBs.getSonLevel());
            responsibilityWithBLOBs1.setResult(responsibilityWithBLOBs.getResult());
            responsibilityWithBLOBs1.setResponsibilityer(responsibilityWithBLOBs.getResponsibilityer());
            responsibilityWithBLOBs1.setResponsibilityor(responsibilityWithBLOBs.getResponsibilityor());
            responsibilityWithBLOBs1.setGrade(responsibilityWithBLOBs.getGrade());
            responsibilityMapper.updateByPrimaryKeySelective(responsibilityWithBLOBs1);
        }
        //如果实体里面没有数据则是增加
        if (responsibilityWithBLOBs1 ==null){
            System.out.println("进来这里喽弟弟!");
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
            responsibilityWithBLOBs2.setCreateTime(new Date());
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

    //根据id查询
    @Override
    public RestResult selectById(Map params) {
        List<ComplaintVo> list = complaintMapper.selectById(params);
        List<ComplaintVo> result = new ArrayList<>();
        for (ComplaintVo vo:list){
            String wangwangnum = vo.getWangwangnum();
            params.put("wangwangnum",wangwangnum);
            ComplaintVo complaintVos = personnelService.selectByPkId(params);
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
        Map map = new HashMap();
        map.put("list",result);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(map).build();
    }
}
