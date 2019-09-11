package com.mj.dao.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.util.Date;

//@JsonIgnoreProperties(ignoreUnknown = true)
public class Refund {
    /**
     * 主键 pk_id
     */
    private Integer pkId;

    /**
     * 投诉客户 WangWangNum
     */
    private String wangwangnum;

    /**
     * 退款日期 refund_date
     */
//    @DateTimeFormat(pattern = "yyyy-MM-dd HH:mm")
    @JsonFormat(locale = "zh",timezone="GMT+8", pattern="yyyy-MM-dd HH:mm")
//    @DateTimeFormat(pattern="yyyy-MM-dd HH:mm")
    private Date refundDate;

    /**
     * 获取前端的时间而新增的，数据库中并无该字段，Vo层中也没有该字段
     */
    private String hDate;

    private String refunddate;

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
     * 判责结果:0:微责  1:无责  2:重责 3:中责 4:轻责 5:待定 result
     */
    private Integer result;

    /**
     * 主键
     * @author Administrator
     * @return pk_id 主键
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键
     * @author Administrator
     * @param pkId 主键
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    public String getWangwangnum() {
        return wangwangnum;
    }

    public void setWangwangnum(String wangwangnum) {
        this.wangwangnum = wangwangnum;
    }

    /**
     * 退款日期
     * @author Administrator
     * @return refund_date 退款日期
     */
    public Date getRefundDate() {
        return refundDate;
    }

    /**
     * 退款日期
     * @author Administrator
     * @param refundDate 退款日期
     */
    public void setRefundDate(Date refundDate) {
        this.refundDate = refundDate;
    }

    /**
     * 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付
     * @author Administrator
     * @return refund_channel 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付
     */
    public Integer getRefundChannel() {
        return refundChannel;
    }

    /**
     * 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付
     * @author Administrator
     * @param refundChannel 退款渠道：1、SEM在线订购 2、支付宝转账 3、网银转账 4、定制市场订购 5、现金 6、POS机 7、京东在线订购 8、微信支付
     */
    public void setRefundChannel(Integer refundChannel) {
        this.refundChannel = refundChannel;
    }

    /**
     * 备注
     * @author Administrator
     * @return remark 备注
     */
    public String getRemark() {
        return remark;
    }

    /**
     * 备注
     * @author Administrator
     * @param remark 备注
     */
    public void setRemark(String remark) {
        this.remark = remark == null ? null : remark.trim();
    }

    /**
     * 退款金额
     * @author Administrator
     * @return refund_amount 退款金额
     */
    public Long getRefundAmount() {
        return refundAmount;
    }

    /**
     * 退款金额
     * @author Administrator
     * @param refundAmount 退款金额
     */
    public void setRefundAmount(Long refundAmount) {
        this.refundAmount = refundAmount;
    }

    /**
     * 删除：0、显示 1、删除
     * @author Administrator
     * @return is_delete 删除：0、显示 1、删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 删除：0、显示 1、删除
     * @author Administrator
     * @param isDelete 删除：0、显示 1、删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 退款原因
     * @author Administrator
     * @return refund_cause 退款原因
     */
    public String getRefundCause() {
        return refundCause;
    }

    /**
     * 退款原因
     * @author Administrator
     * @param refundCause 退款原因
     */
    public void setRefundCause(String refundCause) {
        this.refundCause = refundCause == null ? null : refundCause.trim();
    }

    public String getRefunddate() {
        return refunddate;
    }

    public void setRefunddate(String refunddate) {
        this.refunddate = refunddate;
    }

    public String gethDate() {
        return hDate;
    }

    public void sethDate(String hDate) {
        this.hDate = hDate;
    }

    public Integer getResult() {
        return result;
    }

    public void setResult(Integer result) {
        this.result = result;
    }

    /**
     *
     * @mbg.generated 2019-08-08 14:15:51
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", refundDate=").append(refundDate);
        sb.append(", refundChannel=").append(refundChannel);
        sb.append(", remark=").append(remark);
        sb.append(", refundAmount=").append(refundAmount);
        sb.append(", result=").append(result);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", refundCause=").append(refundCause);
        sb.append("]");
        return sb.toString();
    }
}