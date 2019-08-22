package com.mj.dao.entity;

import java.util.Date;

public class Resource {
    /**
     * 资源ID、主键 pk_id
     */
    private Integer pkId;

    /**
     * 父级资源ID，一级资源 父级ID 为 0 parent_id
     */
    private Integer parentId;

    /**
     * 资源名称、 唯一 uk_name
     */
    private String ukName;

    /**
     * 路由路径 path
     */
    private String path;

    /**
     * 授权 例如：sys:user:save, 中间；隔开 perms
     */
    private String perms;

    /**
     * 类型   0：目录   1：菜单   2：按钮 Type
     */
    private Integer type;

    /**
     * 排序 order_num
     */
    private Integer orderNum;

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
     * 资源ID、主键
     * @author Dennis
     * @return pk_id 资源ID、主键
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 资源ID、主键
     * @author Dennis
     * @param pkId 资源ID、主键
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 父级资源ID，一级资源 父级ID 为 0
     * @author Dennis
     * @return parent_id 父级资源ID，一级资源 父级ID 为 0
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 父级资源ID，一级资源 父级ID 为 0
     * @author Dennis
     * @param parentId 父级资源ID，一级资源 父级ID 为 0
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 资源名称、 唯一
     * @author Dennis
     * @return uk_name 资源名称、 唯一
     */
    public String getUkName() {
        return ukName;
    }

    /**
     * 资源名称、 唯一
     * @author Dennis
     * @param ukName 资源名称、 唯一
     */
    public void setUkName(String ukName) {
        this.ukName = ukName == null ? null : ukName.trim();
    }

    /**
     * 路由路径
     * @author Dennis
     * @return path 路由路径
     */
    public String getPath() {
        return path;
    }

    /**
     * 路由路径
     * @author Dennis
     * @param path 路由路径
     */
    public void setPath(String path) {
        this.path = path == null ? null : path.trim();
    }

    /**
     * 授权 例如：sys:user:save, 中间；隔开
     * @author Dennis
     * @return perms 授权 例如：sys:user:save, 中间；隔开
     */
    public String getPerms() {
        return perms;
    }

    /**
     * 授权 例如：sys:user:save, 中间；隔开
     * @author Dennis
     * @param perms 授权 例如：sys:user:save, 中间；隔开
     */
    public void setPerms(String perms) {
        this.perms = perms == null ? null : perms.trim();
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     * @author Dennis
     * @return Type 类型   0：目录   1：菜单   2：按钮
     */
    public Integer getType() {
        return type;
    }

    /**
     * 类型   0：目录   1：菜单   2：按钮
     * @author Dennis
     * @param type 类型   0：目录   1：菜单   2：按钮
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     * 排序
     * @author Dennis
     * @return order_num 排序
     */
    public Integer getOrderNum() {
        return orderNum;
    }

    /**
     * 排序
     * @author Dennis
     * @param orderNum 排序
     */
    public void setOrderNum(Integer orderNum) {
        this.orderNum = orderNum;
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
        sb.append(", parentId=").append(parentId);
        sb.append(", ukName=").append(ukName);
        sb.append(", path=").append(path);
        sb.append(", perms=").append(perms);
        sb.append(", Type=").append(type);
        sb.append(", orderNum=").append(orderNum);
        sb.append(", deleteFlag=").append(deleteFlag);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateTime=").append(updateTime);
        sb.append("]");
        return sb.toString();
    }
}