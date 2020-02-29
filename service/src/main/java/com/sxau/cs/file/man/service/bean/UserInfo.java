package com.sxau.cs.file.man.service.bean;

public class UserInfo {
    private String name;
    private String password;
    private String rootFid;
    private String token;

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

    public String getRootFid() {
        return rootFid;
    }

    public void setRootFid(String rootFid) {
        this.rootFid = rootFid;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }
}
