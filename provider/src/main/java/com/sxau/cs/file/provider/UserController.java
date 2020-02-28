package com.sxau.cs.file.provider;

import com.sxau.cs.file.biz.UserBiz;
import com.sxau.cs.file.provider.model.request.UserLoginRequest;
import com.sxau.cs.file.provider.model.request.UserLogoutReq;
import com.sxau.cs.file.provider.model.response.UserLoginResponse;
import com.sxau.cs.file.provider.model.response.UserLogoutResp;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.io.IOException;

public class UserController {

    private static UserBiz userBiz;
    @RequestMapping("/nameLogin")
    public UserLoginResponse nameLogin(@RequestBody UserLoginRequest userLoginRequest) {
        return userBiz.nameLogin(userLoginRequest);
    }

    @RequestMapping("/logout")
    public UserLogoutResp logout(UserLogoutReq userLogoutReq) {
        return userBiz.logout(userLogoutReq);
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
        return "";
    }

    @RequestMapping("/upload")
    public String upload(String json) {
        return null;
    }
}
