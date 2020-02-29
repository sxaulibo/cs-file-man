package com.sxau.cs.file.man.service.mapper;

import com.sxau.cs.file.man.service.bean.UserInfo;

import java.util.List;

public interface UserMapper {

    Integer queryUserIdByName(String name);

    Integer queryUserIdByToken(String token);

    List<UserInfo> queryUserInfoByUserId(int UserId);

    Long queryFileIdByUserId(Integer userId);//todo 注意入参要判断 userId是否为null,插入name时要判断是否重名

    List<String> queryTokenByUserId(Integer UserId);//todo 注意入参要判断 userId是否为null

    boolean tokenVerification(String token);

    boolean insertToken(Integer userId, String token);

    boolean deleteToken(String token);
}
