/*
    * DBContext.java
    *
    * All Rights Reserved.
    * Copyright (c)  2020 FPT University
*/
package db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 * Class DBContext để thao tác kết nối với DB <br>
 * 
 * <pre>
 * Class thực hiện xử lý giữa DB và java
 * Class thực hiện xử lí sau.
 * getConnection() : kết nối với DB
 * closeConnection() : đóng kết nối với DB
 * </pre>
 * 
 * @author hoangnm
 * @version 1.0
 */
public class DBContext {
    /**
     * Store host name
     */
    public static final String HOSTNAME = "localhost";
    /**
     * Store PORT
     */
    public static final String PORT = "1433";
    /**
     * Store DB NAME
     */
    public static final String DBNAME = "J3LP0015";
    /**
     * Store INTEGRATED_SECURITY
     */
    public static final String INTEGRATED_SECURITY = "true";
    
    /**
     * Get connection to MSSQL Server
     *  
     *<pre>
     * ◆Trình tự xử lí
     *  1. Tạo string connectionUrl để lưu cấu trúc url connection với DB
     *  2. Khai báo driver cho SQL server
     * ◆Xử lí Exception
     *  ・Trường hợp lấy dữ liệu thất bại, sinh SQLException và throw về nơi gọi ra
     * </pre>
     * 
     * @return Connection
     */
    public  Connection getConnection() {
        System.out.println("aaaaa");
        String connectionUrl = "jdbc:sqlserver://" + HOSTNAME + ":" + PORT + ";"
                + "databaseName=" + DBNAME + ";"
                + "integratedSecurity=" + INTEGRATED_SECURITY;

        try {
            Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
            return DriverManager.getConnection(connectionUrl);
        } // Handle any errors that may have occurred.
        catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace(System.out);
        }
        return null;
    }
    /**
     * Close connection in MSQL Server
     * 
     * @param con
     * @param ps
     * @param rs
     * @throws SQLException 
     */
    public void closeConnection(Connection con, PreparedStatement ps, ResultSet rs) throws SQLException {
        if (rs != null && !rs.isClosed()) {
            rs.close();
        }
        if (ps != null && !ps.isClosed()) {
            ps.close();
        }
        if (con != null && !con.isClosed()) {
            con.close();
        }
    }
   
}

