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
    Integer queryUserIdByToken(String token);

    /**
     * 查询用户id by name
     *
     * @param name 用户名
     * @return
     */
    Integer queryUserIdByName(String name);

    /**
     * 查询UserInfo by 用户Id
     *
     * @param UserId 用户UserId
     * @return 用户信息
     */
    List<UserInfo> queryUserInfoByUserId(Integer UserId);

    /**
     * 查询fileId by 用户Id
     *
     * @param userId 用户Id
     * @return fileId
     */
    Long queryFileIdByUserId(Integer userId);

    /**
     * 查询Token by 用户Id
     *
     * @param UserId 用户UserId
     * @return token List
     */
    List<String> queryTokenByUserId(Integer UserId);

    /**
     * token校验
     *
     * @return
     */
    boolean tokenVerification(String token);

    /**
     * 插入token
     *
     * @param userId 用户id
     * @param token  token
     * @return boolean
     */
    boolean insertToken(Integer userId, String token);

    /**
     * 删除token
     *
     * @param token token
     * @return boolean
     */
    boolean deleteToken(String token);

}
