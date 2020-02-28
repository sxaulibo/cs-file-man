package com.sxau.cs.file.man.common.model.request;

public class FileDownloadReq {
    private String fid;
    private String token;

    public String getFid() {
        return fid;
    }

    public void setFid(String fid) {
        this.fid = fid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
