/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.mycompany.kasirapp.dbConnection;

import java.sql.Statement;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.DriverManager;

/**
 *
 * @author Acer SPIN
 */
public class dbConfig {
    // inputan untuk megkoneksikan database
    private static final String JDBC_DRIVER = "com.mysql.cj.jdbc.Driver";
    private static final String DB_URL = "jdbc:mysql://localhost:3306/appkasir2";
    private static  final String USER = "root";
    private static final String PASS = "";
    
    private static Connection connect;
    private static Statement statement;
    private static ResultSet resultSet;
    
    public static Connection connection(){
        try {
            Class.forName(JDBC_DRIVER);
            connect = DriverManager.getConnection(DB_URL, USER, PASS);
//            System.out.println("Koneksi Berhasil");
        } catch (Exception e) {
            e.printStackTrace();
//            System.out.println("koneksi gagal");
        }
        return connect;
    }
}
