package com.mj.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HiddenTrouble {
    /**
     * 主键，隐患表 pk_id
     */
    private Integer pkId;
    /**
     * 投诉客户 WangWangNum
     */
    private String wangwangnum;

    /**
     * 隐患日期 hidden_date
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm")
    private Date hiddenDate;

    /**
     * 获取前端的时间而新增的，数据库中并无该字段，Vo层中也没有该字段
     */
    private String hDate;

//    /**
//     * 场景还原 scenario_reduction
//     */
//    private String scenarioReduction;

    /**
     * 状态：0、待受理 1、处理中 2、待审核 3、已完结 status
     */
    private Integer status;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 隐患次数，每申请一次，增加一 frequency
     */
    private Integer frequency;

    /**
     * 删除：0、显示 1、删除 is_delete
     */
    private Integer isDelete;

    /**
     * 投诉类别，对应判责表客诉类型 level
     */
    private Integer level;

    /**
     * 隐患原因 hidden_content
     */
    private String hiddenContent;

    /**
     * 主键，隐患表
     *
     * @return pk_id 主键，隐患表
     * @author Administrator
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键，隐患表
     *
     * @param pkId 主键，隐患表
     * @author Administrator
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }


    public String getWangwangnum() {
        return wangwangnum;
    }

    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum;
    }

    /**
     * 隐患日期
     *
     * @return hidden_date 隐患日期
     * @author Administrator
     */
    public Date getHiddenDate() {
        return hiddenDate;
    }

    /**
     * 隐患日期
     *
     * @param hiddenDate 隐患日期
     * @author Administrator
     */
    public void setHiddenDate(Date hiddenDate) {
        this.hiddenDate = hiddenDate;
    }

//    /**
//     * 场景还原
//     * @author Administrator
//     * @return scenario_reduction 场景还原
//     */
//    public String getScenarioReduction() {
//        return scenarioReduction;
//    }
//
//    /**
//     * 场景还原
//     * @author Administrator
//     * @param scenarioReduction 场景还原
//     */
//    public void setScenarioReduction(String scenarioReduction) {
//        this.scenarioReduction = scenarioReduction == null ? null : scenarioReduction.trim();
//    }

    /**
     * 状态：0、待受理 1、处理中 2、待审核 3、已完结
     *
     * @return status 状态：0、待受理 1、处理中 2、待审核 3、已完结
     * @author Administrator
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0、待受理 1、处理中 2、待审核 3、已完结
     *
     * @param status 状态：0、待受理 1、处理中 2、待审核 3、已完结
     * @author Administrator
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 备注
     *
     * @return remark 备注
     * @author Administrator
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     *
     * @param remark 备注
     * @author Administrator
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 隐患次数，每申请一次，增加一
     *
     * @return frequency 隐患次数，每申请一次，增加一
     * @author Administrator
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * 隐患次数，每申请一次，增加一
     *
     * @param frequency 隐患次数，每申请一次，增加一
     * @author Administrator
     */
    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }

    /**
     * 删除：0、显示 1、删除
     *
     * @return is_delete 删除：0、显示 1、删除
     * @author Administrator
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 删除：0、显示 1、删除
     *
     * @param isDelete 删除：0、显示 1、删除
     * @author Administrator
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 投诉类别，对应判责表客诉类型
     *
     * @return level 投诉类别，对应判责表客诉类型
     * @author Administrator
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 投诉类别，对应判责表客诉类型
     *
     * @param level 投诉类别，对应判责表客诉类型
     * @author Administrator
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 隐患原因
     *
     * @return hidden_content 隐患原因
     * @author Administrator
     */
    public String getHiddenContent() {
        return hiddenContent;
    }

    /**
     * 隐患原因
     *
     * @param hiddenContent 隐患原因
     * @author Administrator
     */
    public void setHiddenContent(String hiddenContent) {
        this.hiddenContent = hiddenContent == null ? null : hiddenContent.trim();
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    /**
     * @mbg.generated 2019-08-20 15:42:25
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", hiddenDate=").append(hiddenDate);
//        sb.append(", scenarioReduction=").append(scenarioReduction);
        sb.append(", status=").append(status);
        sb.append(", remark=").append(remark);
        sb.append(", frequency=").append(frequency);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", level=").append(level);
        sb.append(", hiddenContent=").append(hiddenContent);
        sb.append("]");
        return sb.toString();
    }
}