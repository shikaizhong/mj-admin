package com.mj.admin.service;

import com.mj.common.result.RestResult;

public interface UserService {

    /*所有用户*/
    RestResult selectUser();
    //sqlserve数据库数据
    RestResult selectUsers();
}
