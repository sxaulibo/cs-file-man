package com.sxau.cs.file.biz;

import com.sxau.cs.file.provider.model.request.UserLoginRequest;
import com.sxau.cs.file.provider.model.request.UserLogoutReq;
import com.sxau.cs.file.provider.model.response.UserLoginResponse;
import com.sxau.cs.file.provider.model.response.UserLogoutResp;

/**
 * 用户业务
 */
public interface UserBiz {
    /**
     * 用户登录
     *
     * @param userLoginRequest 用户登录请求
     * @return 用户登录响应
     */
    UserLoginResponse nameLogin(UserLoginRequest userLoginRequest);

    /**
     * 用户登出
     * @param userLogoutReq 用户登出请求
     * @return 用户登出响应
     */
    UserLogoutResp logout(UserLogoutReq userLogoutReq);
}