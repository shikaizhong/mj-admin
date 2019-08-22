package com.mj.admin.service.impl;

import com.mj.admin.datasource.annotation.DataSource;
import com.mj.admin.service.UserService;
import com.mj.common.result.RestResult;
import com.mj.common.result.RestResultBuilder;
import com.mj.dao.entity.Personnel;
import com.mj.dao.entity.User;
import com.mj.dao.repository.PersonnelsMapper;
import com.mj.dao.repository.UserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {
@Autowired
private UserMapper userMapper;
@Autowired
private PersonnelsMapper personnelMapper;
    @Override
    public RestResult selectUser() {
        List<User> users =userMapper.selectUser();
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(users).build();
    }

    @Override
    @DataSource(value = "slave1")
    public RestResult selectUsers() {
        List<Personnel> users = personnelMapper.selectAlls();//
        return new RestResultBuilder().setCode(0).setMsg("请求成功").setData(users).build();
    }
}
