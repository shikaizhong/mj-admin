package com.mj.admin.service.impl;


import com.mj.admin.service.LoseService;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.common.result.ResultUtils;
import com.mj.dao.annotate.DataSource;
import com.mj.dao.entity.Lose;
import com.mj.dao.repository.LoseMapper;
import com.mj.dao.vo.LoseVo;
import com.mj.dao.vo.SQLServerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.*;

/**
 * @麦佳甘豆 流失管理的service层的实现类
 */
@Service
public class LoseServiceImpl implements LoseService {

    @Autowired
    private LoseMapper loseMapper;

    @Autowired
    private PersonnelServiceImpl personnelServiceImpl;

    @Autowired
    private CustomerServiceImpl customerServiceImpl;

    @DataSource(value = "druid")
    @Override
    public RestResult selectLose(Map params) throws Exception {
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        SimpleDateFormat sdf2 = new SimpleDateFormat("yyyy-MM-dd");
        //页面所展示的数据条数
        Integer pageSize = Integer.valueOf(String.valueOf(params.get("pageSize")));
        //数据第几页
        Integer pageNum = Integer.valueOf(String.valueOf(params.get("pageNum")));
        //根据旺旺名查询
        String wangWangNum = String.valueOf(params.get("wangWangNum"));
        //根据店长查询
        String username1 = String.valueOf(params.get("username1"));
        //根据招商顾问查询
        String username2 = String.valueOf(params.get("username2"));
        //根据团队查询
        String teamname = String.valueOf(params.get("teamname"));
        //根据店铺类型查询
        String shopptype = String.valueOf(params.get("shopptype"));
        //判断旺旺名是否存在
        if (wangWangNum != null) {
            params.put("wangWangNum", wangWangNum);
        }
        //判断页数
        if (pageNum == 1) {
            pageNum = 0;
        } else {
            pageNum = (pageNum - 1) * pageSize;
        }
        //判断查询的开始时间是否存在，若不存在则将 2000-1-1 00:00:00设置为默认时间
        if (String.valueOf(params.get("startTime")).isEmpty()) {
            Date startTime = sdf.parse("2000-01-01 00:00:00");
            params.put("startTime", startTime);
        } else {
            Date startTime = sdf.parse(String.valueOf(params.get("startTime")));
            params.put("startTime", startTime);
        }
        //判断查询的结束时间是否存在，若不存在则将 2099-12-31 23:59:59设置为默认时间
        if (String.valueOf(params.get("endTime")).isEmpty()) {
            Date endTime = sdf.parse("2099-12-31 23:59:59");
            params.put("endTime", endTime);
        } else {
            Date endTime = sdf.parse(String.valueOf(params.get("endTime")));
            params.put("endTime", endTime);
        }
        //将pageSize和pageNum封装到map集合中
        params.put("pageSize", pageSize);
        params.put("pageNum", pageNum);
        //将查询的值封装在map集合中，根据map并调用loseMapper的方法，将结果集封装到list集合中
//        System.out.println("11111111111111:"+params);
        List<Lose> lose = loseMapper.selectLose(params);
//        System.out.println("22222222222222:"+lose.size());
        //将LoseVo的对象封装到该集合中
        List<LoseVo> result = new ArrayList();
        //加强for循环，循环遍历Lose中的值
        for (Lose loseList : lose) {
            //新建LoseVo对象，从MySQL和根据从sqlserver中MySQL表中的旺旺名查询的值一起存到该对象中
            LoseVo loseVo = new LoseVo();
            loseVo.setWangWangNum(loseList.getWangWangNum());
            loseVo.setRevisitDate(loseList.getRevisitDate());
            System.out.println("改进意见：" + loseList.getImprovement());
            loseVo.setImprovement(loseList.getImprovement());
            loseVo.setIsDelete(loseList.getIsDelete());
            loseVo.setStatus(loseList.getStatus());
            loseVo.setSatisfaction(loseList.getSatisfaction());
            loseVo.setRemark(loseList.getRemark());
            loseVo.setPkId(loseList.getPkId());
            loseVo.setLevel(loseList.getLevel());
            String wangwangnum = loseList.getWangWangNum();
            //新建一个map集合，将sqlserver表中查询的条件封装进去
            Map map = new HashMap();
//            System.out.println("lose旺旺名为："+ wangwangnum);
            map.put("wangwangnum", wangwangnum);
            map.put("username1", username1);
            map.put("username2", username2);
            map.put("teamname", teamname);
            map.put("shopptype", shopptype);
//            System.out.println("map集合为："+map);
            //根据map集合，调用personnelServiceImpl中的方法，通过sqlserver查询
            List<SQLServerVo> sqlServerVo = personnelServiceImpl.selectByDatebase(map);
            if (!sqlServerVo.isEmpty()) {
                for (SQLServerVo sqlList : sqlServerVo) {
                    loseVo.setUsername1(sqlList.getUsername1());
                    loseVo.setUsername2(sqlList.getUsername2());
//                    System.out.println("合同结束日期为：" + sqlList.getServerdeadlineend());
                    if (!sqlList.getServerdeadlineend().isEmpty()) {
                        String df = sqlList.getServerdeadlineend();
                        int index = df.indexOf(" ");
//                        System.out.println("空格第一次在：" + index + "出现");
                        if (index > 0) {
                            df = df.substring(0, index);
//                            System.out.println("修改过的字符串为：" + df);
                        }
                        df = df.replace('.', '-');
//                        System.out.println("将'.'号改为'-'后的字符串为：" + df);
                        df = df.replace('/', '-');
//                        System.out.println("将'/'改为'-'后的字符串为：" + df);
                        Date date = sdf2.parse(df);
//                        System.out.println("最后修改的时间格式为："+date);
                        loseVo.setLoseDate(date);
                    }
                    loseVo.setShopptype(sqlList.getShopptype());
                    loseVo.setTeamname(sqlList.getTeamname());
                    loseVo.setChildtype(sqlList.getChildtype());
                    loseVo.setCusttype(sqlList.getCusttype());
                }
                result.add(loseVo);
            }
        }
        Integer total = loseMapper.countLose();
        Map map1 = new HashMap();
        map1.put("list", result);
        map1.put("total", total);
        return new RestResultBuilder().setCode(0).setData(map1).build();
    }

