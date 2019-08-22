package com.mj.dao.entity;

import java.util.Date;

public class Personnel {
    /**
     *  ID
     */
    private Integer id;

    /**
     *  UserName
     */
    private String username;

    /**
     *  Sex
     */
    private String sex;

    /**
     *  TeamID
     */
    private Integer teamid;

    /**
     *  Flag
     */
    private String flag;

    /**
     *  Pwd
     */
    private String pwd;

    /**
     *  IndeustryID
     */
    private Integer indeustryid;

    /**
     *  shoppType
     */
    private String shopptype;

    /**
     *  Ranges
     */
    private String ranges;

    /**
     *  Isreceive
     */
    private Integer isreceive;

    /**
     *  WorkType
     */
    private Integer worktype;

    /**
     *  em
     */
    private Integer em;

    /**
     *  miaoshu
     */
    private Integer miaoshu;

    /**
     *  taidu
     */
    private Integer taidu;

    /**
     *  shudu
     */
    private Integer shudu;

    /**
     *  xiaoliang
     */
    private Integer xiaoliang;

    /**
     *  xinyongdengji
     */
    private Integer xinyongdengji;

    /**
     *  hangye
     */
    private String hangye;

    /**
     *  badlv
     */
    private Integer badlv;

    /**
     *  MJscore
     */
    private Integer mjscore;

    /**
     *  MJbean
     */
    private Integer mjbean;

    /**
     *  FacePic
     */
    private String facepic;

    /**
     *  Place
     */
    private String place;

    /**
     *  IsPlaceSame
     */
    private Integer isplacesame;

    /**
     *  XiYongFirst
     */
    private Integer xiyongfirst;

    /**
     *  XiYongLast
     */
    private Integer xiyonglast;

    /**
     *  IsDirector
     */
    private Integer isdirector;

    /**
     *  RecruitmentId
     */
    private Integer recruitmentid;

    /**
     *  DesignerLevel
     */
    private Integer designerlevel;

    /**
     *  ShieldingTime
     */
    private Date shieldingtime;

    /**
     *  ShieldNumber
     */
    private Integer shieldnumber;

    /**
     *  LockTime
     */
    private Date locktime;

    /**
     *  ContainKeyWords
     */
    private String containkeywords;

    /**
     *  UnContainKeyWords
     */
    private String uncontainkeywords;

    /**
     *  NumberOfTradesStart
     */
    private Integer numberoftradesstart;

    /**
     *  NumberOfTradesEnd
     */
    private Integer numberoftradesend;

    /**
     *  Operation_levelID
     */
    private Integer operationLevelid;

    /**
     *  Recent_single_time
     */
    private Date recentSingleTime;

    /**
     *  is_stop
     */
    private Integer isStop;

    /**
     * 
     * @author simon
     * @return ID 
     */
    public Integer getId() {
        return id;
    }

    /**
     * 
     * @author simon
     * @param id 
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 
     * @author simon
     * @return UserName 
     */
    public String getUsername() {
        return username;
    }

    /**
     * 
     * @author simon
     * @param username 
     */
    public void setUsername(String username) {
        this.username = username == null ? null : username.trim();
    }

    /**
     * 
     * @author simon
     * @return Sex 
     */
    public String getSex() {
        return sex;
    }

    /**
     * 
     * @author simon
     * @param sex 
     */
    public void setSex(String sex) {
        this.sex = sex == null ? null : sex.trim();
    }

    /**
     * 
     * @author simon
     * @return TeamID 
     */
    public Integer getTeamid() {
        return teamid;
    }

