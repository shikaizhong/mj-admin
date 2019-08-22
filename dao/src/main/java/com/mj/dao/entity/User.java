package com.mj.dao.entity;

public class User {
    /**
     * 主键id pk_id
     */
    private Integer pkId;

    /**
     * 用户名 user_name
     */
    private String userName;

    /**
     * 用户类型 shopp_type
     */
    private String shoppType;

    /**
     * 主键id
     * @author simon
     * @return pk_id 主键id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 主键id
     * @author simon
     * @param pkId 主键id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 用户名
     * @author simon
     * @return user_name 用户名
     */
    public String getUserName() {
        return userName;
    }

    /**
     * 用户名
     * @author simon
     * @param userName 用户名
     */
    public void setUserName(String userName) {
        this.userName = userName == null ? null : userName.trim();
    }

    /**
     * 用户类型
     * @author simon
     * @return shopp_type 用户类型
     */
    public String getShoppType() {
        return shoppType;
    }

    /**
     * 用户类型
     * @author simon
     * @param shoppType 用户类型
     */
    public void setShoppType(String shoppType) {
        this.shoppType = shoppType == null ? null : shoppType.trim();
    }

    /**
     *
     * @mbg.generated 2019-07-15 11:55:41
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", userName=").append(userName);
        sb.append(", shoppType=").append(shoppType);
        sb.append("]");
        return sb.toString();
    }
}