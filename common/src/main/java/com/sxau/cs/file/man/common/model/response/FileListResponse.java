package com.sxau.cs.file.man.common.model.response;

import java.util.List;

/**
 * 文件列表类
 */
public class FileListResponse extends BaseResponse {
    private static final long serialVersionUID = 4906461972501688982L;

    /**
     * 文件列
     */
    private List<FileInfo> rows;

    public List<FileInfo> getRows() {
        return rows;
    }

    public void setRows(List<FileInfo> rows) {
        this.rows = rows;
    }
}
