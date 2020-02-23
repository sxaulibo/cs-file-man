package com.sxau.cs.file.provider;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.sxau.cs.file.service.FileService;
import com.sxau.cs.file.service.Impl.FileServiceImpl;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.context.request.RequestContextHolder;
import org.springframework.web.context.request.ServletRequestAttributes;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class RestController1 {


    @RequestMapping("/nameLogin")
    public String nameLogin(String json) {
        //从字符串解析JSON对象  eg"{\"runoob\":\"菜鸟教程\"}"  实际  {"name": "test", "password":"123456"}
        JSONObject obj = JSON.parseObject(json);
//        obj.getString(name);

        return "ok";
    }

    @RequestMapping("/logout")
    public String logout(String json) {
        return "";
    }

    @RequestMapping("/download")
    public String download(@RequestParam("fid") String fid) throws IOException {
//        FileService fileService = new FileServiceImpl();
//        FileInfo fileInfoBean = fileService.queryInfoByFileCode(fid);
//        System.out.println(fileInfoBean.getPath());
//        if (fileInfoBean.getPath().equals("")) {
//            throw new RuntimeException("文件找不到");
//        }
//        ServletRequestAttributes requestAttributes = (ServletRequestAttributes) RequestContextHolder.getRequestAttributes();
//        HttpServletResponse response = requestAttributes != null ? requestAttributes.getResponse() : null;
//        Objects.requireNonNull(response).setContentType("application/octet-stream");
//        response.setCharacterEncoding("UTF-8");
//        response.setHeader("Content-Disposition", "attachment;filename=" + new String(fileInfoBean.getFileName().getBytes(StandardCharsets.UTF_8), "ISO8859-1"));
//        //把目录下存在的文件转换成流
//        Writer writer = response.getWriter();
//        try (InputStreamReader inputStreamReader = new FileReader(new File(fileInfoBean.getPath()))) {
//
//            BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
//            String temp;
//            while ((temp = bufferedReader.readLine()) != null) {
//                writer.append(temp);
//                writer.append('\n');
//                writer.flush();
//            }
//            writer.close();
//            return "";
//        }
        return "" ;
    }

    @RequestMapping("/upload")
    public String upload(String json) {
        return null;
    }
}
