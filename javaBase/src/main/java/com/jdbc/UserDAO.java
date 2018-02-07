package com.jdbc;

import org.junit.Test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class UserDAO {


    public void findAll() throws SQLException {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        try {
            conn = DBUtils.getConnection();
            stmt = conn.createStatement();
            String sql = "SELECT id, name, age FROM sys_user LIMIT 0, 1";

            // sql = SELECT id, name, age FROM sys_user
            //  注入攻击 sql = sql + "where name =" + name + "and pwd =" + pwd  当传递参数为 "jack", "or 1=1" 时可获取全部用户信息
            rs = stmt.executeQuery(sql);

            /*
            String sql = "SELECT id, name, age FROM sys_user LIMIT ?, ?";
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setObject(0, 0)
            pstmt.setObject(0, 1)
            //PreparedStatement  可防止注入式攻击
            SELECT id, name, age FROM sys_user  where name = ? ,  当传递参数为 "jack", "or 1=1" 时
             SELECT id, name, age FROM sys_user  where name = 'jack' and password = '\' or \'1\'=\'1', 注入攻击失败
            rs= pstmt.executeQuery();
            */

            //Step4：处理结果集
            while (rs.next()) {
                //列类型、get的类型、变量类型一致
                int id = rs.getInt("id");
                String name = rs.getString(2);
                Integer age = rs.getInt("age");
                System.out.println(id + ", " + name + ", " + age);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            rs.close();
            stmt.close();
            DBUtils.closeConnection(conn);
        }
    }


    @Test
    public void test() throws Exception {
        UserDAO userDAO = new UserDAO();
        userDAO.findAll();
    }
}
