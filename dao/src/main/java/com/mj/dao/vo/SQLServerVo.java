package com.mj.dao.vo;

public class SQLServerVo {

    /**
     * WangWangNum 旺旺名
     */
    private String wangwangnum;


    /**
     * CustType 客户类型 父 CustomerType表中
     */
    private String custtype;

    /**
     * ChildType 客户类型 子 CustomerChildType表中
     */
    private String childtype;

    /**
     * TurnoverMoney 合同金额 CustomerRecords 表中
     */
    private Double turnovermoney;

    /**
     * TeamName 所属团队 Team表中，与Personnel表中TeamID字段关联
     */
    private String teamname;

    /**
     * ServerDeadline，合同开始日期
     */
    private String serverdeadline;

    /**
     * ServerDeadlineEnd，合同结束日期
     */
    private String serverdeadlineend;

    /**
     * 合同期限，合同结束日期减去合同开始日期
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

    public String getWangwangnum() {
        return wangwangnum;
    }

    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum;
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

    public String getServerdeadline() {
        return serverdeadline;
    }

    public void setServerdeadline(String serverdeadline) {
        this.serverdeadline = serverdeadline;
    }

    public String getServerdeadlineend() {
        return serverdeadlineend;
    }

    public void setServerdeadlineend(String serverdeadlineend) {
        this.serverdeadlineend = serverdeadlineend;
    }

    public Long getDeadline() {
        return deadline;
    }

    public void setDeadline(Long deadline) {
        this.deadline = deadline;
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
