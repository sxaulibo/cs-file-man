package com.sxau.cs.file.man.service.utils;

import org.apache.ibatis.builder.xml.XMLConfigBuilder;
import org.apache.ibatis.datasource.pooled.PooledDataSource;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.mapping.Environment;
import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.apache.ibatis.transaction.jdbc.JdbcTransactionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;

/**
 * 获取sqlSession实例
 */
public class UtilSqlSession {
//    private static SqlSessionFactory sqlSessionFactory = null;
    @Resource
    private SqlSessionFactory sqlSessionFactory;

//    //私有化构造方法，实现单例
//    private UtilSqlSession() {
//
//    }
//

    public  SqlSession getInstance() {
        try {
            if (sqlSessionFactory != null) {
                return sqlSessionFactory.openSession(false);
            }
            //指定mybatis全局配置文件
            String resource = "mybatis-config.xml";
            //读取全局配置文件
            InputStream inputStream = null;
            inputStream = Resources.getResourceAsStream(resource);
//            String driver = "com.mysql.cj.jdbc.Driver";
//            String url = "jdbc:mysql://localhost:3306/csfile?useSSL=false&amp;serverTimezone=UTC";
//            String username = "root";
//            String password = "root";
//
//            Configuration configuration = new Configuration(new Environment
//                    ("mybatisEnvironment",
//                            new JdbcTransactionFactory(),
//                            new PooledDataSource(driver, url, username, password)));
//
//            XMLConfigBuilder xmlConfigBuilder = new XMLConfigBuilder(inputStream);
//            configuration = xmlConfigBuilder.parse();
//
//
//
////            new XMLMapperBuilder().parse();
//            configuration.getEnvironment();
//            SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();

            //构建SqlSessionFactory对象
            sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
            SqlSession sqlSession = sqlSessionFactory.openSession(true);
            return sqlSession;
//            sqlSession.getMapper(UserMapper.class);
        } catch (IOException e) {
            e.printStackTrace();
            System.out.println("GetSqlSession IOException");
        }
        throw new RuntimeException("getSqlSession IOException");
        //return null;这里new异常是直接异常了,不走后面的逻辑代码;
    }
}
