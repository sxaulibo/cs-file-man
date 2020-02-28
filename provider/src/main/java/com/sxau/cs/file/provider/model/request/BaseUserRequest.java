package com.sxau.cs.file.provider.model.request;

import java.io.Serializable;

/**
 * 基础用户请求
 */
public class BaseUserRequest implements Serializable {
    private static final long serialVersionUID = 7442041819965343513L;

    /**
     * 密令
     */
    private String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
