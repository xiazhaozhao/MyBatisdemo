package com.zijiewa.dao;

import com.zijiewa.mybatis.MyBatisSqlSessionFactory;
import com.zijiewa.po.User;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;

import java.util.Date;

/**
 * @ClassName UserDaoImpl
 * @Description TODO
 * @Author zzxia
 * @Date 2019/4/29 12:38
 * Version 1.0
 **/
public class UserDaoImpl implements UserDao {

    SqlSessionFactory sqlSessionFactory;
    public UserDaoImpl(SqlSessionFactory sqlSessionFactory) {
        this.sqlSessionFactory = sqlSessionFactory;
    }

    public User findUserById(int id) throws Exception {
        SqlSession sqlSession=sqlSessionFactory.openSession();
        User user=sqlSession.selectOne("UserNs.findUserById",id);
        sqlSession.close();
        System.out.println(user.getUsername());
        return user;
    }

    public void insertUser(User user) throws Exception {
        SqlSessionFactory sqlSessionFactory = MyBatisSqlSessionFactory.GetSqlSessionFactory();
        SqlSession session = sqlSessionFactory.openSession();
        User newUser=new User();
        newUser.setAddress(user.getAddress());
        newUser.setSex(user.getSex());
        newUser.setBirthday(user.getBirthday());
        newUser.setUsername(user.getUsername());
        session.insert("UserNs.inserUser",newUser);
        session.commit();
        System.out.println(user.getId());
        session.close();
    }

    public void deleteUser(int id) throws Exception {

    }
}
