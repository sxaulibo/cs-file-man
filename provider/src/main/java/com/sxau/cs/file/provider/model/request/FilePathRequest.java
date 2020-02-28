package com.sxau.cs.file.provider.model.request;

/**
 * 文件(夹)全路径
 */
public class FilePathRequest extends BaseUserRequest {
    private static final long serialVersionUID = -1867743764689976830L;

    /**
     * 文件(夹)全路径
     */
    private String path;

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }
}
