package com.mj.admin.jdbc;

import java.sql.*;

public class DBHelp {
    //驱动
    private final static String driver = "com.microsoft.sqlserver.jdbc.SQLServerDriver";
    //连接名
    private final static String url = "jdbc:sqlserver://192.168.1.105;databasename=TopDB";
    //用户名
    private final static String user = "sa";
    //密码
    private final static String password = "123456";
    /**
     * 得到连接
     */
    public static Connection connection() throws ClassNotFoundException, SQLException {
        Connection connection = null;
        //注册数据驱动
        try {
            Class.forName(driver);
            connection = DriverManager.getConnection(url,user,password);
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException e){
            e.printStackTrace();
        }
      return connection;
    }
    /**
     * 关闭数据连接
     */
    public static void closeAll(Connection connection , Statement statement, ResultSet resultSet){
        try {
            if (null !=connection){
                connection.close();
            }
            if (null !=statement){
                statement.close();
            }
            if (null !=resultSet){
                resultSet.close();
            }
        }catch (SQLException e){
            e.printStackTrace();
        }

    }
}
