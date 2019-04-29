package com.zijiewa.test;

import com.zijiewa.mapper.UserMapper;
import com.zijiewa.mybatis.MyBatisSqlSessionFactory;
import com.zijiewa.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author zzxia
 * @Date 2019/4/28 14:59
 * Version 1.0
 **/
public class MybatisMapperTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
        sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    //根据用户ID获取用户信息
    @Test
    public void findUserByIdTest() throws Exception {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.findUserById(26);
        System.out.println(user.getUsername());
    }


    @Test
    public void findUserResultMapByIdTest() throws Exception {

        SqlSession session = sqlSessionFactory.openSession();
        UserMapper userMapper=session.getMapper(UserMapper.class);
        User user=userMapper.findUserResultMapById(25);
        System.out.println(user.getUsername());
    }
}