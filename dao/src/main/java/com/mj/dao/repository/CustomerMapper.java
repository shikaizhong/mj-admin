package com.mj.dao.repository;

import com.mj.dao.entity.Customer;

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
}