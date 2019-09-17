package com.mj.dao.pojo;

public class User {
    //主键id
    private Integer pkId;
    //密码
    private String password;
    //散列机密后的账户
    private String ukAccount;
    //token
    private String token;
    //盐值
    private String salt;
    //用户名
    private String userName;

    public String getUserName() {
        return userName;
    }

    public void setUserName(String userName) {
        this.userName = userName;
    }

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getSalt() {
        return salt;
    }

    public void setSalt(String salt) {
        this.salt = salt;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getUkAccount() {
        return ukAccount;
    }

    public void setUkAccount(String ukAccount) {
        this.ukAccount = ukAccount;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
