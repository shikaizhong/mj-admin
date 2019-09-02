package com.mj.dao.entity;

public class Files {
    /**
     * 主键id pk_id
     */
    private Integer pkId;

    /**
     * 文件路径 url
     */
    private String url;

    /**
     * 文件名 name
     */
    private String name;

    /**
     * 退款id complaint_id
     */
    private Integer complaintId;

    //文件类型
    private Integer fileType;
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
     * 文件路径
     * @author Administrator
     * @return url 文件路径
     */
    public String getUrl() {
        return url;
    }

    /**
     * 文件路径
     * @author Administrator
     * @param url 文件路径
     */
    public void setUrl(String url) {
        this.url = url == null ? null : url.trim();
    }

    /**
     * 文件名
     * @author Administrator
     * @return name 文件名
     */
    public String getName() {
        return name;
    }

    /**
     * 文件名
     * @author Administrator
     * @param name 文件名
     */
    public void setName(String name) {
        this.name = name == null ? null : name.trim();
    }

    /**
     * 退款id
     * @author Administrator
     * @return complaint_id 退款id
     */
    public Integer getComplaintId() {
        return complaintId;
    }

    /**
     * 退款id
     * @author Administrator
     * @param complaintId 退款id
     */
    public void setComplaintId(Integer complaintId) {
        this.complaintId = complaintId;
    }

    public Integer getFileType() {
        return fileType;
    }

    public void setFileType(Integer fileType) {
        this.fileType = fileType;
    }

    /**
     *
     * @mbg.generated 2019-08-15 11:16:59
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", url=").append(url);
        sb.append(", name=").append(name);
        sb.append(", complaintId=").append(complaintId);
        sb.append("]");
        return sb.toString();
    }
}