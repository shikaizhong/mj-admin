package com.mj.dao.entity;

import java.util.Date;

public class Customer {
    /**
     *  ID
     */
    private Integer id;

    /**
     *  WangWangNum
     */
    private String wangwangnum;

    /**
     *  ServerName
     */
    private String servername;

    /**
     *  ServerDeadline
     */
    private String serverdeadline;

    /**
     *  Indeutry
     */
    private String indeutry;

    /**
     *  ShoppType
     */
    private String shopptype;

    /**
     *  ShoppRank
     */
    private String shopprank;

    /**
     *  ShoppAddress
     */
    private String shoppaddress;

    /**
     *  Name
     */
    private String name;

    /**
     *  Phone
     */
    private String phone;

    /**
     *  ContactAddress
     */
    private String contactaddress;

    /**
     *  Place
     */
    private String place;

    /**
     *  OddNumbers
     */
    private String oddnumbers;

    /**
     *  Chat
     */
    private String chat;

    /**
     *  flag
     */
    private String flag;

    /**
     *  AddTime
     */
    private Date addtime;

    /**
     *  ServerDeadlineEnd
     */
    private String serverdeadlineend;

    /**
     *  TScustomer
     */
    private String tscustomer;

    /**
     *  State
     */
    private Integer state;

    /**
     *  WorkRecordState
     */
    private Integer workrecordstate;

    /**
     *  IsComplained
     */
    private Integer iscomplained;

    /**
     *  SendReportTime
     */
    private Date sendreporttime;

    /**
     *  WriteMethodTime
     */
    private Date writemethodtime;

    /**
     *  LinkedTime
     */
    private Date linkedtime;

    /**
     *  QuantumAccounts
     */
    private String quantumaccounts;

    /**
     *  QuantumCryptography
     */
    private String quantumcryptography;

    /**
     *  PurchaseChannels
     */
    private String purchasechannels;

    /**
     *  IsCutPriceOrBrushSales
     */
    private Integer iscutpriceorbrushsales;

    /**
     *  IsOtherExtension
     */
    private Integer isotherextension;

    /**
     *  CommunicateMeans
     */
    private String communicatemeans;

    /**
     *  CommunicateTime
     */
    private String communicatetime;

    /**
     *  CommunicateFrequency
     */
    private Double communicatefrequency;

    /**
     *  ExpectationValue
     */
    private String expectationvalue;

    /**
     *  ServiceFee
     */
    private Double servicefee;

    /**
     *  TechnologyWangwang
     */
    private String technologywangwang;

    /**
     *  TimeOut
     */
    private Date timeout;

    /**
     *  Remarks
     */
    private String remarks;

    /**
     *  IsHaveReNew
     */
    private Integer ishaverenew;

    /**
     *  ChildIndeutry
     */
    private Integer childindeutry;

    /**
     *  StoreWangWang
     */
    private String storewangwang;

    /**
     *  ChildIndeutryName
     */
    private String childindeutryname;

    /**
     *  IndeutryImg
     */
    private String indeutryimg;

    /**
     *  CustType
     */
    private Integer custtype;

    /**
     *  ChildType
     */
    private Integer childtype;

    /**
     *  IsSEM
     */
    private Integer issem;

    /**
     *  CustomerTechnology
     */
    private Integer customertechnology;

    /**
     *  IsShowInReport
     */
    private Integer isshowinreport;

    /**
     *  TSrecruitmentId
     */
    private Integer tsrecruitmentid;

    /**
     *  TechnologyRecruitmentID
     */
    private Integer technologyrecruitmentid;

    /**
     *  ZtcOpTime
     */
    private Date ztcoptime;

    /**
     *  LastServerDeadlineEndWhenPaurse
     */
    private Date lastserverdeadlineendwhenpaurse;

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
     * @return WangWangNum 
     */
    public String getWangwangnum() {
        return wangwangnum;
    }

