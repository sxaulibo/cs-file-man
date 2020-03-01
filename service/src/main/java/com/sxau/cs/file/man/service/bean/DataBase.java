package com.sxau.cs.file.man.service.bean;

import com.sxau.cs.file.man.service.mapper.UserMapper;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * bean对象那个
 */
public class DataBase {
    private static SqlSessionFactory sqlSessionFactory;
    //读取配置文件到InputStream流-> 构建出SqlSessionFactory用流bulid->
    // -> 取出一个SqlSession-> 用SqlSession读取一个类信息 -> 调用这个类中的方法（映射）到数据库

    InputStream inputStream;

    private DataBase() throws IOException {
        inputStream = Resources.getResourceAsStream("mybatis-config.xml");
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    Integer queryUserIdByName(String name) {
        SqlSession sqlSession = sqlSessionFactory.openSession();
        return sqlSession.getMapper(UserMapper.class).queryUserIdByName(name);
    }

}
