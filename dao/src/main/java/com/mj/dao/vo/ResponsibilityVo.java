package com.mj.dao.vo;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

/**
 * @Author Simon
 * @Method 
 * @Version 1.0
 * @Return 
 * @Exception 实体封装数据
 * @Date 2019-08-29 0029 10:38:43
 */
 
public class ResponsibilityVo {
    //判责字段
    /**
     * 主键id pk_id
     */
    private Integer pkId;

    /**
     * 客诉大类别 对应complaint_level的parent_id level
     */
    private Integer level;

    /**
     * 客诉名称: 1:直通车不专业,2:作图,3:服务不专业,4:服务态度不好,5:店长进度慢,6:店长沟通不好,7:服务流量,8:服务转化,9:店铺排名,10直通车没人管 level_name
     */
    private String sonLevel;

    /**
     * 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责 result
     */
    private Integer result;

    /**
     * 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手 responsibilityer
     */
    private Integer responsibilityer;

    /**
     * 客诉级别: 0:一级,1:二级,2:三级 grade
     */
    private Integer grade;

    /**
     * 判责日期 create_time
     */
    private Date createTime;

    /**
     * 判责人员id:对应personnel的id responsibilityor
     */
    private Integer responsibilityor;

    /**
     * 投诉id complaint_id
     */
    private Integer complaintId;

    /**
     * 判责类型 0:投诉,1:判责,2:退款 type
     */
    private Integer type;
    /**
     * 客诉点总结 summary
     */
    private String summary;

    /**
     * 判责依据文本 basic
     */
    private String basic;

    /**
     * 处理方案 deal
     */
    private String deal;

    //投诉字段
    /**
     * 投诉日期 complaintDate
     */
    @JsonFormat(locale = "zh", timezone = "GMT+8", pattern = "yyyy-MM-dd HH:mm:ss")
    private Date complaintdate;
    /**
     * 投诉渠道:  1:招商京东 2:招商淘宝 3:综管部 4:企划部 5:京东官方投诉 6:京东差评投诉 7:淘宝官方投诉 8:其他 channel
     */
    private Integer channel;
    /**
     * 投诉客户 WangWangNum
     */
    private String wangwangnum;

    /**
     * 客诉类别大类id: parent_id
     */
    private Integer parentId;
    //投诉大类别名称
    private String parentName;
    /**
     * 客诉类别名 complaint_name
     */
    private String complaintName;
    /**
     *  TScustomer车手
     */
    private String tscustomer;
    /**
     * tename车手名字
     */
    private String tename;
    /**
     * 团队名称 TeamName
     */
    private String teamname;
    /**
     *  ShoppType店铺类型
     */
    private String shopptype;
    /**
     *  ServerDeadline
     */
    private String serverdeadline;
    /**
     *  PersonnelID招商顾问id
     */
    private Integer personnelid;

    /***
     * 招商顾问name
     */
    private String pname;
    /***
     * 招商顾问teamname
     */
    private String pteamname;
    /**
     * 隐患日期 hidden_date
     */
    private Date hiddenDate;
    /**
     * 隐患原因 hidden_content
     */
    private String hiddenContent;

    /**
     * 退款日期 refund_date
     */
    private Date refundDate;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 次数
     */
    private Integer frequency;

    /**
     * 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付 refund_channel
     */
    private Integer refundChannel;

    /**
     * 退款金额 refund_amount
     */
    private Long refundAmount;

    /**
     * 退款原因 refund_cause
     */
    private String refundCause;
    /***
     * 外因external_cause
     */
    public String externalCause;
    /**
     * 合同期限
     */
    private Long deadline;

    /**
     * ServerDeadlineEnd，合同结束日期
     */
    private String serverdeadlineend;

    //投诉类型
    private Integer complaintType;

    //隐患类型
    private Integer hiddenType;

    //退款类型
    private Integer refundType;

    //客户类型
    private  String custtype;

    //客户类型子
    private  String childtype;

    //合同金额
    private Double turnovermoney;

    //生产get.set方法
    public Integer getPkId() {
        return pkId;
    }

    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getSonLevel() {
        return sonLevel;
    }

    public void setSonLevel(String sonLevel) {
        this.sonLevel = sonLevel;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getResponsibilityer() {
        return responsibilityer;
    }

    public void setResponsibilityer(Integer responsibilityer) {
        this.responsibilityer = responsibilityer;
    }

    public Integer getGrade() {
        return grade;
    }

    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Integer getResponsibilityor() {
        return responsibilityor;
    }

    public void setResponsibilityor(Integer responsibilityor) {
        this.responsibilityor = responsibilityor;
    }

    public Integer getComplaintId() {
        return complaintId;
    }

    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public String getBasic() {
        return basic;
    }

    public void setBasic(String basic) {
        this.basic = basic;
    }

    public String getDeal() {
        return deal;
    }

    public void setDeal(String deal) {
        this.deal = deal;
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

    public String getWangwangnum() {
        return wangwangnum;
    }

    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getComplaintName() {
        return complaintName;
    }

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    public String getTscustomer() {
        return tscustomer;
    }

    public void setTscustomer(String tscustomer) {
        this.tscustomer = tscustomer;
    }

    public String getTename() {
        return tename;
    }

    public void setTename(String tename) {
        this.tename = tename;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getShopptype() {
        return shopptype;
    }

    public void setShopptype(String shopptype) {
        this.shopptype = shopptype;
    }

    public String getServerdeadline() {
        return serverdeadline;
    }

    public void setServerdeadline(String serverdeadline) {
        this.serverdeadline = serverdeadline;
    }

    public Integer getPersonnelid() {
        return personnelid;
    }

    public void setPersonnelid(Integer personnelid) {
        this.personnelid = personnelid;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public String getPteamname() {
        return pteamname;
    }

    public void setPteamname(String pteamname) {
        this.pteamname = pteamname;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    public Date getHiddenDate() {
        return hiddenDate;
    }

    public void setHiddenDate(Date hiddenDate) {
        this.hiddenDate = hiddenDate;
    }

    public String getHiddenContent() {
        return hiddenContent;
    }

    public void setHiddenContent(String hiddenContent) {
        this.hiddenContent = hiddenContent;
    }

    public Date getRefundDate() {
        return refundDate;
    }

    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Integer getFrequency() {
        return frequency;
    }

    public void setFrequency(Integer frequency) {
        this.frequency = frequency;
    }


    public Integer getRefundChannel() {
        return refundChannel;
    }

    public void setRefundChannel(Integer refundChannel) {
        this.refundChannel = refundChannel;
    }

    public Long getRefundAmount() {
        return refundAmount;
    }

    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    public String getRefundCause() {
        return refundCause;
    }

    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause;
    }

    public String getExternalCause() {
        return externalCause;
    }

    public void setExternalCause(String externalCause) {
        this.externalCause = externalCause;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
    }

    public String getServerdeadlineend() {
        return serverdeadlineend;
    }

    public void setServerdeadlineend(String serverdeadlineend) {
        this.serverdeadlineend = serverdeadlineend;
    }

    public Integer getComplaintType() {
        return complaintType;
    }

    public void setComplaintType(Integer complaintType) {
        this.complaintType = complaintType;
    }

    public Integer getHiddenType() {
        return hiddenType;
    }

    public void setHiddenType(Integer hiddenType) {
        this.hiddenType = hiddenType;
    }

    public Integer getRefundType() {
        return refundType;
    }

    public void setRefundType(Integer refundType) {
        this.refundType = refundType;
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
}
