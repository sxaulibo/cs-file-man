package com.sxau.cs.file.man.service.Impl;

import com.sxau.cs.file.man.service.UserService;
import com.sxau.cs.file.man.service.bean.UserInfo;
import com.sxau.cs.file.man.service.mapper.UserMapper;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Resource
    private UserMapper userMapper;

    @Override
    public Integer queryUserIdByName(String name) {
        return userMapper.queryUserIdByName(name);
    }

    @Override
    public Integer queryUserIdByToken(String token) {
        return userMapper.queryUserIdByToken(token);
    }

    @Override
    public List<UserInfo> queryUserInfoByUserId(Integer UserId) {
        List<UserInfo> userInfoList = userMapper.queryUserInfoByUserId(UserId);
        if (userInfoList.size() > 1) {
            throw new RuntimeException("queryUserInfoByUserId 查询结果数大于1");
        }
        return userInfoList;
    }

    @Override
    public Long queryFileIdByUserId(Integer userId) {
        return userMapper.queryFileIdByUserId(userId);
    }

    @Override
    public List<String> queryTokenByUserId(Integer UserId) {
        return userMapper.queryTokenByUserId(UserId);
    }

    @Override
    public boolean tokenVerification(String token) {
        Integer userId = userMapper.tokenVerification(token);
        return userId != null;
    }

    @Override
    public boolean insertToken(Integer userId, String token) {
        return userMapper.insertToken(userId, token);
    }

    @Override
    public boolean deleteToken(String token) {
        return userMapper.deleteToken(token);
    }

}
