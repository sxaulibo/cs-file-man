package com.sxau.cs.file.man.common.model.response;

import java.io.Serializable;

public class FileInfo implements Serializable {

    private static final long serialVersionUID = -8739941261469821012L;

    /**
     * 文件id
     */
    private long fid;

    /**
     * 父文件夹id
     */
    private Long parent;

    /**
     * 文件(夹)名称
     */
    private String name;

    /**
     * 文件大小
     */
    private long size;

    /**
     * 文件属性值  0 文件  1  非文件
     */
    private int attr;

    /**
     * 访问时间
     */
    private long c_atime;

    /**
     * 创建时间
     */
    private long c_ctime;

    /**
     * 修改时间
     */
    private long c_mtime;

    /**
     * 文件创建者(用户昵称)
     */
    private String creator;

    /**
     * 文件最后修改者(用户昵称)
     */
    private String editor;

    /**
     * 文件实际存储位置
     */
    private String path;

    /**
     * remote fileCode,需要在建表语句中进行设计
     */
    private String fileCode;

    public void setParent(Long parent) {
        this.parent = parent;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }

    public Long getParent() {
        return parent;
    }

    public void setParent(long parent) {
        this.parent = parent;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public long getSize() {
        return size;
    }

    public void setSize(long size) {
        this.size = size;
    }

    public int getAttr() {
        return attr;
    }

    public void setAttr(int attr) {
        this.attr = attr;
    }

    public long getC_atime() {
        return c_atime;
    }

    public void setC_atime(long c_atime) {
        this.c_atime = c_atime;
    }

    public long getC_ctime() {
        return c_ctime;
    }

    public void setC_ctime(long c_ctime) {
        this.c_ctime = c_ctime;
    }

    public long getC_mtime() {
        return c_mtime;
    }

    public void setC_mtime(long c_mtime) {
        this.c_mtime = c_mtime;
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

    public String getFileCode() {
        return fileCode;
    }

    public void setFileCode(String fileCode) {
        this.fileCode = fileCode;
    }
}
