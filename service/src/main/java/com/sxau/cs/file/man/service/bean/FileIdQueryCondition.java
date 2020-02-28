package com.sxau.cs.file.man.service.bean;

public class FileIdQueryCondition {

    /**
     * 父文件id
     */
    private long parentId;

    /**
     * 文件名称
     */
    private String name;

    public long getParentId() {
        return parentId;
    }

    public void setParentId(long parentId) {
        this.parentId = parentId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
