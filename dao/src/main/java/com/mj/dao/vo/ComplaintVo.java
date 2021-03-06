package com.mj.dao.vo;

import java.util.Date;


public class ComplaintVo {
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
//    @JSONField(format = "yyyy-MM-dd HH:mm:ss")
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
     * 备注 remark
     */
    private String remark;

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
    //自定义
    /**
     *  顾客类型
     */
    private String shopptype;
    /**
     * 团队名称 TeamName
     */
    private String teamname;
    /**
     * 部门名称 Department
     */
    private String department;
    /**
     *  is_stop
     */
    private Integer isStop;
    private String username;
    private Integer id;
    /**
     *  TechnologyRecruitmentID车手id
     */
    private Integer technologyrecruitmentid;
    /**
     *  PersonnelID招商顾问id
     */
    private Integer personnelid;

    /**
     * tename车手名字
     */
    private String tename;
    /**
     * pname 招商顾问名字
     */
    private String pname;
    /**
     *  TeamID团队id
     */
    private Integer teamid;
    //判责状态
    private Integer result;
    //客诉子类别
    private Integer sonLevel;

    /**
     * 获取前端的时间而新增的，数据库中并无该字段，Vo层中也没有该字段
     */
    private String hDate;
    /**
     * 投诉类别，对应判责表客诉类型 level
     */
    private Integer level;

    public Integer getSonLevel() {
        return sonLevel;
    }

    public void setSonLevel(Integer sonLevel) {
        this.sonLevel = sonLevel;
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    public Integer getTechnologyrecruitmentid() {
        return technologyrecruitmentid;
    }

    public void setTechnologyrecruitmentid(Integer technologyrecruitmentid) {
        this.technologyrecruitmentid = technologyrecruitmentid;
    }

    public String getTename() {
        return tename;
    }

    public void setTename(String tename) {
        this.tename = tename;
    }

    public String getPname() {
        return pname;
    }

    public void setPname(String pname) {
        this.pname = pname;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }
    /**
     *  CustType
     */
    private Integer custtype;
    /**
     *  WorkType
     */
    private Integer worktype;

    /**
     * 店长
     * @return
     */
    private String tscustomer;

    /**
     * 客诉类别创建时间 create_time
     */
    private Date createTime;

    /***
     * 店铺近30天成交额
     */
    private Integer turnover;

    /***
     * 店铺近30天成交笔数
     * @return
     */
    private Integer number;

    /***
     *店铺行业
     * @return
     */
    private Integer industry;

    /***
     *跟进人员
     * @return
     */
    private Integer followPersonel;

    /***
     * 处理方案
     */
    private String processingScheme;

    /***
     * 处理过程
     * @return
     */
    private String followProcess;


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

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    public Integer getWorktype() {
        return worktype;
    }

    public void setWorktype(Integer worktype) {
        this.worktype = worktype;
    }

    public Integer getCusttype() {
        return custtype;
    }

    public void setCusttype(Integer custtype) {
        this.custtype = custtype;
    }

    public Integer getIsStop() {
        return isStop;
    }

    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
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

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getShopptype() {
        return shopptype;
    }

    public void setShopptype(String shopptype) {
        this.shopptype = shopptype;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public Integer getPersonnelid() {
        return personnelid;
    }

    public void setPersonnelid(Integer personnelid) {
        this.personnelid = personnelid;
    }

    public String getTscustomer() {
        return tscustomer;
    }

    public void setTscustomer(String tscustomer) {
        this.tscustomer = tscustomer;
    }

    public Integer getTurnover() {
        return turnover;
    }

    public void setTurnover(Integer turnover) {
        this.turnover = turnover;
    }

    public Integer getNumber() {
        return number;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public Integer getIndustry() {
        return industry;
    }

    public void setIndustry(Integer industry) {
        this.industry = industry;
    }

    public Integer getFollowPersonel() {
        return followPersonel;
    }

    public void setFollowPersonel(Integer followPersonel) {
        this.followPersonel = followPersonel;
    }

    public String getProcessingScheme() {
        return processingScheme;
    }

    public void setProcessingScheme(String processingScheme) {
        this.processingScheme = processingScheme;
    }

    public String getFollowProcess() {
        return followProcess;
    }

    public void setFollowProcess(String followProcess) {
        this.followProcess = followProcess;
    }
}
