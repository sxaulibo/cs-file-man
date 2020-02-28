package com.sxau.cs.file.service.Impl;

import com.sxau.cs.file.service.Until.UtilSqlSession;
import com.sxau.cs.file.service.UserService;
import com.sxau.cs.file.service.bean.UserInfo;
import com.sxau.cs.file.service.mapper.UserMapper;
import org.apache.commons.lang3.RandomStringUtils;

import java.util.List;

public class UserServiceImpl implements UserService {

    /**
     * token 生成11位
     *
     * @return
     */
    private String tokenGenerate1() {
        return RandomStringUtils.randomAlphabetic(11);
    }

    @Override
    public int queryUserIdByName(String name) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).queryUserIdByName(name);
    }

    @Override
    public int queryUserIdByToken(String token) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).queryUserIdByToken(token);
    }

    @Override
    public UserInfo queryUserInfoByUserId(String UserId) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).queryUserInfoByUserId(UserId);
    }

    @Override
    public int queryFileIdByUserId(String userId) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).queryFileIdByUserId(userId);
    }

    @Override
    public List<String> queryTokenByUserId(String UserId) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).queryTokenByUserId(UserId);
    }

    @Override
    public boolean tokenVerification(String token) {
        return UtilSqlSession.getInstance().getMapper(UserMapper.class).tokenVerification(token);
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
