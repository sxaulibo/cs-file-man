package com.sxau.cs.file.provider;

import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.Map;

public class RestController1 {


    @RequestMapping("/nameLogin")
    String nameLogin(String name,String pwd) {
        Map m1 = new HashMap();
        m1.put("libo", "501090LB");
        m1.put("lixin", "lixin");
        if(m1.get(name)!=pwd) {
            return "error";
        }
        return "ok";
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
