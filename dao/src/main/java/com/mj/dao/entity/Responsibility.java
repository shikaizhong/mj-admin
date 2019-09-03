package com.mj.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

public class Responsibility {
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
    private Integer sonLevel;

    /**
     * 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责 result
     */
    private Integer result;

    /**
     * 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手 responsibilityer
     */
    private Integer responsibilityer;

    /**
     * 顾客id(连接顾客表的ID) customer_id
     */
    private Integer customerId;

    /**
     * 客诉级别: 0:一级,1:二级,2:三级 grade
     */
    private Integer grade;

    /**
     * 判责日期 create_time
     */
    @JsonFormat(pattern="yyyy-MM-dd'T'HH:mm:ss.SSS")
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
     * 主键id
     * @author Administrator
     * @return pk_id 主键id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键id
     * @author Administrator
     * @param pkId 主键id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 客诉大类别 对应complaint_level的parent_id
     * @author Administrator
     * @return level 客诉大类别 对应complaint_level的parent_id
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 客诉大类别 对应complaint_level的parent_id
     * @author Administrator
     * @param level 客诉大类别 对应complaint_level的parent_id
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    public Integer getSonLevel() {
        return sonLevel;
    }

    public void setSonLevel(Integer sonLevel) {
        this.sonLevel = sonLevel;
    }

    /**
     * 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责
     * @author Administrator
     * @return result 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责
     */
    public Integer getResult() {
        return result;
    }

    /**
     * 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责
     * @author Administrator
     * @param result 判责结果:0:微责  1:无责  2:待定 3:轻责 4:中责 5:重责
     */
    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     * 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手
     * @author Administrator
     * @return responsibilityer 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手
     */
    public Integer getResponsibilityer() {
        return responsibilityer;
    }

    /**
     * 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手
     * @author Administrator
     * @param responsibilityer 责任人: 0:店长,1:车手,2:招商,3:美工,4:无责人,5:店长,6:车手
     */
    public void setResponsibilityer(Integer responsibilityer) {
        this.responsibilityer = responsibilityer;
    }

    /**
     * 顾客id(连接顾客表的ID)
     * @author Administrator
     * @return customer_id 顾客id(连接顾客表的ID)
     */
    public Integer getCustomerId() {
        return customerId;
    }

    /**
     * 顾客id(连接顾客表的ID)
     * @author Administrator
     * @param customerId 顾客id(连接顾客表的ID)
     */
    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    /**
     * 客诉级别: 0:一级,1:二级,2:三级
     * @author Administrator
     * @return grade 客诉级别: 0:一级,1:二级,2:三级
     */
    public Integer getGrade() {
        return grade;
    }

    /**
     * 客诉级别: 0:一级,1:二级,2:三级
     * @author Administrator
     * @param grade 客诉级别: 0:一级,1:二级,2:三级
     */
    public void setGrade(Integer grade) {
        this.grade = grade;
    }

    /**
     * 判责日期
     * @author Administrator
     * @return create_time 判责日期
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 判责日期
     * @author Administrator
     * @param createTime 判责日期
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 判责人员id:对应personnel的id
     * @author Administrator
     * @return responsibilityor 判责人员id:对应personnel的id
     */
    public Integer getResponsibilityor() {
        return responsibilityor;
    }

    /**
     * 判责人员id:对应personnel的id
     * @author Administrator
     * @param responsibilityor 判责人员id:对应personnel的id
     */
    public void setResponsibilityor(Integer responsibilityor) {
        this.responsibilityor = responsibilityor;
    }

    /**
     * 投诉id
     * @author Administrator
     * @return complaint_id 投诉id
     */
    public Integer getComplaintId() {
        return complaintId;
    }

    /**
     * 投诉id
     * @author Administrator
     * @param complaintId 投诉id
     */
    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    /**
     * 判责类型 0:投诉,1:判责,2:退款
     * @author Administrator
     * @return type 判责类型 0:投诉,1:判责,2:退款
     */
    public Integer getType() {
        return type;
    }

    /**
     * 判责类型 0:投诉,1:判责,2:退款
     * @author Administrator
     * @param type 判责类型 0:投诉,1:判责,2:退款
     */
    public void setType(Integer type) {
        this.type = type;
    }

    /**
     *
     * @mbg.generated 2019-08-29 10:17:48
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", level=").append(level);
        sb.append(", result=").append(result);
        sb.append(", responsibilityer=").append(responsibilityer);
        sb.append(", customerId=").append(customerId);
        sb.append(", grade=").append(grade);
        sb.append(", createTime=").append(createTime);
        sb.append(", responsibilityor=").append(responsibilityor);
        sb.append(", complaintId=").append(complaintId);
        sb.append(", type=").append(type);
        sb.append("]");
        return sb.toString();
    }
}