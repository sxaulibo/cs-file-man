package com.sxau.cs.file.service.mapper;

import com.sxau.cs.file.service.bean.UserInfo;

import java.util.List;

public interface UserMapper {

//    //     void insertFile(FileInfo fileInfo);
//    //查询用户信息by name
//    List<UserInfo> queryUserInfoByName(String name);
//    Boolean tokenQuery(String token);

    int queryUserIdByName(String name);
    int queryUserIdByToken(String token);
    UserInfo queryUserInfoByUserId(String UserId);
    int queryFileIdByUserId(String userId);
    List<String> queryTokenByUserId(String UserId);
    boolean tokenVerification(String token);
}
