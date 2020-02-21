package com.sxau.cs.file.provider.model.request;

public class FileListRequest extends BaseUserRequest{

    private static final long serialVersionUID = 8378117663166128501L;

    /**
     * 文件id
     */
    private long fid;

    public long getFid() {
        return fid;
    }

    public void setFid(long fid) {
        this.fid = fid;
    }
}
