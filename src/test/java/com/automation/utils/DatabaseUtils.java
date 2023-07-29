package com.automation.utils;

import java.sql.*;

public class DatabaseUtils {

    private static String hostUrl = ConfigFileReaderUtils.getProperty("db.url");
    private static String userName = ConfigFileReaderUtils.getProperty("db.userName");
    private static String password = ConfigFileReaderUtils.getProperty("db.password");

    private static Connection con;
    private static Statement stmt;
    private static ResultSet rs;

    public static void initDatabase() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            con = DriverManager.getConnection(hostUrl, userName, password);
            stmt = con.createStatement();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

    public static ResultSet executeQuery(String query) {
        try {
            rs = stmt.executeQuery(query);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
        return rs;
    }

    public static void closeDatabase() {
        try {
            con.close();
            stmt.close();
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException();
        }
    }

}
