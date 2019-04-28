package com.zijiewa.test;

import org.junit.Test;

import java.sql.*;

import static java.lang.Class.forName;

/**
 * @ClassName JDBCTest
 * @Description 传统JDBC方式查询数据库
 * @Author zzxia
 * @Date 2019/4/28 10:28
 * Version 1.0
 **/
public class JDBCTest {
    @Test
    public void MySQLQueryTest() throws SQLException {
        Connection connection=null;
        PreparedStatement preparedStatement=null;
        ResultSet rs=null;

        try
        {
            //加载驱动
            forName("com.mysql.jdbc.Driver");

            //获取连接
            String url="jdbc:mysql://127.0.0.1:3306/ssmdemo";
            String user="root";
            String password="root";
            connection=DriverManager.getConnection(url,user,password);

            //获取statement,PreparedStatement

            String sql="select * from tb_user where id=?";
            preparedStatement=connection.prepareStatement(sql);
            //设置参数
            preparedStatement.setInt(1,1);

            rs=preparedStatement.executeQuery();

            while (rs.next())
            {
                System.out.println(rs.getString("user_name"));
                System.out.println(rs.getString("name"));
                System.out.println(rs.getInt("age"));
                System.out.println(rs.getDate("birthday"));
            }

        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            if(rs!=null)
            {
                rs.close();
            }
            if (preparedStatement != null) {
                preparedStatement.close();
            }
            if (connection != null) {
                connection.close();
            }
        }
    }
}
