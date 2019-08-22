package com.mj.dao.entity;

public class Team {
    /**
     * 团队id ID
     */
    private Integer id;

    /**
     * 团队名称 TeamName
     */
    private String teamname;

    /**
     *  Flag
     */
    private String flag;

    /**
     * 部门名称 Department
     */
    private String department;

    /**
     *  TargetAmount
     */
    private String targetamount;

    /**
     *  TargetDate
     */
    private String targetdate;

    /**
     *  TargetBeginDate
     */
    private String targetbegindate;

    /**
     *  TargetEndDate
     */
    private String targetenddate;

    /**
     *  DepartmentRealId
     */
    private Integer departmentrealid;

    /**
     * 团队id
     * @author simon
     * @return ID 团队id
     */
    public Integer getId() {
        return id;
    }

    /**
     * 团队id
     * @author simon
     * @param id 团队id
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 团队名称
     * @author simon
     * @return TeamName 团队名称
     */
    public String getTeamname() {
        return teamname;
    }

    /**
     * 团队名称
     * @author simon
     * @param teamname 团队名称
     */
    public void setTeamname(String teamname) {
        this.teamname = teamname == null ? null : teamname.trim();
    }

    /**
     * 
     * @author simon
     * @return Flag 
     */
    public String getFlag() {
        return flag;
    }

    /**
     * 
     * @author simon
     * @param flag 
     */
    public void setFlag(String flag) {
        this.flag = flag == null ? null : flag.trim();
    }

    /**
     * 部门名称
     * @author simon
     * @return Department 部门名称
     */
    public String getDepartment() {
        return department;
    }

    /**
     * 部门名称
     * @author simon
     * @param department 部门名称
     */
    public void setDepartment(String department) {
        this.department = department == null ? null : department.trim();
    }

    /**
     * 
     * @author simon
     * @return TargetAmount 
     */
    public String getTargetamount() {
        return targetamount;
    }

    /**
     * 
     * @author simon
     * @param targetamount 
     */
    public void setTargetamount(String targetamount) {
        this.targetamount = targetamount == null ? null : targetamount.trim();
    }

    /**
     * 
     * @author simon
     * @return TargetDate 
     */
    public String getTargetdate() {
        return targetdate;
    }

    /**
     * 
     * @author simon
     * @param targetdate 
     */
    public void setTargetdate(String targetdate) {
        this.targetdate = targetdate == null ? null : targetdate.trim();
    }

    /**
     * 
     * @author simon
     * @return TargetBeginDate 
     */
    public String getTargetbegindate() {
        return targetbegindate;
    }

    /**
     * 
     * @author simon
     * @param targetbegindate 
     */
    public void setTargetbegindate(String targetbegindate) {
        this.targetbegindate = targetbegindate == null ? null : targetbegindate.trim();
    }

    /**
     * 
     * @author simon
     * @return TargetEndDate 
     */
    public String getTargetenddate() {
        return targetenddate;
    }

    /**
     * 
     * @author simon
     * @param targetenddate 
     */
    public void setTargetenddate(String targetenddate) {
        this.targetenddate = targetenddate == null ? null : targetenddate.trim();
    }

    /**
     * 
     * @author simon
     * @return DepartmentRealId 
     */
    public Integer getDepartmentrealid() {
        return departmentrealid;
    }

    /**
     * 
     * @author simon
     * @param departmentrealid 
     */
    public void setDepartmentrealid(Integer departmentrealid) {
        this.departmentrealid = departmentrealid;
    }

    /**
     *
     * @mbg.generated 2019-07-18 16:14:00
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", teamname=").append(teamname);
        sb.append(", flag=").append(flag);
        sb.append(", department=").append(department);
        sb.append(", targetamount=").append(targetamount);
        sb.append(", targetdate=").append(targetdate);
        sb.append(", targetbegindate=").append(targetbegindate);
        sb.append(", targetenddate=").append(targetenddate);
        sb.append(", departmentrealid=").append(departmentrealid);
        sb.append("]");
        return sb.toString();
    }
}