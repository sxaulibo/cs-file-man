package com.sxau.cs.file.man.biz.impl;

import com.sxau.cs.file.man.biz.UserBiz;
import com.sxau.cs.file.man.common.constant.Constant;
import com.sxau.cs.file.man.common.model.request.UserLoginRequest;
import com.sxau.cs.file.man.common.model.request.UserLogoutReq;
import com.sxau.cs.file.man.common.model.response.UserLoginResponse;
import com.sxau.cs.file.man.common.model.response.UserLogoutResp;
import com.sxau.cs.file.man.service.UserService;
import com.sxau.cs.file.man.service.bean.UserInfo;
import org.apache.commons.lang3.RandomStringUtils;
import org.springframework.stereotype.Component;
import org.springframework.util.Assert;

import javax.annotation.Resource;
import java.util.List;

@Component
public class UserBizImpl implements UserBiz {

    @Resource
    private UserService userService;

    @Override
    public UserLoginResponse nameLogin(UserLoginRequest userLoginRequest) {
        //前置校验
        Assert.hasLength(userLoginRequest.getName(), "用户名不能为空");
        Assert.hasLength(userLoginRequest.getPassword(), "用户密码不能为空");

        UserLoginResponse userLoginResponse = new UserLoginResponse();

        //校验是否查到用户ID
        Integer userId = userService.queryUserIdByName(userLoginRequest.getName());
        List<UserInfo> userInfoList = userService.queryUserInfoByUserId(userId);
        if (userId == null || userInfoList.size() == 0 || userInfoList.get(0).getPassword() != userLoginRequest.getPassword()) {
            System.out.println("用户不存在/登陆密码错误");
            userLoginResponse.setStat(Constant.Stat.ERROR);
            return userLoginResponse;
        }

        String token = tokenProduce();
        if (!userService.insertToken(userId, token)) {
            System.out.println("token插入失败");
        }
        userLoginResponse.setStat(Constant.Stat.OK);
        userLoginResponse.setToken(token);
        return userLoginResponse;
    }

    /**
     * 生成token
     *
     * @return token
     */
    private String tokenProduce() {
        String token = RandomStringUtils.randomAlphabetic(11);
        return token;
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
