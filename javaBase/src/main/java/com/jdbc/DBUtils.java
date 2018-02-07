package com.jdbc;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static BasicDataSource ds = null; // 数据源

    static {
        Properties props = new Properties();
        try {
            String path = "./src/main/java/com/jdbc/db.properties";
// props.load(DBUtils.class.getClassLoader().getResourceAsStream("./com/jdbc/db.properties")); // 默认是从ClassPath根下获取文件
// props.load(DBUtils.class.getResourceAsStream("./db.properties")); // .class文件为根目录
            props.load(new FileInputStream(path));
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            ds = new BasicDataSource();
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(password);
            ds.setInitialSize(Integer.parseInt(props.getProperty("initialSize"))
            );
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static Connection getConnection() throws SQLException {
        Connection conn = null;
        if (ds != null) {
            conn = ds.getConnection();
        }
        return conn;
    }

    public static void closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }


}
