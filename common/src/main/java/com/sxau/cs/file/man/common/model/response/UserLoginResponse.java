package com.sxau.cs.file.man.common.model.response;

import java.io.Serializable;

public class UserLoginResponse implements Serializable {
    private static final long serialVersionUID = 8156218350576711168L;
    String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }

    String token;

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
