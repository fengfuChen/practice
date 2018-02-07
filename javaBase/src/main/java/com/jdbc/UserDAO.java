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
            //Step2：定义SQL语句
            stmt = conn.createStatement();
            //Step3：执行SQL语句
            String sql = "SELECT id, name, age FROM sys_user LIMIT 0, 1";
            rs = stmt.executeQuery(sql);
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
