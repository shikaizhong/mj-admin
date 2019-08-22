package com.mj.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Complaint {
    /**
     * 主键id pk_id
     */
    private Integer pkId;

    /**
     * 投诉客户 WangWangNum
     */
    private String wangwangnum;

    /**
     * 投诉日期 complaintDate
     */
    @JsonFormat(locale="zh", timezone="GMT+8", pattern="yyyy-MM-dd")
    private Date complaintdate;

    /**
     * 投诉渠道:  1:招商京东 2:招商淘宝 3:综管部 4:企划部 5:京东官方投诉 6:京东差评投诉 7:淘宝官方投诉 8:其他 channel
     */
    private Integer channel;

    /**
     * 场景还原 sceneRestoration
     */
    private String scenerestoration;

    /**
     * 备注 remarks
     */
    private String remarks;

    /**
     * 投诉次数,每投诉一次自动+1 frequency
     */
    private Integer frequency;

    /**
     * 审核状态 0：待审核 1:已审核 2:待审定 status
     */
    private Integer status;

    /**
     * 是否删除: 0:正常 1:删除 is_delete
     */
    private Integer isDelete;

    /**
     * 投诉内容 content
     */
    private String content;

    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getWangwangnum() {
        return wangwangnum;
    }

    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum;
    }

    public Date getComplaintdate() {
        return complaintdate;
    }

    public void setComplaintdate(Date complaintdate) {
        this.complaintdate = complaintdate;
    }

    public Integer getChannel() {
        return channel;
    }

    public void setChannel(Integer channel) {
        this.channel = channel;
    }

    public String getScenerestoration() {
        return scenerestoration;
    }

    public void setScenerestoration(String scenerestoration) {
        this.scenerestoration = scenerestoration;
    }

    public String getRemarks() {
        return remarks;
    }

    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

//    public Integer getLevel() {
//        return level;
//    }
//
//    public void setLevel(Integer level) {
//        this.level = level;
//    }
//
//    public Integer getResult() {
//        return result;
//    }
//
//    public void setResult(Integer result) {
//        this.result = result;
//    }
//
//    public Integer getResponsibility() {
//        return responsibility;
//    }
//
//    public void setResponsibility(Integer responsibility) {
//        this.responsibility = responsibility;
//    }
//
//    public Integer getComplaintid() {
//        return complaintid;
//    }
//
//    public void setComplaintid(Integer complaintid) {
//        this.complaintid = complaintid;
//    }

//    public Integer getComplaintId() {
//        return complaintId;
//    }
//
//    public void setComplaintId(Integer complaintId) {
//        this.complaintId = complaintId;
//    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

//    public String getLevelName() {
//        return levelName;
//    }
//
//    public void setLevelName(String levelName) {
//        this.levelName = levelName;
//    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}