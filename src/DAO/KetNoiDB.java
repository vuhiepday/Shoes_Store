/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package DAO;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author nguye
 */
public class KetNoiDB {
     public static Connection openConnection() throws Exception{
        Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
        System.out.println("Loaded...");
        String url="jdbc:sqlserver://localhost:1433;databaseName=QuanLyBanHang;integratedSecurity=false;encrypt=false;trustServerCertificate=true;";
        String user ="sa2";
        String password="123";
        Connection con=DriverManager.getConnection(url,user,password);
        System.out.println("Connected...");
        return con;
}
}
