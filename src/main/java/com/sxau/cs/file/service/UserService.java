package com.sxau.cs.file.service;

import com.sxau.cs.file.service.bean.UserInfo;

import java.util.List;

public interface UserService {

    /**
     * 查询用户id by token
     *
     * @param token
     * @return
     */
    int queryUserIdByToken(String token);

    /**
     * 查询用户id by name
     *
     * @param name 用户名
     * @return
     */
    int queryUserIdByName(String name);

    /**
     * 查询用户id by token
     *
     * @param token 11位token字符串
     * @return
     */
    int queryUserIdByToken(String token);

    /**
     * 查询UserInfo by 用户Id
     *
     * @param UserId 用户UserId
     * @return 用户信息
     */
    UserInfo queryUserInfoByUserId(String UserId);

    /**
     * 查询fileId by 用户Id
     *
     * @param userId 用户Id
     * @return fileId
     */
    int queryFileIdByUserId(String userId);

    /**
     * 查询Token by 用户Id
     *
     * @param UserId 用户UserId
     * @return token List
     */
    List<String> queryTokenByUserId(String UserId);

    /**
     * token校验
     *
     * @return
     */
    boolean tokenVerification(String token);

    boolean insertToken(String userId, String token);

    boolean deleteToken(String token);

}
