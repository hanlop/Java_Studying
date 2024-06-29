package edu.ncuky.fruit.dao;

import edu.ncuky.fruit.bean.Fruit;
import edu.ncuky.fruit.tools.JDBCTools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FruitDao {
    public ArrayList<Fruit> queryAllFruit()//查询所有的水果信息
    {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Fruit> fruits = new ArrayList<>();
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fruit";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fruit fruit = new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                fruits.add(fruit);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(rs, stmt, conn);
        }
        return fruits;
    }

    //添加水果
    public void addFruit(Fruit fruit) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "insert into fruit(number,name,price,unit) values('" + fruit.getNumber() + "','"
                    + fruit.getName() + "','" + fruit.getPrice() + "','" + fruit.getUnit() + "')";
            int n = stmt.executeUpdate(sql);
            if (n > 0) {
                System.out.println("数据添加成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(stmt, conn);
        }
    }

    //修改水果信息
    public void updateFruit(Fruit fruit) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "update fruit set name='" + fruit.getName() + "',price='" + fruit.getPrice()
                    + "',unit='" + fruit.getUnit() + "'where number='" + fruit.getNumber() + "'";
            int n = stmt.executeUpdate(sql);
            if (n > 0) {
                System.out.println("数据修改成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(stmt, conn);
        }
    }

    //删除水果信息
    public void delFruit(String number) {
        Connection conn = null;
        Statement stmt = null;
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "delete from fruit where number='" + number + "'";
            int n = stmt.executeUpdate(sql);
            if (n > 0) {
                System.out.println("数据删除成功！");
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(stmt, conn);
        }
    }

    //条件查询水果信息
    public ArrayList<Fruit> queryFruitByCond(Fruit fruit) {
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<Fruit> fruits = new ArrayList<>();
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fruit where 1=1";
            if (fruit.getNumber() != null && fruit.getNumber().length() > 0)
                sql += " and number='" + fruit.getNumber() + "'";
            if (fruit.getName() != null && fruit.getName().length() > 0) sql += " and name like '%"
                    + fruit.getName() + "%'";
            if (fruit.getPrice() != null)
                sql += " and price='" + fruit.getPrice()+"'";
            if (fruit.getUnit() != null && fruit.getUnit().length() > 0) sql += " and unit like '%"
                    + fruit.getUnit() + "%'";
                rs = stmt.executeQuery(sql);
                //封装查询结果
            while (rs.next()) {
                Fruit f = new Fruit();
                f.setNumber(rs.getString("number"));
                f.setName(rs.getString("name"));
                f.setPrice(rs.getDouble("price"));
                f.setUnit(rs.getString("unit"));
                fruits.add(f);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(rs, stmt, conn);
        }
        return fruits;
    }
        }


