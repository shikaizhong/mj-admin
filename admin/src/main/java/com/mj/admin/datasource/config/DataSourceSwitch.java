package com.mj.admin.datasource.config;

import com.mj.admin.datasource.annotation.DataSource;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.Map;

public class DataSourceSwitch {
    @DataSource(value = "slave1")
    public static void change(String data)throws Exception{
        Method method = DataSourceSwitch.class.getMethod("change", String.class);
        DataSource dataSource = method.getAnnotation(DataSource.class);
        if (dataSource ==null){
            throw new RuntimeException("请添加数据源");
        }
        InvocationHandler invocationHandler = Proxy.getInvocationHandler(dataSource);
        Field value = invocationHandler.getClass().getDeclaredField("memberValues");
        value.setAccessible(true);
        Map<String,Object> memberValues = (Map<String, Object>) value.get(invocationHandler);
        String val = (String) memberValues.get("value");
        System.out.println("改变前"+val);
        val = data;
        memberValues.put("value",val);
        System.out.println("改变后"+dataSource);
    }
}
