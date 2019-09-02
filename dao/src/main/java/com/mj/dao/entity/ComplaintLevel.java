package com.mj.dao.entity;

import java.util.Date;

public class ComplaintLevel {
    /**
     * 客诉类别主键id pk_id
     */
    private Integer pkId;

    /**
     * 客诉类别大类id: parent_id
     */
    private Integer parentId;

    /**
     * 客诉类别名 complaint_name
     */
    private String complaintName;
    //客诉大类别名称parent_name
    private String parentName;

    /**
     * 是否删除改分类:  0:正常  1:删除 is_delete
     */
    private Integer isDelete;

    /**
     * 客诉类别创建时间 create_time
     */
    private Date createTime;

    /**
     * 客诉类别主键id
     * @author simon
     * @return pk_id 客诉类别主键id
     */
    public Integer getPkId() {
        return pkId;
    }

    /**
     * 客诉类别主键id
     * @author simon
     * @param pkId 客诉类别主键id
     */
    public void setPkId(Integer pkId) {
        this.pkId = pkId;
    }

    /**
     * 客诉类别大类id:
     * @author simon
     * @return parent_id 客诉类别大类id:
     */
    public Integer getParentId() {
        return parentId;
    }

    /**
     * 客诉类别大类id:
     * @author simon
     * @param parentId 客诉类别大类id:
     */
    public void setParentId(Integer parentId) {
        this.parentId = parentId;
    }

    /**
     * 客诉类别名
     * @author simon
     * @return complaint_name 客诉类别名
     */
    public String getComplaintName() {
        return complaintName;
    }

    /**
     * 客诉类别名
     * @author simon
     * @param complaintName 客诉类别名
     */
    public void setComplaintName(String complaintName) {
        this.complaintName = complaintName == null ? null : complaintName.trim();
    }
    /**
     * 是否删除改分类:  0:正常  1:删除
     * @author simon
     * @return is_delete 是否删除改分类:  0:正常  1:删除
     */
    public Integer getIsDelete() {
        return isDelete;
    }

    /**
     * 是否删除改分类:  0:正常  1:删除
     * @author simon
     * @param isDelete 是否删除改分类:  0:正常  1:删除
     */
    public void setIsDelete(Integer isDelete) {
        this.isDelete = isDelete;
    }

    /**
     * 客诉类别创建时间
     * @author simon
     * @return create_time 客诉类别创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 客诉类别创建时间
     * @author simon
     * @param createTime 客诉类别创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public String getParentName() {
        return parentName;
    }

    public void setParentName(String parentName) {
        this.parentName = parentName;
    }

    /**
     *
     * @mbg.generated 2019-07-19 10:22:46
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", pkId=").append(pkId);
        sb.append(", parentId=").append(parentId);
        sb.append(", complaintName=").append(complaintName);
        sb.append(", isDelete=").append(isDelete);
        sb.append(", createTime=").append(createTime);
        sb.append("]");
        return sb.toString();
    }
}