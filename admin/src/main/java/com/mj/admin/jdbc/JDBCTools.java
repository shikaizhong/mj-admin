package com.mj.admin.jdbc;

import com.mysql.jdbc.Driver;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.Properties;
//statement connection 都是java.sql.*; 数据库驱动则是 com.mysql.jdbc.*;
public class JDBCTools {
    public static void release(ResultSet rs, Statement statement , Connection connection) throws Exception{
        //connection statement rs 都是应用服务器与数据库的连接资源，需要关闭

        if (rs!=null) {
            try {
                rs.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        if (statement!=null) {
            try {
                statement.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }

        if (connection!=null) {
            try {
                connection.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }

    public static Connection getConnection() throws Exception{

        String driverClas = null;
        String jdbcURL = null;
        String user = null;
        String password = null;
        //读取类路径下的properties
        InputStream in = JDBCTools.class.getClass().getClassLoader().getResourceAsStream("application-dev.yml");
        Properties properties = new Properties();
        properties.load(in);
        driverClas = properties.getProperty("driver");
        jdbcURL = properties.getProperty("url");
        user = properties.getProperty("username");
        password = properties.getProperty("password");

        Driver driver = (Driver) Class.forName(driverClas).newInstance();

        Properties info = new Properties();
        info.put("user", user);
        info.put("password", password);
        Connection connection = driver.connect(jdbcURL, info);

        return connection;
    }
}
