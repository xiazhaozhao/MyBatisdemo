package com.zijiewa.test;

import com.zijiewa.mybatis.MyBatisSqlSessionFactory;
import com.zijiewa.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.Test;

import java.io.IOException;
import java.util.Date;
import java.util.List;

/**
 * @ClassName MybatisTest
 * @Description TODO
 * @Author zzxia
 * @Date 2019/4/28 14:59
 * Version 1.0
 **/
public class MybatisTest {

    //根据用户ID获取用户信息
    @Test
    public void findUserById() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.GetSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();

        User user=session.selectOne("UserNs.findUserById",1);

        System.out.println(user.getAddress());
        System.out.println(user.getUsername());
        System.out.println(user.getId());
        session.close();
    }

    //根据用户名查询用户信息
    @Test
    public void findUserByName() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.GetSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();

        List<User> users=session.selectList("UserNs.findUserByName","小明");

        for (User user : users) {
            System.out.println(user.getAddress());
            System.out.println(user.getUsername());
            System.out.println(user.getId());
        }

        session.close();

    }

    //插入用户
    @Test
    public void insertUser() throws IOException {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.GetSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        User user=new User();
        user.setAddress("夏凉村");
        user.setSex("1");
        user.setBirthday(new Date());
        user.setUsername("夏昭");
        session.insert("UserNs.inserUser",user);
        session.commit();

        System.out.println(user.getId());
        session.close();

    }
}
