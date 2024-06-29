package edu.ncuky.fruit.tools;

import java.sql.*;

import static jdk.internal.net.http.common.Utils.close;
    public class JDBCTools {
        public static Connection getConnection() throws ClassNotFoundException, SQLException {
            // 1. 注册数据库的驱动
            Class.forName("com.mysql.cj.jdbc.Driver");
            // 2.通过DriverManager获取数据库连接
            String url = "jdbc:mysql://localhost:3306/fruitmarket" +
                    "?serverTimezone=GMT%2B8&useSSL=false";
            String username = "root";    //数据库用户名
            String password = "123456";    //数据库密码
            Connection conn = DriverManager.getConnection(url, username, password);
            return conn;
        }
        //适用于查询操作的资源释放
        public static void release(ResultSet rs, Statement stmt,Connection conn){
            // 6.回收数据库资源
            if (rs != null) {
                try {
                    rs.close();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                rs = null;
            }
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
        //适用于添、删、改操作的资源释放
        public static void release(Statement stmt,Connection conn){
            // 6.回收数据库资源
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
