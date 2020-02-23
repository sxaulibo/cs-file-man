package com.sxau.cs.file.service.bean;

public class FileInfo {
    /**
     * 姓名
     */
    private String name;
    /**
     * 创建者
     */
    private String creator;
    /**
     * 最后修改者
     */
    private String editor;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCreator() {
        return creator;
    }

    public void setCreator(String creator) {
        this.creator = creator;
    }

    public String getEditor() {
        return editor;
    }

    public void setEditor(String editor) {
        this.editor = editor;
    }
}
