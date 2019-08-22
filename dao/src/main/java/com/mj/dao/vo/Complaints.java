package com.mj.dao.vo;

public class Complaints {
    /**
     * 客诉类别 level
     */
    private Integer level;
    //客诉类别名
    private String levelName;

    public Integer getLevel() {
        return level;
    }

    public void setLevel(Integer level) {
        this.level = level;
    }

    public String getLevelName() {
        return levelName;
    }

    public void setLevelName(String levelName) {
        this.levelName = levelName;
    }
}
