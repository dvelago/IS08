package com.ucv.dao;

import java.sql.Connection;
import java.sql.DriverManager;

public class Conexion {
    private static final String URL = "jdbc:sqlserver://localhost\\SQLEXPRESS;databaseName=bdalumno;encrypt=true;trustServerCertificate=true;";
    private static final String USER = "IG08";
    private static final String PASSWORD = "123456789";

    public static Connection getConexion() {
        Connection cn = null;
        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            cn = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (Exception e) {
            System.out.println("Error en la conexion: " + e.getMessage());
            e.printStackTrace();
        }
        return cn;
    }
}