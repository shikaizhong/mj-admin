package com.mj.dao.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class RefundVo {

    /**
     * 主键 pk_id
     */
    private Integer pkId;

    /**
     * 退款客户 wang_wang_num
     */
    private String wangwangnum;

    /**
     * 退款日期 refund_date
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date refundDate;

    /**
     * 判责结果:0:微责  1:无责  2:重责 3:中责 4:轻责 5:待定 result
     */
    private Integer result;


    /**
     * 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付 refund_channel
     */
    private Integer refundChannel;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 退款金额 refund_amount
     */
    private Long refundAmount;

    /**
     * 删除：0、显示 1、删除 is_delete
     */
    private Integer isDelete;

    /**
     * 退款原因 refund_cause
     */
    private String refundCause;

    /**
     *  CustType 客户类型 父 t_customer_type表中
     */
    private String custtype;

    /**
     *  ChildType 客户类型 子 t_customer_child_type表中
     */
    private String childtype;

    /**
     *  TurnoverMoney 合同金额 t_customer_records 表中
     */
    private Double turnovermoney;

    /**
     *  TeamName 所属团队 t_team表中，与t_personnel表中TeamID字段关联
     */
    private String teamname;

    /**
     * 合同期限
     */
    private Long deadline;

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

    /***
     * 外因external_cause
     */
    public String externalCause;

    /**
     * 投诉大类别
     */
    private Integer level;
    //客诉子类别
    private Integer sonLevel;

    /**
     * 获取前端的时间而新增的，数据库中并无该字段，Vo层中也没有该字段
     */
    private String hDate;

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public String getExternalCause() {
        return externalCause;
    }

    public void setExternalCause(String externalCause) {
        this.externalCause = externalCause;
    }

    /**
     * 合同期限
     */
    public Long getDeadline() {
        return deadline;
    }

    /**
     * 合同期限
     */
    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

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

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public Integer getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(Integer refundChannel) {
        this.refundChannel = refundChannel;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public Integer getIsDelete() {
        return isDelete;
    }

    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause;
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

    public Double getTurnovermoney() {
        return turnovermoney;
    }

    public void setTurnovermoney(Double turnovermoney) {
        this.turnovermoney = turnovermoney;
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

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSonLevel() {
        return sonLevel;
    }

    public void setSonLevel(Integer sonLevel) {
        this.sonLevel = sonLevel;
    }
}