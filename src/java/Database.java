/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.sql.*;
/**
 *
 * @author Sohan
 */
public class Database {
    final static String url = "jdbc:mysql://localhost:3306/studentdb";
    final static String user = "root";
    final static String password = "";
    
    public static Connection connect(){
        try {
            Connection c = DriverManager.getConnection(url,user,password);
            System.out.println("Success...");
            return c;
        } catch (SQLException ex) {
            return null;
        }
    }
}