    /**
     * 
     * @author simon
     * @param teamid 
     */
    public void setTeamid(Integer teamid) {
        this.teamid = teamid;
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
     * 
     * @author simon
     * @return Pwd 
     */
    public String getPwd() {
        return pwd;
    }

    /**
     * 
     * @author simon
     * @param pwd 
     */
    public void setPwd(String pwd) {
        this.pwd = pwd == null ? null : pwd.trim();
    }

    /**
     * 
     * @author simon
     * @return IndeustryID 
     */
    public Integer getIndeustryid() {
        return indeustryid;
    }

    /**
     * 
     * @author simon
     * @param indeustryid 
     */
    public void setIndeustryid(Integer indeustryid) {
        this.indeustryid = indeustryid;
    }

    /**
     * 
     * @author simon
     * @return shoppType 
     */
    public String getShopptype() {
        return shopptype;
    }

    /**
     * 
     * @author simon
     * @param shopptype 
     */
    public void setShopptype(String shopptype) {
        this.shopptype = shopptype == null ? null : shopptype.trim();
    }

    /**
     * 
     * @author simon
     * @return Ranges 
     */
    public String getRanges() {
        return ranges;
    }

    /**
     * 
     * @author simon
     * @param ranges 
     */
    public void setRanges(String ranges) {
        this.ranges = ranges == null ? null : ranges.trim();
    }

    /**
     * 
     * @author simon
     * @return Isreceive 
     */
    public Integer getIsreceive() {
        return isreceive;
    }

    /**
     * 
     * @author simon
     * @param isreceive 
     */
    public void setIsreceive(Integer isreceive) {
        this.isreceive = isreceive;
    }

    /**
     * 
     * @author simon
     * @return WorkType 
     */
    public Integer getWorktype() {
        return worktype;
    }

    /**
     * 
     * @author simon
     * @param worktype 
     */
    public void setWorktype(Integer worktype) {
        this.worktype = worktype;
    }

    /**
     * 
     * @author simon
     * @return em 
     */
    public Integer getEm() {
        return em;
    }

    /**
     * 
     * @author simon
     * @param em 
     */
    public void setEm(Integer em) {
        this.em = em;
    }

    /**
     * 
     * @author simon
     * @return miaoshu 
     */
    public Integer getMiaoshu() {
        return miaoshu;
    }

    /**
     * 
     * @author simon
     * @param miaoshu 
     */
    public void setMiaoshu(Integer miaoshu) {
        this.miaoshu = miaoshu;
    }

    /**
     * 
     * @author simon
     * @return taidu 
     */
    public Integer getTaidu() {
        return taidu;
    }

    /**
     * 
     * @author simon
     * @param taidu 
     */
    public void setTaidu(Integer taidu) {
        this.taidu = taidu;
    }

    /**
     * 
     * @author simon
     * @return shudu 
     */
    public Integer getShudu() {
        return shudu;
    }

    /**
     * 
     * @author simon
     * @param shudu 
     */
    public void setShudu(Integer shudu) {
        this.shudu = shudu;
    }

    /**
     * 
     * @author simon
     * @return xiaoliang 
     */
    public Integer getXiaoliang() {
        return xiaoliang;
    }

    /**
     * 
     * @author simon
     * @param xiaoliang 
     */
    public void setXiaoliang(Integer xiaoliang) {
        this.xiaoliang = xiaoliang;
    }

    /**
     * 
     * @author simon
     * @return xinyongdengji 
     */
    public Integer getXinyongdengji() {
        return xinyongdengji;
    }

    /**
     * 
     * @author simon
     * @param xinyongdengji 
     */
    public void setXinyongdengji(Integer xinyongdengji) {
        this.xinyongdengji = xinyongdengji;
    }

    /**
     * 
     * @author simon
     * @return hangye 
     */
    public String getHangye() {
        return hangye;
    }

    /**
     * 
     * @author simon
     * @param hangye 
     */
    public void setHangye(String hangye) {
        this.hangye = hangye == null ? null : hangye.trim();
    }

    /**
     * 
     * @author simon
     * @return badlv 
     */
    public Integer getBadlv() {
        return badlv;
    }

    /**
     * 
     * @author simon
     * @param badlv 
     */
    public void setBadlv(Integer badlv) {
        this.badlv = badlv;
    }

    /**
     * 
     * @author simon
     * @return MJscore 
     */
    public Integer getMjscore() {
        return mjscore;
    }

    /**
     * 
     * @author simon
     * @param mjscore 
     */
    public void setMjscore(Integer mjscore) {
        this.mjscore = mjscore;
    }

    /**
     * 
     * @author simon
     * @return MJbean 
     */
    public Integer getMjbean() {
        return mjbean;
    }

    /**
     * 
     * @author simon
     * @param mjbean 
     */
    public void setMjbean(Integer mjbean) {
        this.mjbean = mjbean;
    }

    /**
     * 
     * @author simon
     * @return FacePic 
     */
    public String getFacepic() {
        return facepic;
    }

    /**
     * 
     * @author simon
     * @param facepic 
     */
    public void setFacepic(String facepic) {
        this.facepic = facepic == null ? null : facepic.trim();
    }

    /**
     * 
     * @author simon
     * @return Place 
     */
    public String getPlace() {
        return place;
    }

    /**
     * 
     * @author simon
     * @param place 
     */
    public void setPlace(String place) {
        this.place = place == null ? null : place.trim();
    }

    /**
     * 
     * @author simon
     * @return IsPlaceSame 
     */
    public Integer getIsplacesame() {
        return isplacesame;
    }

    /**
     * 
     * @author simon
     * @param isplacesame 
     */
    public void setIsplacesame(Integer isplacesame) {
        this.isplacesame = isplacesame;
    }

    /**
     * 
     * @author simon
     * @return XiYongFirst 
     */
    public Integer getXiyongfirst() {
        return xiyongfirst;
    }

    /**
     * 
     * @author simon
     * @param xiyongfirst 
     */
    public void setXiyongfirst(Integer xiyongfirst) {
        this.xiyongfirst = xiyongfirst;
    }

    /**
     * 
     * @author simon
     * @return XiYongLast 
     */
    public Integer getXiyonglast() {
        return xiyonglast;
    }

    /**
     * 
     * @author simon
     * @param xiyonglast 
     */
    public void setXiyonglast(Integer xiyonglast) {
        this.xiyonglast = xiyonglast;
    }

    /**
     * 
     * @author simon
     * @return IsDirector 
     */
    public Integer getIsdirector() {
        return isdirector;
    }

    /**
     * 
     * @author simon
     * @param isdirector 
     */
    public void setIsdirector(Integer isdirector) {
        this.isdirector = isdirector;
    }

    /**
     * 
     * @author simon
     * @return RecruitmentId 
     */
    public Integer getRecruitmentid() {
        return recruitmentid;
    }

    /**
     * 
     * @author simon
     * @param recruitmentid 
     */
    public void setRecruitmentid(Integer recruitmentid) {
        this.recruitmentid = recruitmentid;
    }

    /**
     * 
     * @author simon
     * @return DesignerLevel 
     */
    public Integer getDesignerlevel() {
        return designerlevel;
    }

    /**
     * 
     * @author simon
     * @param designerlevel 
     */
    public void setDesignerlevel(Integer designerlevel) {
        this.designerlevel = designerlevel;
    }

    /**
     * 
     * @author simon
     * @return ShieldingTime 
     */
    public Date getShieldingtime() {
        return shieldingtime;
    }

    /**
     * 
     * @author simon
     * @param shieldingtime 
     */
    public void setShieldingtime(Date shieldingtime) {
        this.shieldingtime = shieldingtime;
    }

    /**
     * 
     * @author simon
     * @return ShieldNumber 
     */
    public Integer getShieldnumber() {
        return shieldnumber;
    }

    /**
     * 
     * @author simon
     * @param shieldnumber 
     */
    public void setShieldnumber(Integer shieldnumber) {
        this.shieldnumber = shieldnumber;
    }

    /**
     * 
     * @author simon
     * @return LockTime 
     */
    public Date getLocktime() {
        return locktime;
    }

    /**
     * 
     * @author simon
     * @param locktime 
     */
    public void setLocktime(Date locktime) {
        this.locktime = locktime;
    }

    /**
     * 
     * @author simon
     * @return ContainKeyWords 
     */
    public String getContainkeywords() {
        return containkeywords;
    }

    /**
     * 
     * @author simon
     * @param containkeywords 
     */
    public void setContainkeywords(String containkeywords) {
        this.containkeywords = containkeywords == null ? null : containkeywords.trim();
    }

    /**
     * 
     * @author simon
     * @return UnContainKeyWords 
     */
    public String getUncontainkeywords() {
        return uncontainkeywords;
    }

    /**
     * 
     * @author simon
     * @param uncontainkeywords 
     */
    public void setUncontainkeywords(String uncontainkeywords) {
        this.uncontainkeywords = uncontainkeywords == null ? null : uncontainkeywords.trim();
    }

    /**
     * 
     * @author simon
     * @return NumberOfTradesStart 
     */
    public Integer getNumberoftradesstart() {
        return numberoftradesstart;
    }

    /**
     * 
     * @author simon
     * @param numberoftradesstart 
     */
    public void setNumberoftradesstart(Integer numberoftradesstart) {
        this.numberoftradesstart = numberoftradesstart;
    }

    /**
     * 
     * @author simon
     * @return NumberOfTradesEnd 
     */
    public Integer getNumberoftradesend() {
        return numberoftradesend;
    }

    /**
     * 
     * @author simon
     * @param numberoftradesend 
     */
    public void setNumberoftradesend(Integer numberoftradesend) {
        this.numberoftradesend = numberoftradesend;
    }

    /**
     * 
     * @author simon
     * @return Operation_levelID 
     */
    public Integer getOperationLevelid() {
        return operationLevelid;
    }

    /**
     * 
     * @author simon
     * @param operationLevelid 
     */
    public void setOperationLevelid(Integer operationLevelid) {
        this.operationLevelid = operationLevelid;
    }

    /**
     * 
     * @author simon
     * @return Recent_single_time 
     */
    public Date getRecentSingleTime() {
        return recentSingleTime;
    }

    /**
     * 
     * @author simon
     * @param recentSingleTime 
     */
    public void setRecentSingleTime(Date recentSingleTime) {
        this.recentSingleTime = recentSingleTime;
    }

    /**
     * 
     * @author simon
     * @return is_stop 
     */
    public Integer getIsStop() {
        return isStop;
    }

    /**
     * 
     * @author simon
     * @param isStop 
     */
    public void setIsStop(Integer isStop) {
        this.isStop = isStop;
    }

    /**
     *
     * @mbg.generated 2019-07-16 15:28:39
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", username=").append(username);
        sb.append(", sex=").append(sex);
        sb.append(", teamid=").append(teamid);
        sb.append(", flag=").append(flag);
        sb.append(", pwd=").append(pwd);
        sb.append(", indeustryid=").append(indeustryid);
        sb.append(", shopptype=").append(shopptype);
        sb.append(", ranges=").append(ranges);
        sb.append(", isreceive=").append(isreceive);
        sb.append(", worktype=").append(worktype);
        sb.append(", em=").append(em);
        sb.append(", miaoshu=").append(miaoshu);
        sb.append(", taidu=").append(taidu);
        sb.append(", shudu=").append(shudu);
        sb.append(", xiaoliang=").append(xiaoliang);
        sb.append(", xinyongdengji=").append(xinyongdengji);
        sb.append(", hangye=").append(hangye);
        sb.append(", badlv=").append(badlv);
        sb.append(", mjscore=").append(mjscore);
        sb.append(", mjbean=").append(mjbean);
        sb.append(", facepic=").append(facepic);
        sb.append(", place=").append(place);
        sb.append(", isplacesame=").append(isplacesame);
        sb.append(", xiyongfirst=").append(xiyongfirst);
        sb.append(", xiyonglast=").append(xiyonglast);
        sb.append(", isdirector=").append(isdirector);
        sb.append(", recruitmentid=").append(recruitmentid);
        sb.append(", designerlevel=").append(designerlevel);
        sb.append(", shieldingtime=").append(shieldingtime);
        sb.append(", shieldnumber=").append(shieldnumber);
        sb.append(", locktime=").append(locktime);
        sb.append(", containkeywords=").append(containkeywords);
        sb.append(", uncontainkeywords=").append(uncontainkeywords);
        sb.append(", numberoftradesstart=").append(numberoftradesstart);
        sb.append(", numberoftradesend=").append(numberoftradesend);
        sb.append(", operationLevelid=").append(operationLevelid);
        sb.append(", recentSingleTime=").append(recentSingleTime);
        sb.append(", isStop=").append(isStop);
        sb.append("]");
        return sb.toString();
    }
}