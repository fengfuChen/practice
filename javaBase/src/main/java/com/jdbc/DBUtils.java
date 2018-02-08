package com.jdbc;

import org.apache.commons.dbcp.BasicDataSource;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {

    private static BasicDataSource dataSource = null; // 数据库连接池

//     Class.forName(driver); Connection conn = DriverManager.getConnection(url, user, pwd)

    public static void init() throws IOException {
        Properties props = new Properties();
        try {
            String path = "./src/main/java/com/jdbc/db.properties";
            // props.load(DBUtils.class.getClassLoader().getResourceAsStream("./com/jdbc/db.properties")); // 默认是从ClassPath根下获取文件
            // props.load(DBUtils.class.getResourceAsStream("./db.properties")); // .class文件为根目录
            props.load(new FileInputStream(path));
            String driver = props.getProperty("driver");
            String url = props.getProperty("url");
            String user = props.getProperty("user");
            String password = props.getProperty("password");
            dataSource = new BasicDataSource();
            dataSource.setDriverClassName(driver);
            dataSource.setUrl(url);
            dataSource.setUsername(user);
            dataSource.setPassword(password);
            dataSource.setInitialSize(Integer.parseInt(props.getProperty("dataSource.initialSize"))); // 初始化连接数
            dataSource.setMinIdle(Integer.parseInt(props.getProperty("dataSource.minIdle")));// 最小空闲连接
            dataSource.setMaxIdle(Integer.parseInt(props.getProperty("dataSource.maxIdle"))); // 最大空闲连接
            dataSource.setMaxWait(Long.parseLong(props.getProperty("dataSource.maxWait"))); // 最大等待时间
            dataSource.setMaxActive(Integer.parseInt(props.getProperty("dataSource.maxActive"))); // 最大连接数
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public static synchronized Connection getConnection() throws SQLException , IOException{
        Connection conn = null;
        if (dataSource == null) {
            init();
        }else {
            conn = dataSource.getConnection();
        }
        return conn;
    }

    public static synchronized void  closeConnection(Connection conn) throws SQLException {
        if (conn != null) {
            conn.close();
        }
    }


}
