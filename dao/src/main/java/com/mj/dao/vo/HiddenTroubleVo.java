package com.mj.dao.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class HiddenTroubleVo {
    /**
     * 主键，隐患表 pk_id
     */
    private Integer pkId;

    /**
     * 客户名 wang_wang_num
     */
    private String wangwangnum;

    /**
     * 隐患日期 hidden_date
     */
    @JsonFormat(locale = "zh", pattern = "yyyy-MM-dd HH:mm")
    private Date hiddenDate;

    /**
     * 状态：0、待受理 1、处理中 2、待审核 3、已完结 status
     */
    private Integer status;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 隐患次数，根据旺旺名，每申请一次，增加一 frequency
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
     * CustType 客户类型 父 t_customer_type表中
     */
    private String custtype;

    /**
     * ChildType 客户类型 子 t_customer_child_type表中
     */
    private String childtype;

    /**
     * TeamName 所属团队 t_team表中，与t_personnel表中TeamID字段关联
     */
    private String teamname;

    /**
     * 店长
     */
    private String username1;

    /**
     * 招商顾问
     */
    private String username2;

    /**
     * 店铺类型
     */
    private String shopptype;

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
     * 隐患次数，根据旺旺名，每申请一次，增加一
     *
     * @return frequency 隐患次数，每申请一次，增加一
     * @author Administrator
     */
    public Integer getFrequency() {
        return frequency;
    }

    /**
     * 隐患次数，根据旺旺名，每申请一次，增加一
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

    public String getCusttype() {
        return custtype;
    }

    public void setCusttype(String custtype) {
        this.custtype = custtype;
    }

    public String getChildtype() {
        return childtype;
    }

    public void setChildtype(String childtype) {
        this.childtype = childtype;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getUsername1() {
        return username1;
    }

    public void setUsername1(String username1) {
        this.username1 = username1;
    }

    public String getUsername2() {
        return username2;
    }

    public void setUsername2(String username2) {
        this.username2 = username2;
    }

    public String getShopptype() {
        return shopptype;
    }

    public void setShopptype(String shopptype) {
        this.shopptype = shopptype;
    }
}
