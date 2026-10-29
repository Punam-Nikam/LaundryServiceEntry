package com.example;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    
     private static final String URL = "jdbc:mysql://localhost:3306/Laundry_service";
    private static final String USER = "root";
    private static final String PASSWORD = "my_pass";

    public static Connection getConnection() throws SQLException {
        try{
            Class.forName("com.mysql.cj.jdbc.Driver");
            return DriverManager.getConnection(URL,USER,PASSWORD);
        } catch(ClassNotFoundException e){
            throw new SQLException("Mysql jdbc driver could not loaded");
        }
    }
}