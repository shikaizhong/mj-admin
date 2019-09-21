package com.mj.dao.entity;

public class ResponsibilityWithBLOBs extends Responsibility {
    /**
     * 客诉点总结 summary
     */
    private String summary;

    private Integer aspId;

    /**
     * 判责依据文本 basic
     */
    private String basic;

    /**
     * 处理方案 deal
     */
    private String deal;

    /**
     * 客诉点总结
     * @author Administrator
     * @return summary 客诉点总结
     */
    public String getSummary() {
        return summary;
    }

    /**
     * 客诉点总结
     * @author Administrator
     * @param summary 客诉点总结
     */
    public void setSummary(String summary) {
        this.summary = summary == null ? null : summary.trim();
    }

    /**
     * 判责依据文本
     * @author Administrator
     * @return basic 判责依据文本
     */
    public String getBasic() {
        return basic;
    }

    /**
     * 判责依据文本
     * @author Administrator
     * @param basic 判责依据文本
     */
    public void setBasic(String basic) {
        this.basic = basic == null ? null : basic.trim();
    }

    /**
     * 处理方案
     * @author Administrator
     * @return deal 处理方案
     */
    public String getDeal() {
        return deal;
    }

    /**
     * 处理方案
     * @author Administrator
     * @param deal 处理方案
     */
    public void setDeal(String deal) {
        this.deal = deal == null ? null : deal.trim();
    }

    public Integer getAspId() {
        return aspId;
    }

    public void setAspId(Integer aspId) {
        this.aspId = aspId;
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
        sb.append(", summary=").append(summary);
        sb.append(", basic=").append(basic);
        sb.append(", deal=").append(deal);
        sb.append("]");
        return sb.toString();
    }
}