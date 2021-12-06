package com.lzw.utils;

import java.sql.*;

/**
 * @author a5071
 * @since 2021/12/1 10:45
 * description
 */
public class DBUtils{

    public static Connection getConn(){
        // 连接数据库
        try {
            // 加载驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 获取数据库连接
            Connection conn = DriverManager
                    .getConnection("jdbc:mysql://localhost:3306/mybatis?serverTimezone=UTC&useSSL=false", "root", "201314");
            return conn;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    // 关闭数据库
    public static void close(Connection conn, Statement statement, ResultSet resultSet){

        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (statement != null) {
            try {
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }

        if (resultSet != null) {
            try {
                resultSet.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }


}
