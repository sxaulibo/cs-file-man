package com.sxau.cs.file.man.provider.controller;

import com.sxau.cs.file.man.biz.UserBiz;
import com.sxau.cs.file.man.common.model.request.UserLoginRequest;
import com.sxau.cs.file.man.common.model.request.UserLogoutReq;
import com.sxau.cs.file.man.common.model.response.UserLoginResponse;
import com.sxau.cs.file.man.common.model.response.UserLogoutResp;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

@RestController
public class UserController {

    @Resource
    private UserBiz userBiz;

    @RequestMapping("/nameLogin")
    public UserLoginResponse nameLogin(@RequestBody UserLoginRequest userLoginRequest) {
        return userBiz.nameLogin(userLoginRequest);
    }

    @RequestMapping("/logout")
    public UserLogoutResp logout(@RequestBody UserLogoutReq userLogoutReq) {
        return userBiz.logout(userLogoutReq);
    }

}
