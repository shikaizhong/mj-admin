/*
package com.mj.admin.service;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RunWith(SpringRunner.class)
@SpringBootTest
public class AdminServiceTest {

    @Autowired
    private AdvertisementMapper mapper;
    @Test
    public void test(){
        Map params = new HashMap();
        params.put("pageNum", 2);
        params.put("pageSize",2);
        params.put("keyWord","190");
        List<Advertisement> list = mapper.selectAdPage(params);
        System.out.println(params);
        System.out.println(list);
        System.out.println(list.size());
    }
}*/
