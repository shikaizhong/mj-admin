package com.mj.dao.entity;

import java.util.Date;

public class Admin {
    /**
     * 管理员ID、主键 pk_id
     */
    private Integer pkId;

    /**
     * 登录账户 uk_account
     */
    private String ukAccount;

    /**
     * 密码 password
     */
    private String password;

    /**
     * account+salt 散列加密后的值 authenticator
     */
    private String authenticator;

    /**
     * 盐值 salt
     */
    private String salt;

    /**
     * 管理员名称 nickname
     */
    private String nickname;

    /**
     * 手机号 phone
     */
    private String phone;

    /**
     * 邮箱 email
     */
    private String email;

    /**
     * 头像 avatar
     */
    private String avatar;

    /**
     * 地址  预留字段 address
     */
    private String address;

    /**
     * 是否启用：0: 已启用   1：已禁用 status
     */
    private Integer status;

    /**
     * 是否删除：0: 未删除   1：已删除 delete_flag
     */
    private Integer deleteFlag;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    /**
     * 最后修改时间 update_time
     */
    private Date updateTime;

    /**
     * 排序时间 sort_time
     */
    private Date sortTime;

    /**
     * 管理员ID、主键
     * @author Dennis
     * @return pk_id 管理员ID、主键
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 管理员ID、主键
     * @author Dennis
     * @param pkId 管理员ID、主键
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 登录账户
     * @author Dennis
     * @return uk_account 登录账户
     */
    public String getUkAccount() {
        return ukAccount;
    }

    /**
     * 登录账户
     * @author Dennis
     * @param ukAccount 登录账户
     */
    public void setUkAccount(String ukAccount) {
        this.ukAccount = ukAccount == null ? null : ukAccount.trim();
    }

    /**
     * 密码
     * @author Dennis
     * @return password 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @author Dennis
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password == null ? null : password.trim();
    }

    /**
     * account+salt 散列加密后的值
     * @author Dennis
     * @return authenticator account+salt 散列加密后的值
     */
    public String getAuthenticator() {
        return authenticator;
    }

    /**
     * account+salt 散列加密后的值
     * @author Dennis
     * @param authenticator account+salt 散列加密后的值
     */
    public void setAuthenticator(String authenticator) {
        this.authenticator = authenticator == null ? null : authenticator.trim();
    }

    /**
     * 盐值
     * @author Dennis
     * @return salt 盐值
     */
    public String getSalt() {
        return salt;
    }

    /**
     * 盐值
     * @author Dennis
     * @param salt 盐值
     */
    public void setSalt(String salt) {
        this.salt = salt == null ? null : salt.trim();
    }

    /**
     * 管理员名称
     * @author Dennis
     * @return nickname 管理员名称
     */
    public String getNickname() {
        return nickname;
    }

    /**
     * 管理员名称
     * @author Dennis
     * @param nickname 管理员名称
     */
    public void setNickname(String nickname) {
        this.nickname = nickname == null ? null : nickname.trim();
    }

    /**
     * 手机号
     * @author Dennis
     * @return phone 手机号
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号
     * @author Dennis
     * @param phone 手机号
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 邮箱
     * @author Dennis
     * @return email 邮箱
     */
    public String getEmail() {
        return email;
    }

    /**
     * 邮箱
     * @author Dennis
     * @param email 邮箱
     */
    public void setEmail(String email) {
        this.email = email == null ? null : email.trim();
    }

    /**
     * 头像
     * @author Dennis
     * @return avatar 头像
     */
    public String getAvatar() {
        return avatar;
    }

    /**
     * 头像
     * @author Dennis
     * @param avatar 头像
     */
    public void setAvatar(String avatar) {
        this.avatar = avatar == null ? null : avatar.trim();
    }

    /**
     * 地址  预留字段
     * @author Dennis
     * @return address 地址  预留字段
     */
    public String getAddress() {
        return address;
    }

    /**
     * 地址  预留字段
     * @author Dennis
     * @param address 地址  预留字段
     */
    public void setAddress(String address) {
        this.address = address == null ? null : address.trim();
    }

    /**
     * 是否启用：0: 已启用   1：已禁用
     * @author Dennis
     * @return status 是否启用：0: 已启用   1：已禁用
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 是否启用：0: 已启用   1：已禁用
     * @author Dennis
     * @param status 是否启用：0: 已启用   1：已禁用
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 是否删除：0: 未删除   1：已删除
     * @author Dennis
     * @return delete_flag 是否删除：0: 未删除   1：已删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 是否删除：0: 未删除   1：已删除
     * @author Dennis
     * @param deleteFlag 是否删除：0: 未删除   1：已删除
     */
    public void setDeleteFlag(Integer deleteFlag) {
        this.deleteFlag = deleteFlag;
    }

    /**
     * 创建时间
     * @author Dennis
     * @return create_time 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @author Dennis
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 最后修改时间
     * @author Dennis
     * @return update_time 最后修改时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 最后修改时间
     * @author Dennis
     * @param updateTime 最后修改时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 排序时间
     * @author Dennis
     * @return sort_time 排序时间
     */
    public Date getSortTime() {
        return sortTime;
    }

    /**
     * 排序时间
     * @author Dennis
     * @param sortTime 排序时间
     */
    public void setSortTime(Date sortTime) {
        this.sortTime = sortTime;
    }

    /**
     *
     * @mbg.generated 2018-12-26 11:42:56
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", ukAccount=").append(ukAccount);
        sb.append(", password=").append(password);
        sb.append(", authenticator=").append(authenticator);
        sb.append(", salt=").append(salt);
        sb.append(", nickname=").append(nickname);
        sb.append(", phone=").append(phone);
        sb.append(", email=").append(email);
        sb.append(", avatar=").append(avatar);
        sb.append(", address=").append(address);
        sb.append(", status=").append(status);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", sortTime=").append(sortTime);
        sb.append("]");
        return sb.toString();
    }
}