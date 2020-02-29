package com.sxau.cs.file.man.service.utils;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * 获取sqlSession实例
 *
 */
public class UtilSqlSession {
    private static SqlSessionFactory sqlSessionFactory = null;

    //私有化构造方法，实现单例
    private UtilSqlSession() {

    }

    public static SqlSession getInstance() {
        try {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory.openSession(false);
            }
            //指定mybatis全局配置文件
            String resource = "mybatis-config.xml";
            //读取全局配置文件
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
            //构建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
//            sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("GetSqlSession IOException");
        }
        throw new RuntimeException("getSqlSession IOException");
        //return null;这里new异常是直接异常了,不走后面的逻辑代码;
    }
}
