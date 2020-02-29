package com.sxau.cs.file.man.common.model.request;


import java.io.Serializable;

public class UserLoginRequest implements Serializable {
    private static final long serialVersionUID = 4127855192038253849L;

    private String name;

    private String password;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
