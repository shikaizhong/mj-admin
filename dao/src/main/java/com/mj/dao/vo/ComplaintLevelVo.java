package com.mj.dao.vo;

public class ComplaintLevelVo {
    /**
     * 客诉类别主键id pk_id
     */
    private Integer complaintIds;
    /**
     * 客诉类别大类id: parent_id
     */
    private Integer parentId;

    /**
     * 客诉类别名 complaint_name
     */
    private String complaintName;

    public Integer getComplaintIds() {
        return complaintIds;
    }

    public void setComplaintIds(Integer complaintIds) {
        this.complaintIds = complaintIds;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public String getComplaintName() {
        return complaintName;
    }

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }
}
