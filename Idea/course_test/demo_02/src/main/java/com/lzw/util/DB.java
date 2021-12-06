package com.lzw.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DB{

    private String Driver_name =
            "jdbc:mysql://localhost:3306/stock_manager?useSSL=false&characterEncoding=utf8";

    private String USER = "root";
    private String PASS = "201314";
    public static Connection con;

    public DB(){
        try {
            Class.forName("com.mysql.jdbc.Driver");
            con =
                    DriverManager.getConnection(
                            Driver_name, USER, PASS);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static Connection getConnection(){
        if (con == null) {
            new DB();
        }
        return con;
    }
}
