package com.mj.dao.repository;

import com.mj.dao.entity.Customer;
import com.mj.dao.vo.CustomerVo;

import java.util.List;
import java.util.Map;

public interface CustomerMapper {
    /**
     *
     * @mbg.generated 2019-07-18 14:51:00
     */
    int insert(Customer record);

    /**
     *
     * @mbg.generated 2019-07-18 14:51:00
     */
    int insertSelective(Customer record);

    //根据店铺名查询
    Customer selectByName(String wangwangnum);


    //根据旺旺名查
    List<CustomerVo> selectBywangwangnum(Map params);
}