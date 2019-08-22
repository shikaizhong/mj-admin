package com.mj.admin.params;

import java.util.Date;

public class SchoolRequest {
    private Integer pkId;

    /**
     * 所在城市 city_id
     */
    private Integer cityId;

    /**
     * 学校名称 name
     */
    private String name;

    /**
     * 学校位置 location
     */
    private String location;

    /**
     * 简介 introduce
     */
    private String introduce;



    /**
     * 状态  0：正常  1：锁定 is_lock
     */
    private Integer isLock;

    /**
     * 是否删除 0：正常 1：删除 is_delete
     */
    private Integer isDelete;

    /**
     * 创建时间 create_time
     */
    private Date createTime;

    private String cityName;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getCityId() {
        return cityId;
    }

    public void setCityId(Integer cityId) {
        this.cityId = cityId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
    }

    public Integer getIsLock() {
        return isLock;
    }

    public void setIsLock(Integer isLock) {
        this.isLock = isLock;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getCityName() {
        return cityName;
    }

    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
}
