package com.sxau.cs.file.man.common.model.request;

public class FileCreateRequest extends BaseUserRequest {

    private static final long serialVersionUID = -224430073848615222L;

    /**
     * 父文件夹id
     */
    private String parent;

    /**
     * 被创建文件的名称
     */
    private String name;

    public String getParent() {
        return parent;
    }

    public void setParent(String parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
