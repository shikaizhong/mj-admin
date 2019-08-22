package com.mj.dao.vo;

public class TeamVo {
    /**
     *  ID
     */
    private Integer id;
    /**
     *  TeamID
     */
    private Integer teamid;
    /**
     * 团队名称 TeamName
     */
    private String teamname;
    /**
     *  TScustomer
     */
    private String tscustomer;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getTeamid() {
        return teamid;
    }

    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
    }

    public String getTeamname() {
        return teamname;
    }

    public void setTeamname(String teamname) {
        this.teamname = teamname;
    }

    public String getTscustomer() {
        return tscustomer;
    }

    public void setTscustomer(String tscustomer) {
        this.tscustomer = tscustomer;
    }
}
