package com.sxau.cs.file.man.common.model.response;

import java.io.Serializable;

public class UserLogoutResp implements Serializable {

    private static final long serialVersionUID = 3839480150781896102L;
    private String stat;

    public String getStat() {
        return stat;
    }

    public void setStat(String stat) {
        this.stat = stat;
    }
}
