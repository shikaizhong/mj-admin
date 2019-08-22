package com.mj.dao.entity;

import java.util.Date;

public class AdminRole {
    /**
     * 关键主键ID pk_id
     */
    private Integer pkId;

    /**
     * 管理员ID amdin_id
     */
    private Integer amdinId;

    /**
     * 角色ID role_id
     */
    private Integer roleId;

    /**
     *   是否删除：0 ：未删除   1：已删除 delete_flag
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
     * 关键主键ID
     * @author Dennis
     * @return pk_id 关键主键ID
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 关键主键ID
     * @author Dennis
     * @param pkId 关键主键ID
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 管理员ID
     * @author Dennis
     * @return amdin_id 管理员ID
     */
    public Integer getAmdinId() {
        return amdinId;
    }

    /**
     * 管理员ID
     * @author Dennis
     * @param amdinId 管理员ID
     */
    public void setAmdinId(Integer amdinId) {
        this.amdinId = amdinId;
    }

    /**
     * 角色ID
     * @author Dennis
     * @return role_id 角色ID
     */
    public Integer getRoleId() {
        return roleId;
    }

    /**
     * 角色ID
     * @author Dennis
     * @param roleId 角色ID
     */
    public void setRoleId(Integer roleId) {
        this.roleId = roleId;
    }

    /**
     *   是否删除：0 ：未删除   1：已删除
     * @author Dennis
     * @return delete_flag   是否删除：0 ：未删除   1：已删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     *   是否删除：0 ：未删除   1：已删除
     * @author Dennis
     * @param deleteFlag   是否删除：0 ：未删除   1：已删除
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
        sb.append(", amdinId=").append(amdinId);
        sb.append(", roleId=").append(roleId);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}