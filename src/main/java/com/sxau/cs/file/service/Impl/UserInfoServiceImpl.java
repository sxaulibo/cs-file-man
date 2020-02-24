package com.sxau.cs.file.service.Impl;

import com.sxau.cs.file.service.Until.UtilSqlSession;
import com.sxau.cs.file.service.UserInfoService;
import com.sxau.cs.file.service.bean.UserInfo;
import com.sxau.cs.file.service.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;


import java.io.IOException;
import java.io.InputStream;
import java.util.List;

public class UserInfoServiceImpl implements UserInfoService {

    @Override
    public UserInfo queryUserInfoByName(String name) {
        UserInfo userInfo = new UserInfo();
        SqlSession session = UtilSqlSession.getInstance();
        if (session == null) {
            throw new RuntimeException("session IOException");
        }
        List<UserInfo> userInfoList = session.getMapper(UserMapper.class).queryUserInfoByName(name);
//        session.commit(); select * from runoob_tbl;
        System.out.println("查询name是否为空："+userInfoList.isEmpty());
        userInfo = userInfoList.get(0);
        if (userInfoList.size() > 1) {
            throw new RuntimeException("查询出多条数据");
        }
        return userInfo;
//        String token = tokenGenerate();
//        UserInfo userInfo = new UserInfo();

    }

    @Override
    public boolean tokenVerification(String token) {
        //判断查询出来的list数
        return userQueryByToken(token).size() != 0;
    }

    private void userQueryByToken(String token) {
        //查询出数据库是否有这个token

    }


    /**
     * token 生成11位
     *
     * @return
     */
    private String tokenGenerate() {
        return RandomStringUtils.randomAlphabetic(11);
    }

//    private SqlSession getSqlSession() throws IOException {
//        //指定mybatis全局配置文件
//        String resource = "mybatis-config.xml";
//        //读取全局配置文件
//        InputStream inputStream = Resources.getResourceAsStream(resource);
//        //构建SqlSessionFactory对象
//        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
//        return sqlSessionFactory.openSession(false);
//    }
}
