package com.mj.dao.entity;

import java.util.Date;

public class Lose {
    /**
     * 主键，流失表 pk_id
     */
    private Integer pkId;

    /**
     * 旺旺名 wang_wang_num
     */
    private String wangWangNum;

    /**
     * 回访时间 revisit_date
     */
    private Date revisitDate;

    /**
     * 满意度：1：满意  2：不满意 satisfaction
     */
    private Integer satisfaction;

    /**
     * 备注 remark
     */
    private String remark;

    /**
     * 判责，与判责表客诉类别关联 level
     */
    private Integer level;

    /**
     * 是否删除，0：显示  1：删除 is_delete
     */
    private Integer isDelete;

    /**
     * 状态：0、未审核 1、已审核 2、待审定 3、已完结 status
     */
    private Integer status;

    /**
     * 改进意见
     * improvement
     */
    private String improvement;

    /**
     * 主键，流失表
     *
     * @return pk_id 主键，流失表
     * @author Administrator
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键，流失表
     *
     * @param pkId 主键，流失表
     * @author Administrator
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 旺旺名
     *
     * @return wang_wang_num 旺旺名
     * @author Administrator
     */
    public String getWangWangNum() {
        return wangWangNum;
    }

    /**
     * 旺旺名
     *
     * @param wangWangNum 旺旺名
     * @author Administrator
     */
    public void setWangWangNum(String wangWangNum) {
        this.wangWangNum = wangWangNum == null ? null : wangWangNum.trim();
    }

    /**
     * 回访时间
     *
     * @return revisit_date 回访时间
     * @author Administrator
     */
    public Date getRevisitDate() {
        return revisitDate;
    }

    /**
     * 回访时间
     *
     * @param revisitDate 回访时间
     * @author Administrator
     */
    public void setRevisitDate(Date revisitDate) {
        this.revisitDate = revisitDate;
    }

    /**
     * 满意度：1：满意  2：不满意
     *
     * @return satisfaction 满意度：1：满意  2：不满意
     * @author Administrator
     */
    public Integer getSatisfaction() {
        return satisfaction;
    }

    /**
     * 满意度：1：满意  2：不满意
     *
     * @param satisfaction 满意度：1：满意  2：不满意
     * @author Administrator
     */
    public void setSatisfaction(Integer satisfaction) {
        this.satisfaction = satisfaction;
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
     * 判责，与判责表客诉类别关联
     *
     * @return level 判责，与判责表客诉类别关联
     * @author Administrator
     */
    public Integer getLevel() {
        return level;
    }

    /**
     * 判责，与判责表客诉类别关联
     *
     * @param level 判责，与判责表客诉类别关联
     * @author Administrator
     */
    public void setLevel(Integer level) {
        this.level = level;
    }

    /**
     * 是否删除，0：显示  1：删除
     *
     * @return is_delete 是否删除，0：显示  1：删除
     * @author Administrator
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除，0：显示  1：删除
     *
     * @param isDelete 是否删除，0：显示  1：删除
     * @author Administrator
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 状态：0、未审核 1、已审核 2、待审定 3、已完结
     *
     * @return status 状态：0、未审核 1、已审核 2、待审定 3、已完结
     * @author Administrator
     */
    public Integer getStatus() {
        return status;
    }

    /**
     * 状态：0、未审核 1、已审核 2、待审定 3、已完结
     *
     * @param status 状态：0、未审核 1、已审核 2、待审定 3、已完结
     * @author Administrator
     */
    public void setStatus(Integer status) {
        this.status = status;
    }

    /**
     * 改进意见
     *
     * @return improvement 改进意见
     * @author Administrator
     */
    public String getImprovement() {
        return improvement;
    }

    /**
     * 改进意见
     *
     * @param improvement 改进意见
     * @author Administrator
     */
    public void setImprovement(String improvement) {
        this.improvement = improvement == null ? null : improvement.trim();
    }

    /**
     * @mbg.generated 2019-08-29 18:57:22
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", wangWangNum=").append(wangWangNum);
        sb.append(", revisitDate=").append(revisitDate);
        sb.append(", satisfaction=").append(satisfaction);
        sb.append(", remark=").append(remark);
        sb.append(", level=").append(level);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", status=").append(status);
        sb.append(", improvement=").append(improvement);
        sb.append("]");
        return sb.toString();
    }
}