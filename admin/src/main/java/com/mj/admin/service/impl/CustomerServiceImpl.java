package com.mj.admin.service.impl;

import com.mj.admin.datasource.annotation.DataSource;
import com.mj.admin.service.CustomerService;
import com.mj.dao.repository.CustomerMapper;
import com.mj.dao.vo.CustomerVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Map;

@Service
@Transactional
public class CustomerServiceImpl implements CustomerService {
    @Autowired
    private CustomerMapper customerMapper;

    @DataSource(value = "slave1")
    @Override
    public List selectByWangWangNum(Map params){
        String wangwangnum = String.valueOf(params.get("wangwangnum"));
//        System.out.println("旺旺名为："+wangwangnum);
        params.put("wangwangnum",wangwangnum);
//        System.out.println("params集合值为："+params);
        List<CustomerVo> customer = customerMapper.selectBywangwangnum(params);
//        System.out.println("获取的值为："+customer.size());
//        if(customer.isEmpty()){
//            return ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(), ResultCodeEnum.USER_NOT_FOUND.getMsg());
//        } else {
//            return ResultUtils.error(ResultCodeEnum.ACCOUNT_EXIST.getCode(), ResultCodeEnum.ACCOUNT_EXIST.getMsg());
//        }
        return  customer;
    }
}
