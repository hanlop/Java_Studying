package edu.ncuky.fruitmarket.web.dao;

import edu.ncuky.fruitmarket.web.bean.User;
import edu.ncuky.fruitmarket.web.tools.JDBCTools;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UserDao {
    public String login(User user){
        Connection conn=null;
        //Statement stmt=null;
        PreparedStatement pstmt=null;
        ResultSet rs=null;

       // String sql="select * from user where username='"+user.getUsername()+"'and password='"+user.getPassword()+"'";
        String sql="select * from user where username=? and password=?";
        try {
            conn= JDBCTools.getConnection();
            //stmt=conn.createStatement();
            //rs=stmt.executeQuery(sql);
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,user.getUsername());
            pstmt.setString(2,user.getPassword());
            rs=pstmt.executeQuery();
            if (rs.next())
                return "ok";
            else
                return "err1";      //err1表示登陆失败
        } catch (SQLException e) {
            e.printStackTrace();
            return "err2";      //err2表示sql语句错误
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
            return "err3";      //err3表示数据库驱动错误
        }finally {
            JDBCTools.release(rs,pstmt,conn);
        }
    }
}
