package edu.nucky.fruitmarket.web.dao;

import edu.nucky.fruitmarket.web.bean.User;
import edu.nucky.fruitmarket.web.tools.JDBCTools;

import java.sql.*;
import java.util.ArrayList;

public class UserDao {
   /* public String login(User user) {
        Connection conn = null;
        // Statement stmt = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        // String sql = "select * from user where username='" + user.getUsername() +
        // "' and password='" + user.getPassword() + "'";
        String sql = "select * from user where username=? and password=?";
        try {
            conn = JDBCTools.getConnection();
            //  stmt = conn.createStatement();
            //rs = stmt.executeQuery(sql);
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, user.getUsername());
            pstmt.setString(2, user.getPassword());
            rs = pstmt.executeQuery();

            if (rs.next())
                return "ok";
            else
                return "err1";//err1表示登录失败
        } catch (SQLException e) {
            e.printStackTrace();
            return "err2";//err2表示sql语句错误
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "err3";//err3表示数据库驱动错误
        } finally {
            JDBCTools.release(rs, pstmt, conn);
        }
    }*/
   public String login(String name,String password){
       Connection conn=null;
       Statement stmt=null;
       ResultSet rs=null;
       String sql="select * from user where username='"+name+"' and password='"+password+"'";
       System.out.println(sql);
       try{
           conn= JDBCTools.getConnection();
           stmt = conn.createStatement();
           rs=stmt.executeQuery(sql);
           if (rs.next())
           {return "1";}
           else
           {return "2";}
       }catch (ClassNotFoundException e){
           e.printStackTrace();
           return "3";
       }catch (SQLException e){
           e.printStackTrace();
           return "4";
       }finally {
           JDBCTools.release(rs,stmt,conn);
       }
   }

}
