package edu.nucky.fruitmarket.web.tools;


import java.sql.*;

public class JDBCTools {
    public static Connection getConnection() throws ClassNotFoundException, SQLException {
        //注册数据库驱动
        Class.forName("com.mysql.cj.jdbc.Driver");
        //通过DriverManger获取数据库连接
        String url = "jdbc:mysql://localhost:3306/fruitmarket" +
                "?serverTimerzone=GMT%2B8&useSSL=false";
        String username = "root";
        String password = "ct2717043293.";
        Connection conn = DriverManager.getConnection(url, username, password);
        return conn;
    }

    //使用与查询操作的资源释放
    public static void release(ResultSet rs, Statement stmt, Connection conn) {
        if (rs != null) {
            try {
                rs.close();
            } catch (SQLException e) {
                e.getStackTrace();
            }
            rs = null;
        }
        if (stmt != null) {
            try {
                stmt.close();
            } catch (SQLException e) {
                e.getStackTrace();
            }
            stmt = null;
        }
        if (conn != null) {
            try {
                conn.close();
            } catch (SQLException e) {
                e.getStackTrace();
            }
            conn = null;
            //使用与添，删，改的资源释放
        }
    }
        public static void release ( Statement stmt, Connection conn){
            if (stmt != null) {
                try {
                    stmt.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                stmt = null;
            }
            if (conn != null) {
                try {
                    conn.close();

                } catch (SQLException e) {
                    e.printStackTrace();
                }
                conn = null;
             }
        }
    }
