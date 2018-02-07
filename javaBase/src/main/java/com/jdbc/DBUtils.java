package com.jdbc;

import org.apache.commons.dbcp.BasicDataSource;
import org.junit.Test;

import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Properties;

public class DBUtils {
    private static String driver = null;
    private static String url = null;
    private static String user = null;
    private static String password = null;
    private static BasicDataSource ds = null;
    static {
        //读取程序外的.properties文件
        //需要.properties文件的包路径
        Properties props = new Properties();
        try {
         String path = "./src/main/java/com/jdbc/db.properties";
//            props.load(DBUtils.class.getClassLoader().getResourceAsStream(path));
            props.load(new FileInputStream(path));
            //返回String value=properties对象.getProperty(“key”)
            driver = props.getProperty("driver");
            url = props.getProperty("url");
            user = props.getProperty("user");
            password = props.getProperty("password");
            ds = new BasicDataSource();
            //ds中已经有了几个创建好的连接
            ds.setDriverClassName(driver);
            ds.setUrl(url);
            ds.setUsername(user);
            ds.setPassword(password);
            ds.setInitialSize(
                    Integer.parseInt(props.getProperty("initialSize")
                    )
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

    @Test
    public void  test() throws Exception{
//        String path = "./src/main/java/com/jdbc/db.properties";
        String path = ".";

        File file = new File(path);
//        System.out.println(file.listFiles()[0].getName());
        System.out.println(file.exists());
//        Properties properties = new Properties();
//            String path = "jdbc/db.properties";
//            props.load(DBUtils.class.getClassLoader().getResourceAsStream(path));
//        properties.load(new FileInputStream(path));

    }

}
