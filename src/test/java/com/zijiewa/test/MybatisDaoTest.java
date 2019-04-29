package com.zijiewa.test;

import com.zijiewa.dao.UserDao;
import com.zijiewa.dao.UserDaoImpl;
import com.zijiewa.po.User;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.Before;
import org.junit.Test;

import java.io.InputStream;

/**
 * @ClassName MybatisDaoTest
 * @Description TODO
 * @Author zzxia
 * @Date 2019/4/29 12:44
 * Version 1.0
 **/
public class MybatisDaoTest {

    private SqlSessionFactory sqlSessionFactory;
    @Before
    public void setUp() throws Exception{
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);
         sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
    }

    @Test
    public void testFindUserById() throws Exception {
        UserDaoImpl userDao=new UserDaoImpl(sqlSessionFactory);
        userDao.findUserById(29);
    }
}
