package com.mj.dao.pojo;

import java.math.BigDecimal;
import java.util.Date;

public class UserInfoTable {
    private String phone;

    /**
     * 所在城市ID city_id
     */
    private Integer cityId;

    /**
     * 所在学校ID school_id
     */
    private Integer schoolId;

    /**
     * 类型 0：游客  1：学生 2：家长 Type
     */
    private Integer type;

    /**
     * 余额 balance
     */
    private BigDecimal balance;

    /**
     * 头像 avatar
     */
    private String avatar;

    /**
     * 昵称 nickname
     */
    private String nickname;

    /**
     * 真实姓名 realname
     */
    private String realname;

    /**
     * 性别 1：男 2：女 sex
     */
    private Integer sex;

    /**
     * 个人介绍 introduce
     */
    private String introduce;

    /**
     * 身份证号码 idcard
     */
    private String idcard;

    /**
     * 是否实名认证 is_real
     */
    private Integer isReal;

    /**
     * 认证种类 0：普通用户 1：研学导师 2：家教导师 3：家长认证 4：研学/家教 credit_kind
     */
    private Integer creditKind;

    /**
     * 是否学生认证 默认否  0：否 1：是 is_student
     */
    private Integer isStudent;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * 账户
     * @author Dennis
     * @return phone 账户
     */
    private  Integer isDelete;

    private  String major;

    private  Integer age;

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public Integer getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(Integer schoolId) {
        this.schoolId = schoolId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    public String getNickname() {
        return nickname;
    }

    public void setNickname(String nickname) {
        this.nickname = nickname;
    }

    public String getRealname() {
        return realname;
    }

    public void setRealname(String realname) {
        this.realname = realname;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public String getIdcard() {
        return idcard;
    }

    public void setIdcard(String idcard) {
        this.idcard = idcard;
    }

    public Integer getIsReal() {
        return isReal;
    }

    public void setIsReal(Integer isReal) {
        this.isReal = isReal;
    }

    public Integer getCreditKind() {
        return creditKind;
    }

    public void setCreditKind(Integer creditKind) {
        this.creditKind = creditKind;
    }

    public Integer getIsStudent() {
        return isStudent;
    }

    public void setIsStudent(Integer isStudent) {
        this.isStudent = isStudent;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getMajor() {
        return major;
    }

    public void setMajor(String major) {
        this.major = major;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }
}
