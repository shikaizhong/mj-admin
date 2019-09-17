package com.mj.admin.service;

import com.mj.admin.constants.AdminConstant;
import com.mj.common.enums.ResultCodeEnum;
import com.mj.common.result.ResultUtils;
import com.mj.common.tools.EncryptUtils;
import com.mj.common.tools.JWTUtils;
import com.mj.dao.pojo.User;

import java.util.HashMap;
import java.util.Map;

public class CreateSalt {
    public static void main(String[] args) {
        User user = new User();
        // 生成盐值 加密密码 并持久化管理员信息
        String salt = EncryptUtils.createSalt();
        String userName = "admin";
        String newPass = EncryptUtils.encrypt("123", salt);
        String authenticator = EncryptUtils.encrypt("admin", salt);
        System.out.println(salt+"盐值为");
        System.out.println(newPass+"密码为");
        System.out.println(authenticator+"账户为");
        user.setPkId(1);
        user.setPassword(newPass);
        user.setSalt(salt);
        user.setUkAccount(authenticator);
        user.setUserName(userName);
        // 生成 token
        Map domain = new HashMap();
        domain.put(AdminConstant.PKID, user.getPkId());
        domain.put(AdminConstant.ACCOUNT, user.getUkAccount());
        domain.put("time", System.currentTimeMillis());
        String token = JWTUtils.generateToken(AdminConstant.JWT_SALT, domain);
        user.setToken(token);
        // 验证密码
        String password ="c66ae95e31e18e3cdc208e6630b80699f093202ac0063857441708e80601054a8d1d17876d3e3602e4af90bc7ff6b45565fd25e3e63a446ac0cb230a03ad039e";
        //账户
        String username = user.getUkAccount();
        if (!user.getUserName().equals(EncryptUtils.encrypt(userName,user.getUkAccount()))){
            System.out.println("您的用户名为空哦!"+ResultUtils.error(ResultCodeEnum.USER_NOT_FOUND.getCode(),ResultCodeEnum.USER_NOT_FOUND.getMsg()));
        }else if (!username.equals(user.getUkAccount())){
            System.out.println("您的用户名不对哦!"+ResultUtils.error(ResultCodeEnum.DEVICE_NOT_FOUND.getCode(),ResultCodeEnum.DEVICE_NOT_FOUND.getMsg()));
        }else {
            if (!user.getPassword().equals(EncryptUtils.encrypt(password,user.getSalt()))){
                System.out.println("密码不对哦"+ResultUtils.error(ResultCodeEnum.USER_PASSWORD_NOT_MATCH.getCode(),ResultCodeEnum.USER_PASSWORD_NOT_MATCH.getMsg()));
            }else {
                System.out.println("密码匹配成功了"+ResultUtils.success(ResultCodeEnum.SUCCESS));
                //调用登录接口

            }
        }


    }
}
