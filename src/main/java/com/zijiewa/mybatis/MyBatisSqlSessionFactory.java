package com.zijiewa.mybatis;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import java.io.IOException;
import java.io.InputStream;

/**
 * @ClassName MyBatisSqlSessionFactory
 * @Description 根据XML配置一个SqlSessionFactory
 * @Author zzxia
 * @Date 2019/4/28 14:55
 * Version 1.0
 **/
public class MyBatisSqlSessionFactory {
    public static SqlSessionFactory GetSqlSessionFactory() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        return sqlSessionFactory;
    }
}
