package com.sxau.cs.file.provide.impl;

import com.sxau.cs.file.provide.RestController;

public class RestControllerImpl implements RestController {

    @Override
    public String nameLogin(String json) {
        return json;
    }

    @Override
    public String logout(String json) {
        return json;
    }

    @Override
    public String download(String json) {
        return null;
    }

    @Override
    public String upload(String json) {
        return null;
    }
}
