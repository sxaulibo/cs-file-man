package com.sxau.cs.file.service.mapper;

import com.sxau.cs.file.provider.model.response.FileInfo;
import com.sxau.cs.file.service.bean.UserInfo;

import java.util.List;

public interface UserMapper {

    //     void insertFile(FileInfo fileInfo);
    //查询用户信息by name
    List<UserInfo> queryUserInfoByName(String name);
    Boolean tokenQuery(String token);
}
