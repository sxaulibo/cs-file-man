package com.sxau.cs.file.man.service.mapper;

import com.sxau.cs.file.man.service.bean.UserInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserMapper {

    Integer queryUserIdByName(String name);

    Integer queryUserIdByToken(String token);

    List<UserInfo> queryUserInfoByUserId(Integer userId);

    Long queryFileIdByUserId(Integer userId);//todo 注意入参要判断 userId是否为null,插入name时要判断是否重名

    List<String> queryTokenByUserId(Integer UserId);//todo 注意入参要判断 userId是否为null

    Integer tokenVerification(String token);

    boolean insertToken(@Param(value = "userId") Integer userId, @Param(value = "token") String token);

    boolean deleteToken(String token);
}
