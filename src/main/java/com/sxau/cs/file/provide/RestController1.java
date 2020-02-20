package com.sxau.cs.file.provide;

import org.springframework.web.bind.annotation.RequestMapping;

public class RestController1 {

    @RequestMapping("/nameLogin")
    String nameLogin(String json) {
        return "";
    }

    @RequestMapping("/logout")
    String logout(String json) {
        return "";
    }

    @RequestMapping("/download")
    String download(String json) {
        return "";
    } ;

    @RequestMapping("/upload")
    String upload(String json) {
        return null;
    }
}