    /**
     * 
     * @author simon
     * @param wangwangnum 
     */
    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum == null ? null : wangwangnum.trim();
    }

    /**
     * 
     * @author simon
     * @return ServerName 
     */
    public String getServername() {
        return servername;
    }

    /**
     * 
     * @author simon
     * @param servername 
     */
    public void setServername(String servername) {
        this.servername = servername == null ? null : servername.trim();
    }

    /**
     * 
     * @author simon
     * @return ServerDeadline 
     */
    public String getServerdeadline() {
        return serverdeadline;
    }

    /**
     * 
     * @author simon
     * @param serverdeadline 
     */
    public void setServerdeadline(String serverdeadline) {
        this.serverdeadline = serverdeadline == null ? null : serverdeadline.trim();
    }

    /**
     * 
     * @author simon
     * @return Indeutry 
     */
    public String getIndeutry() {
        return indeutry;
    }

    /**
     * 
     * @author simon
     * @param indeutry 
     */
    public void setIndeutry(String indeutry) {
        this.indeutry = indeutry == null ? null : indeutry.trim();
    }

    /**
     * 
     * @author simon
     * @return ShoppType 
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
     * @return ShoppRank 
     */
    public String getShopprank() {
        return shopprank;
    }

    /**
     * 
     * @author simon
     * @param shopprank 
     */
    public void setShopprank(String shopprank) {
        this.shopprank = shopprank == null ? null : shopprank.trim();
    }

    /**
     * 
     * @author simon
     * @return ShoppAddress 
     */
    public String getShoppaddress() {
        return shoppaddress;
    }

    /**
     * 
     * @author simon
     * @param shoppaddress 
     */
    public void setShoppaddress(String shoppaddress) {
        this.shoppaddress = shoppaddress == null ? null : shoppaddress.trim();
    }

    /**
     * 
     * @author simon
     * @return Name 
     */
    public String getName() {
        return name;
    }

    /**
     * 
     * @author simon
     * @param name 
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 
     * @author simon
     * @return Phone 
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 
     * @author simon
     * @param phone 
     */
    public void setPhone(String phone) {
        this.phone = phone == null ? null : phone.trim();
    }

    /**
     * 
     * @author simon
     * @return ContactAddress 
     */
    public String getContactaddress() {
        return contactaddress;
    }

    /**
     * 
     * @author simon
     * @param contactaddress 
     */
    public void setContactaddress(String contactaddress) {
        this.contactaddress = contactaddress == null ? null : contactaddress.trim();
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
     * @return OddNumbers 
     */
    public String getOddnumbers() {
        return oddnumbers;
    }

    /**
     * 
     * @author simon
     * @param oddnumbers 
     */
    public void setOddnumbers(String oddnumbers) {
        this.oddnumbers = oddnumbers == null ? null : oddnumbers.trim();
    }

    /**
     * 
     * @author simon
     * @return Chat 
     */
    public String getChat() {
        return chat;
    }

    /**
     * 
     * @author simon
     * @param chat 
     */
    public void setChat(String chat) {
        this.chat = chat == null ? null : chat.trim();
    }

    /**
     * 
     * @author simon
     * @return flag 
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
     * @return AddTime 
     */
    public Date getAddtime() {
        return addtime;
    }

    /**
     * 
     * @author simon
     * @param addtime 
     */
    public void setAddtime(Date addtime) {
        this.addtime = addtime;
    }

    /**
     * 
     * @author simon
     * @return ServerDeadlineEnd 
     */
    public String getServerdeadlineend() {
        return serverdeadlineend;
    }

    /**
     * 
     * @author simon
     * @param serverdeadlineend 
     */
    public void setServerdeadlineend(String serverdeadlineend) {
        this.serverdeadlineend = serverdeadlineend == null ? null : serverdeadlineend.trim();
    }

    /**
     * 
     * @author simon
     * @return TScustomer 
     */
    public String getTscustomer() {
        return tscustomer;
    }

    /**
     * 
     * @author simon
     * @param tscustomer 
     */
    public void setTscustomer(String tscustomer) {
        this.tscustomer = tscustomer == null ? null : tscustomer.trim();
    }

    /**
     * 
     * @author simon
     * @return State 
     */
    public Integer getState() {
        return state;
    }

    /**
     * 
     * @author simon
     * @param state 
     */
    public void setState(Integer state) {
        this.state = state;
    }

    /**
     * 
     * @author simon
     * @return WorkRecordState 
     */
    public Integer getWorkrecordstate() {
        return workrecordstate;
    }

    /**
     * 
     * @author simon
     * @param workrecordstate 
     */
    public void setWorkrecordstate(Integer workrecordstate) {
        this.workrecordstate = workrecordstate;
    }

    /**
     * 
     * @author simon
     * @return IsComplained 
     */
    public Integer getIscomplained() {
        return iscomplained;
    }

    /**
     * 
     * @author simon
     * @param iscomplained 
     */
    public void setIscomplained(Integer iscomplained) {
        this.iscomplained = iscomplained;
    }

    /**
     * 
     * @author simon
     * @return SendReportTime 
     */
    public Date getSendreporttime() {
        return sendreporttime;
    }

    /**
     * 
     * @author simon
     * @param sendreporttime 
     */
    public void setSendreporttime(Date sendreporttime) {
        this.sendreporttime = sendreporttime;
    }

    /**
     * 
     * @author simon
     * @return WriteMethodTime 
     */
    public Date getWritemethodtime() {
        return writemethodtime;
    }

    /**
     * 
     * @author simon
     * @param writemethodtime 
     */
    public void setWritemethodtime(Date writemethodtime) {
        this.writemethodtime = writemethodtime;
    }

    /**
     * 
     * @author simon
     * @return LinkedTime 
     */
    public Date getLinkedtime() {
        return linkedtime;
    }

    /**
     * 
     * @author simon
     * @param linkedtime 
     */
    public void setLinkedtime(Date linkedtime) {
        this.linkedtime = linkedtime;
    }

    /**
     * 
     * @author simon
     * @return QuantumAccounts 
     */
    public String getQuantumaccounts() {
        return quantumaccounts;
    }

    /**
     * 
     * @author simon
     * @param quantumaccounts 
     */
    public void setQuantumaccounts(String quantumaccounts) {
        this.quantumaccounts = quantumaccounts == null ? null : quantumaccounts.trim();
    }

    /**
     * 
     * @author simon
     * @return QuantumCryptography 
     */
    public String getQuantumcryptography() {
        return quantumcryptography;
    }

    /**
     * 
     * @author simon
     * @param quantumcryptography 
     */
    public void setQuantumcryptography(String quantumcryptography) {
        this.quantumcryptography = quantumcryptography == null ? null : quantumcryptography.trim();
    }

    /**
     * 
     * @author simon
     * @return PurchaseChannels 
     */
    public String getPurchasechannels() {
        return purchasechannels;
    }

    /**
     * 
     * @author simon
     * @param purchasechannels 
     */
    public void setPurchasechannels(String purchasechannels) {
        this.purchasechannels = purchasechannels == null ? null : purchasechannels.trim();
    }

    /**
     * 
     * @author simon
     * @return IsCutPriceOrBrushSales 
     */
    public Integer getIscutpriceorbrushsales() {
        return iscutpriceorbrushsales;
    }

    /**
     * 
     * @author simon
     * @param iscutpriceorbrushsales 
     */
    public void setIscutpriceorbrushsales(Integer iscutpriceorbrushsales) {
        this.iscutpriceorbrushsales = iscutpriceorbrushsales;
    }

    /**
     * 
     * @author simon
     * @return IsOtherExtension 
     */
    public Integer getIsotherextension() {
        return isotherextension;
    }

    /**
     * 
     * @author simon
     * @param isotherextension 
     */
    public void setIsotherextension(Integer isotherextension) {
        this.isotherextension = isotherextension;
    }

    /**
     * 
     * @author simon
     * @return CommunicateMeans 
     */
    public String getCommunicatemeans() {
        return communicatemeans;
    }

    /**
     * 
     * @author simon
     * @param communicatemeans 
     */
    public void setCommunicatemeans(String communicatemeans) {
        this.communicatemeans = communicatemeans == null ? null : communicatemeans.trim();
    }

    /**
     * 
     * @author simon
     * @return CommunicateTime 
     */
    public String getCommunicatetime() {
        return communicatetime;
    }

    /**
     * 
     * @author simon
     * @param communicatetime 
     */
    public void setCommunicatetime(String communicatetime) {
        this.communicatetime = communicatetime == null ? null : communicatetime.trim();
    }

    /**
     * 
     * @author simon
     * @return CommunicateFrequency 
     */
    public Double getCommunicatefrequency() {
        return communicatefrequency;
    }

    /**
     * 
     * @author simon
     * @param communicatefrequency 
     */
    public void setCommunicatefrequency(Double communicatefrequency) {
        this.communicatefrequency = communicatefrequency;
    }

    /**
     * 
     * @author simon
     * @return ExpectationValue 
     */
    public String getExpectationvalue() {
        return expectationvalue;
    }

    /**
     * 
     * @author simon
     * @param expectationvalue 
     */
    public void setExpectationvalue(String expectationvalue) {
        this.expectationvalue = expectationvalue == null ? null : expectationvalue.trim();
    }

    /**
     * 
     * @author simon
     * @return ServiceFee 
     */
    public Double getServicefee() {
        return servicefee;
    }

    /**
     * 
     * @author simon
     * @param servicefee 
     */
    public void setServicefee(Double servicefee) {
        this.servicefee = servicefee;
    }

    /**
     * 
     * @author simon
     * @return TechnologyWangwang 
     */
    public String getTechnologywangwang() {
        return technologywangwang;
    }

    /**
     * 
     * @author simon
     * @param technologywangwang 
     */
    public void setTechnologywangwang(String technologywangwang) {
        this.technologywangwang = technologywangwang == null ? null : technologywangwang.trim();
    }

    /**
     * 
     * @author simon
     * @return TimeOut 
     */
    public Date getTimeout() {
        return timeout;
    }

    /**
     * 
     * @author simon
     * @param timeout 
     */
    public void setTimeout(Date timeout) {
        this.timeout = timeout;
    }

    /**
     * 
     * @author simon
     * @return Remarks 
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 
     * @author simon
     * @param remarks 
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks == null ? null : remarks.trim();
    }

    /**
     * 
     * @author simon
     * @return IsHaveReNew 
     */
    public Integer getIshaverenew() {
        return ishaverenew;
    }

    /**
     * 
     * @author simon
     * @param ishaverenew 
     */
    public void setIshaverenew(Integer ishaverenew) {
        this.ishaverenew = ishaverenew;
    }

    /**
     * 
     * @author simon
     * @return ChildIndeutry 
     */
    public Integer getChildindeutry() {
        return childindeutry;
    }

    /**
     * 
     * @author simon
     * @param childindeutry 
     */
    public void setChildindeutry(Integer childindeutry) {
        this.childindeutry = childindeutry;
    }

    /**
     * 
     * @author simon
     * @return StoreWangWang 
     */
    public String getStorewangwang() {
        return storewangwang;
    }

    /**
     * 
     * @author simon
     * @param storewangwang 
     */
    public void setStorewangwang(String storewangwang) {
        this.storewangwang = storewangwang == null ? null : storewangwang.trim();
    }

    /**
     * 
     * @author simon
     * @return ChildIndeutryName 
     */
    public String getChildindeutryname() {
        return childindeutryname;
    }

    /**
     * 
     * @author simon
     * @param childindeutryname 
     */
    public void setChildindeutryname(String childindeutryname) {
        this.childindeutryname = childindeutryname == null ? null : childindeutryname.trim();
    }

    /**
     * 
     * @author simon
     * @return IndeutryImg 
     */
    public String getIndeutryimg() {
        return indeutryimg;
    }

    /**
     * 
     * @author simon
     * @param indeutryimg 
     */
    public void setIndeutryimg(String indeutryimg) {
        this.indeutryimg = indeutryimg == null ? null : indeutryimg.trim();
    }

    /**
     * 
     * @author simon
     * @return CustType 
     */
    public Integer getCusttype() {
        return custtype;
    }

    /**
     * 
     * @author simon
     * @param custtype 
     */
    public void setCusttype(Integer custtype) {
        this.custtype = custtype;
    }

    /**
     * 
     * @author simon
     * @return ChildType 
     */
    public Integer getChildtype() {
        return childtype;
    }

    /**
     * 
     * @author simon
     * @param childtype 
     */
    public void setChildtype(Integer childtype) {
        this.childtype = childtype;
    }

    /**
     * 
     * @author simon
     * @return IsSEM 
     */
    public Integer getIssem() {
        return issem;
    }

    /**
     * 
     * @author simon
     * @param issem 
     */
    public void setIssem(Integer issem) {
        this.issem = issem;
    }

    /**
     * 
     * @author simon
     * @return CustomerTechnology 
     */
    public Integer getCustomertechnology() {
        return customertechnology;
    }

    /**
     * 
     * @author simon
     * @param customertechnology 
     */
    public void setCustomertechnology(Integer customertechnology) {
        this.customertechnology = customertechnology;
    }

    /**
     * 
     * @author simon
     * @return IsShowInReport 
     */
    public Integer getIsshowinreport() {
        return isshowinreport;
    }

    /**
     * 
     * @author simon
     * @param isshowinreport 
     */
    public void setIsshowinreport(Integer isshowinreport) {
        this.isshowinreport = isshowinreport;
    }

    /**
     * 
     * @author simon
     * @return TSrecruitmentId 
     */
    public Integer getTsrecruitmentid() {
        return tsrecruitmentid;
    }

    /**
     * 
     * @author simon
     * @param tsrecruitmentid 
     */
    public void setTsrecruitmentid(Integer tsrecruitmentid) {
        this.tsrecruitmentid = tsrecruitmentid;
    }

    /**
     * 
     * @author simon
     * @return TechnologyRecruitmentID 
     */
    public Integer getTechnologyrecruitmentid() {
        return technologyrecruitmentid;
    }

    /**
     * 
     * @author simon
     * @param technologyrecruitmentid 
     */
    public void setTechnologyrecruitmentid(Integer technologyrecruitmentid) {
        this.technologyrecruitmentid = technologyrecruitmentid;
    }

    /**
     * 
     * @author simon
     * @return ZtcOpTime 
     */
    public Date getZtcoptime() {
        return ztcoptime;
    }

    /**
     * 
     * @author simon
     * @param ztcoptime 
     */
    public void setZtcoptime(Date ztcoptime) {
        this.ztcoptime = ztcoptime;
    }

    /**
     * 
     * @author simon
     * @return LastServerDeadlineEndWhenPaurse 
     */
    public Date getLastserverdeadlineendwhenpaurse() {
        return lastserverdeadlineendwhenpaurse;
    }

    /**
     * 
     * @author simon
     * @param lastserverdeadlineendwhenpaurse 
     */
    public void setLastserverdeadlineendwhenpaurse(Date lastserverdeadlineendwhenpaurse) {
        this.lastserverdeadlineendwhenpaurse = lastserverdeadlineendwhenpaurse;
    }

    /**
     *
     * @mbg.generated 2019-07-18 14:51:00
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", wangwangnum=").append(wangwangnum);
        sb.append(", servername=").append(servername);
        sb.append(", serverdeadline=").append(serverdeadline);
        sb.append(", indeutry=").append(indeutry);
        sb.append(", shopptype=").append(shopptype);
        sb.append(", shopprank=").append(shopprank);
        sb.append(", shoppaddress=").append(shoppaddress);
        sb.append(", name=").append(name);
        sb.append(", phone=").append(phone);
        sb.append(", contactaddress=").append(contactaddress);
        sb.append(", place=").append(place);
        sb.append(", oddnumbers=").append(oddnumbers);
        sb.append(", chat=").append(chat);
        sb.append(", flag=").append(flag);
        sb.append(", addtime=").append(addtime);
        sb.append(", serverdeadlineend=").append(serverdeadlineend);
        sb.append(", tscustomer=").append(tscustomer);
        sb.append(", state=").append(state);
        sb.append(", workrecordstate=").append(workrecordstate);
        sb.append(", iscomplained=").append(iscomplained);
        sb.append(", sendreporttime=").append(sendreporttime);
        sb.append(", writemethodtime=").append(writemethodtime);
        sb.append(", linkedtime=").append(linkedtime);
        sb.append(", quantumaccounts=").append(quantumaccounts);
        sb.append(", quantumcryptography=").append(quantumcryptography);
        sb.append(", purchasechannels=").append(purchasechannels);
        sb.append(", iscutpriceorbrushsales=").append(iscutpriceorbrushsales);
        sb.append(", isotherextension=").append(isotherextension);
        sb.append(", communicatemeans=").append(communicatemeans);
        sb.append(", communicatetime=").append(communicatetime);
        sb.append(", communicatefrequency=").append(communicatefrequency);
        sb.append(", expectationvalue=").append(expectationvalue);
        sb.append(", servicefee=").append(servicefee);
        sb.append(", technologywangwang=").append(technologywangwang);
        sb.append(", timeout=").append(timeout);
        sb.append(", remarks=").append(remarks);
        sb.append(", ishaverenew=").append(ishaverenew);
        sb.append(", childindeutry=").append(childindeutry);
        sb.append(", storewangwang=").append(storewangwang);
        sb.append(", childindeutryname=").append(childindeutryname);
        sb.append(", indeutryimg=").append(indeutryimg);
        sb.append(", custtype=").append(custtype);
        sb.append(", childtype=").append(childtype);
        sb.append(", issem=").append(issem);
        sb.append(", customertechnology=").append(customertechnology);
        sb.append(", isshowinreport=").append(isshowinreport);
        sb.append(", tsrecruitmentid=").append(tsrecruitmentid);
        sb.append(", technologyrecruitmentid=").append(technologyrecruitmentid);
        sb.append(", ztcoptime=").append(ztcoptime);
        sb.append(", lastserverdeadlineendwhenpaurse=").append(lastserverdeadlineendwhenpaurse);
        sb.append("]");
        return sb.toString();
    }
}