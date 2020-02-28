package com.sxau.cs.file.provider.model.response;

/**
 * 基础响应
 */
public class FileInfoResponse extends BaseResponse {

    private static final long serialVersionUID = 4598988590912065729L;

    /**
     * 文件信息
     */
    private FileInfo fileInfo;

    public FileInfo getFileInfo() {
        return fileInfo;
    }

    public void setFileInfo(FileInfo fileInfo) {
        this.fileInfo = fileInfo;
    }
}
