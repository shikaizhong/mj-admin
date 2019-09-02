package com.mj.dao.vo;

public class Complaints {
    /**
     * 客诉类别 level
     */
    private Integer level;
    //投诉大类别名称
    private String parentName;
    /**
     * 客诉类别大类id: parent_id
     */
    private Integer parentId;

    /**
     * 客诉小类别名 complaint_name
     */
    private String complaintName;

    public String getComplaintName() {
        return complaintName;
    }

    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName;
    }

    public Integer getParentId() {
        return parentId;
    }

    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }


    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }
}
