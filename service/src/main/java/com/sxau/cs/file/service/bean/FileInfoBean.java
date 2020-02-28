package com.sxau.cs.file.service.bean;

import java.io.Serializable;

public class FileInfoBean implements Serializable {

    private static final long serialVersionUID = 9062386212980404478L;
    /**
     * 文件id
     */
    private long fileId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 文件大小
     */
    private long size;

    /**
     * 文件路径
     */
    private String path;

    /**
     * 创建者
     */
    private String creator;

    /**
     * 最后修改者
     */
    private String editor;

    /**
     * 创建时间
     */
    private long createTime;

    /**
     * 修改时间
     */
    private long modifyTime;

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

    public long getFileId() {
        return fileId;
    }

    public void setFileId(long fileId) {
        this.fileId = fileId;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getCreateTime() {
        return createTime;
    }

    public void setCreateTime(long createTime) {
        this.createTime = createTime;
    }

    public long getModifyTime() {
        return modifyTime;
    }

    public void setModifyTime(long modifyTime) {
        this.modifyTime = modifyTime;
    }
}
