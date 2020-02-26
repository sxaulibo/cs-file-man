package com.sxau.cs.file.service;

import com.sxau.cs.file.service.bean.UserInfo;

public interface UserInfoService {

    /**
     * 查询用户登录信息 by name
     *
     * @param name 用户name
     * @return 对象userInfo
     */
    UserInfo queryUserInfoByName(String name);

    /**
     * token校验
     *
     * @return
     */
    @Deprecated
    boolean tokenVerification(String token);

    /**
     * 根据用户id获取根文件id
     *
     * @param userId
     * @return
     */
    long queryRootFileIdByUserId(long userId);

    /**
     * 若为无效token，则返回null
     *
     * @param token 密令
     * @return 用户id
     */
    Long queryUserIdByToken(String token);
}
