package com.sxau.cs.file.biz.impl;

import com.sxau.cs.file.biz.UserBiz;
import com.sxau.cs.file.provider.common.constants.Constant;
import com.sxau.cs.file.provider.model.request.UserLoginRequest;
import com.sxau.cs.file.provider.model.request.UserLogoutReq;
import com.sxau.cs.file.provider.model.response.UserLoginResponse;
import com.sxau.cs.file.provider.model.response.UserLogoutResp;
import com.sxau.cs.file.service.Impl.UserServiceImpl;
import com.sxau.cs.file.service.UserService;
import com.sxau.cs.file.service.bean.UserInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.util.Assert;

public class UserBizImpl implements UserBiz {

    private static UserService userService=new UserServiceImpl();

    @Override
    public UserLoginResponse nameLogin(UserLoginRequest userLoginRequest) {
        Assert.hasLength(userLoginRequest.getName(), "用户名不能为空");
        Assert.hasLength(userLoginRequest.getPassword(), "用户密码不能为空");
        int userId = userService.queryUserIdByName(userLoginRequest.getName());
        UserInfo userInfo = userService.queryUserInfoByUserId(String.valueOf(userId));
        if (userLoginRequest.getPassword() != userInfo.getPassword()) {
            return null;
        }
        UserLoginResponse userLoginResponse = new UserLoginResponse();

        //生成token
        String token = RandomStringUtils.randomAlphabetic(11);
        if (!userService.insertToken(String.valueOf(userId), token)) {
            System.out.println("插入token失败");
            return null;
        }
        userLoginResponse.setToken(token);
        return userLoginResponse;
    }

    @Override
    public UserLogoutResp logout(UserLogoutReq userLogoutReq) {
        UserLogoutResp userLogoutResp = new UserLogoutResp();
        if (!userService.deleteToken(userLogoutReq.getToken())) {
            System.out.println("登出删除token失败");
            userLogoutResp.setStat(Constant.Stat.ERROR);
        }
        userLogoutResp.setStat(Constant.Stat.OK);
        return userLogoutResp;
    }
}