    //添加
    @DataSource(value = "druid")
    @Override
    public RestResult addLose(Lose lose) {
//        System.out.println("进入loseServiceImpl");
        Lose lose1 = new Lose();
        Map map = new HashMap();
        String wangwangnum = lose.getWangWangNum();
        map.put("wangwangnum", wangwangnum);
        if ((customerServiceImpl.selectByWangWangNum(map)).size() == 0) {
            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(), ResultCodeEnum.USER_NOT_FOUND.getMsg());
        } else {
            lose1.setImprovement(lose.getImprovement());
            lose1.setWangWangNum(lose.getWangWangNum());
            lose1.setIsDelete(lose.getIsDelete());
            lose1.setStatus(lose.getStatus());
            lose1.setSatisfaction(lose.getSatisfaction());
            if (lose.getRevisitDate().toString().isEmpty()) {
                Date date = new Date();
                lose1.setRevisitDate(date);
            } else {
                lose1.setRevisitDate(lose.getRevisitDate());
            }
            lose1.setLevel(lose.getLevel());
        }
        System.out.println("lose值为"+lose.getRevisitDate());
        loseMapper.insertSelective(lose1);
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(lose1).build();
    }

    //修改
    @Override
    public RestResult updateLose(Lose lose) {
        Lose lose1 = new Lose();
        lose1.setRevisitDate(lose.getRevisitDate());
        lose1.setSatisfaction(lose.getSatisfaction());
        lose1.setRemark(lose.getRemark());
        lose1.setImprovement(lose.getImprovement());
        loseMapper.updateByPrimaryKeySelective(lose1);
        return new RestResultBuilder().success("请求成功");
    }

    //删除
    @Override
    public RestResult deleteLose(List<Integer> pkIds){
        return null;
    }
}
