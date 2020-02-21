package com.sxau.cs.file.provider.model.response;

import java.io.Serializable;

/**
 * 基础响应
 *
 * @param <T>
 */
public class BaseResponse<T> implements Serializable {

    private static final long serialVersionUID = 4598988590912065729L;
    /**
     * 状态信息 -OK
     */
    private String stat;

    /**
     * 文件信息
     */
    private T fileInfo;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    public T getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(T fileInfo) {
        this.fileInfo = fileInfo;
    }
}
