package com.sxau.cs.file.service;

import com.sxau.cs.file.service.bean.UserInfo;

public interface UserInfoService {

    /**
     * 查询用户登录信息 by name
     * @param name 用户name
     * @return     对象userInfo
     */
    UserInfo queryUserInfoByName(String name);

    /**
     * token校验
     * @return
     */
    boolean tokenVerification(String token);

    /**
     *  x
     *
     * @param userId
     * @return
     */
    long getRootFileIdByUserId(String userId);
}
