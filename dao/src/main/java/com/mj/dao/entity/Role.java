package com.mj.dao.entity;

import java.util.Date;

public class Role {
    /**
     * 角色ID、主键 pk_id
     */
    private Integer pkId;

    /**
     * 角色名称  唯一 uk_name
     */
    private String ukName;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 是否删除：0：未删除  1：已删除 delete_flag
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

    //城市id
    private Integer cityId;

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    /**
     * 角色ID、主键
     * @author Dennis
     * @return pk_id 角色ID、主键
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 角色ID、主键
     * @author Dennis
     * @param pkId 角色ID、主键
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 角色名称  唯一
     * @author Dennis
     * @return uk_name 角色名称  唯一
     */
    public String getUkName() {
        return ukName;
    }

    /**
     * 角色名称  唯一
     * @author Dennis
     * @param ukName 角色名称  唯一
     */
    public void setUkName(String ukName) {
        this.ukName = ukName == null ? null : ukName.trim();
    }

    /**
     * 备注
     * @author Dennis
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @author Dennis
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 是否删除：0：未删除  1：已删除
     * @author Dennis
     * @return delete_flag 是否删除：0：未删除  1：已删除
     */
    public Integer getDeleteFlag() {
        return deleteFlag;
    }

    /**
     * 是否删除：0：未删除  1：已删除
     * @author Dennis
     * @param deleteFlag 是否删除：0：未删除  1：已删除
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
        sb.append(", ukName=").append(ukName);
        sb.append(", remark=").append(remark);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}