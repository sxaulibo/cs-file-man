package com.sxau.cs.file.provider.model.response;

import java.util.List;

public class FileListResponse extends BaseResponse{
    private static final long serialVersionUID = 4906461972501688982L;

    private List<FileInfo> rows;

    public List<FileInfo> getRows() {
        return rows;
    }

    public void setRows(List<FileInfo> rows) {
        this.rows = rows;
    }
}
