package com.jdbc;

import org.junit.Test;

import java.sql.*;

public class UserDAO {


    public void findAll() throws SQLException {
        Connection conn = null;
        PreparedStatement preparedStatement = null;
        ResultSet rs = null;

        try {
            conn = DBUtils.getConnection();
            String sql = "SELECT id, name, age FROM sys_user WHERE name = ? AND password = ?";
            /*
            Statement statement = conn.createStatement();
            statement.executeQuery(sql);
            sql = SELECT id, name, age FROM sys_user
            注入攻击 sql = sql + "where name =" + name + "and pwd =" + pwd  当传递参数为 "jack", "'123' or 1=1" 时可获取全部用户信息
            */
            preparedStatement = conn.prepareStatement(sql); //PreparedStatement  可防止注入式攻击, 不允许在插入参数时改变sql语句的逻辑结构

            PreparedStatement pstmt = conn.prepareStatement(sql);
            // PreparedStatement pstmt = conn.prepareStatement(sql, ResultSet.TYPE_FORWARD_ONLY, ResultSet.CONCUR_READ_ONLY); // 预先声明结果集的类型和属性, 可滚动, 只读等
            preparedStatement.setObject(1, "jack");
            preparedStatement.setObject(2, "123456");
            //   当传递参数为 "jack", "or 1=1" 时
            // SELECT id, name, age FROM sys_user  where name = 'jack' and password = '\' or \'1\'=\'1', 注入攻击失败
            rs = pstmt.executeQuery();

            ResultSetMetaData metaData = rs.getMetaData();
            String firstColName = metaData.getColumnName(0);
            System.out.println(firstColName);

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString(2);
                Integer age = rs.getInt("age");
                System.out.println(id + ", " + name + ", " + age);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            rs.close();
            preparedStatement.close();
            // DBUtils.closeConnection(conn);
        }
    }


    @Test
    public void test() throws Exception {
        UserDAO userDAO = new UserDAO();
        userDAO.findAll();
    }
}
