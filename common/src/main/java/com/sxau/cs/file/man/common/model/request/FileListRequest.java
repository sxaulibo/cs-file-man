package com.sxau.cs.file.man.common.model.request;

/**
 * 文件列表请求
 */
public class FileListRequest extends BaseUserRequest{

    private static final long serialVersionUID = 8378117663166128501L;

    /**
     * 文件id
     */
    private Long fid;

    public Long getFid() {
        return fid;
    }

    public void setFid(Long fid) {
        this.fid = fid;
    }
}
