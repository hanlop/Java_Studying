package edu.nucky.fruitmarket.web.dao;


import edu.nucky.fruitmarket.web.bean.Fruit;
import edu.nucky.fruitmarket.web.bean.User;
import edu.nucky.fruitmarket.web.tools.JDBCTools;

import java.sql.*;
import java.util.ArrayList;

public class FruitDao {
    public ArrayList<Fruit> queryAllFruit()
    {
        Statement stmt = null;
        ResultSet rs = null;
        Connection conn = null;
        ArrayList <Fruit> frutis=new ArrayList<>();
        try{
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from fruit";
            rs = stmt.executeQuery(sql);
            while (rs.next()) {
                Fruit fruit=new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                fruit.setImgUrl(rs.getString("imgUrl"));
                frutis.add(fruit);
            }
//            System.out.println(frutis);
        }catch (ClassNotFoundException e){e.printStackTrace();}
        catch(SQLException throwables) {throwables.printStackTrace();}
        finally { JDBCTools.release(rs,stmt,conn);}
        return frutis; }
    //添加水果
    public  void  addFruit(Fruit fruit)
    {
        Connection conn=null;
        //  Statement stmt=null;
        PreparedStatement pstmt = null;
        try{
            conn=JDBCTools.getConnection();
//            stmt=conn.createStatement();
//            String sql="insert into fruit(number,name,price,unit) values('"+fruit.getNumber()
//                    +"','"+fruit.getName()+"','"+fruit.getPrice()+"','"+fruit.getUnit()+"')";
//            int n=stmt.executeUpdate(sql);
            String sql="insert into fruit(number,name,price,unit) values(?,?,?,?)";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,fruit.getNumber());
            pstmt.setString(2,fruit.getName());
            pstmt.setDouble(3,fruit.getPrice());
            pstmt.setString(4,fruit.getUnit());
            int n=pstmt.executeUpdate();
            if (n>0);
            {System.out.println("数据添加成功");}
        }catch (ClassNotFoundException e){e.printStackTrace();}
        catch(SQLException throwables) {throwables.printStackTrace();}
        finally { JDBCTools.release(pstmt,conn);}
    }
    //修改水果信息
    public void updateFruit(Fruit fruit){
        Connection conn = null;
//        Statement stmt = null;
        PreparedStatement pstmt=null;
        try {
            conn = JDBCTools.getConnection();
//            stmt = conn.createStatement();
//            String sql="update fruit set name='"+fruit.getName()+"',price='"+fruit.getPrice()
//                    +"',unit='"+fruit.getUnit()+"'where number='"+fruit.getNumber()+"'";
//            int n=stmt.executeUpdate(sql);
            String sql="update fruit set name=?,price=?,unit=? where number=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,fruit.getName());
            pstmt.setDouble(2,fruit.getPrice());
            pstmt.setString(3,fruit.getUnit());
            pstmt.setString(4,fruit.getNumber());
            int n=pstmt.executeUpdate();
            if (n>0){
                System.out.println("数据修改成功");
            }
        }catch (ClassNotFoundException e){
            e.printStackTrace();
        }catch (SQLException throwables){
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(pstmt,conn);
        }
    }
    //删除水果信息
    public  void  delFruit(String number)
    { Connection conn=null;
//        Statement stmt=null;
        PreparedStatement pstmt=null;
        try{
            conn=JDBCTools.getConnection();
//            stmt=conn.createStatement();
//            String sql="delete from fruit where number='"+number+"'";
//            int n=stmt.executeUpdate(sql);
            String sql="delete from fruit where number=?";
            pstmt=conn.prepareStatement(sql);
            pstmt.setString(1,number);
            int n=pstmt.executeUpdate();
            if (n>0)
            {System.out.println("数据删除成功");}
        }catch (ClassNotFoundException e){e.printStackTrace();}
        catch(SQLException throwables) {throwables.printStackTrace();}
        finally { JDBCTools.release(pstmt,conn);}
    }
    //条件查询水果信息
    public ArrayList<Fruit> queryFruitByCond(Fruit fruit)
    {
        /*
        select * from fruit;// select * from fruit where 1=1;
        select * from fruit where number="001";//select * from fruit where 1=1 and number="001";
       select * from fruit where name like name="%果%" and price=5.0 ;select * from fruit where 1=1 and name like name="%果%" and price=5.0 ;

         */
//        Statement stmt = null;
        PreparedStatement pstmt=null;
        ResultSet rs = null;
        Connection conn = null;
        ArrayList <Fruit> frutis=new ArrayList<>();
        ArrayList value =new ArrayList();   //value集合保存查询条件参数值
        ArrayList<String> type=new ArrayList<>(); //type集合保存查询条件参数类型
        int count=0;//count变量保存查询条件参数个数
        try{
            conn = JDBCTools.getConnection();
//            stmt = conn.createStatement();
            String sql = "select * from fruit where 1=1" ;
//            if (fruit.getNumber()!=null && fruit.getNumber().length()>0)
//                sql+=" and number ='"+fruit.getNumber()+"'";
//            if (fruit.getName()!=null && fruit.getName().length()>0)
//                sql+=" and name like '%"+fruit.getName()+"%'";
//            if (fruit.getPrice()!=null )
//                sql+=" and price'"+fruit.getPrice()+"'";
//            if (fruit.getUnit()!=null && fruit.getUnit().length()>0)
//                sql+=" and unit like '%"+fruit.getUnit()+"%'";
//            rs = stmt.executeQuery(sql);

            if (fruit.getNumber()!=null && fruit.getNumber().length()>0)
            {sql+="  and  number= ? ";
                value.add(fruit.getNumber());
                type.add("StringOne");
                count++;
            }
            if (fruit.getName()!=null && fruit.getName().length()>0)
            { sql+="  and  name like ?";
                value.add(fruit.getName());
                type.add("StringTwo");
                count++;
            }
            if (fruit.getPrice()!=null )
            {
                sql+=" and price =?";
                value.add(fruit.getPrice());
                type.add("Double");
                count++;
            }
            if (fruit.getUnit()!=null && fruit.getUnit().length()>0)
            {
                sql+="  and  unit like ?";
                value.add(fruit.getUnit());
                type.add("StringTwo");
                count++;
            }
            pstmt=conn.prepareStatement(sql);
            for (int i=1;i<=count;i++)
            {
                if ("StringOne".equals(type.get(i-1)))
                    pstmt.setString(i,(String) value.get(i-1));
                if ("StringTwo".equals(type.get(i-1)))
                    pstmt.setString(i,"%"+ value.get(i-1)+"%");
                if ("Double".equals(type.get(i-1)))
                    pstmt.setDouble(i,(Double) value.get(i-1));

            }
            rs=pstmt.executeQuery();
            while (rs.next()) {
                Fruit f=new Fruit();
                f.setNumber(rs.getString("number"));
                f.setName(rs.getString("name"));
                f.setPrice(rs.getDouble("price"));
                f.setUnit(rs.getString("unit"));
                f.setImgUrl(rs.getString("imgUrl"));
                frutis.add(f);
            }
        }catch (ClassNotFoundException e)
        {
            e.printStackTrace();
        } catch(SQLException throwables) {
            throwables.printStackTrace();
        } finally {
            JDBCTools.release(rs,pstmt,conn);
        }
        return frutis;
    }
    public static void  pass(User user){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        try {
            conn= JDBCTools.getConnection();
            stmt=conn.createStatement();
            String sql ="update user set username='"+user.getUsername()+"',password='"+user.getPassword()+"'where id='"
                    +user.getId()+"'";
            int num=stmt.executeUpdate(sql);
            if(num>0){
                System.out.println("修改密码成功");
            }
        }catch (Exception e){
            e.printStackTrace();
        }finally {
            JDBCTools.release(rs,stmt,conn);
        }
    }
    public ArrayList<User> queryUserData(){
        Connection conn = null;
        Statement stmt = null;
        ResultSet rs = null;
        ArrayList<User> list = new ArrayList<User>();
        try {
            conn = JDBCTools.getConnection();
            stmt = conn.createStatement();
            String sql = "select * from user";
            rs = stmt.executeQuery(sql);
            while (rs.next()){
                User user = new User();
                user.setId(rs.getInt("id"));
                user.setUsername(rs.getString("username"));
                user.setPassword(rs.getString("password"));
                list.add(user);
            }
        } catch (Exception e){
            e.printStackTrace();
        }
        finally {
            JDBCTools.release(rs,stmt,conn);
        }
        return list;
    }
    //升序
    public ArrayList<Fruit> sortFruit(String sort){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Fruit> fruits=new ArrayList<Fruit>();
        try { conn= JDBCTools.getConnection();
            stmt=conn.createStatement();
            String sql="select * from fruit order  by "+sort;
            rs=stmt.executeQuery(sql); //封装查询结果
            while (rs.next()){
                Fruit fruit=new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                fruit.setImgUrl(rs.getString("imgUrl"));
                fruits.add(fruit); }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            JDBCTools.release(rs,stmt,conn); }
        return fruits; }
    //降序
    public ArrayList<Fruit> sortDecFruit(String sort1){
        Connection conn=null;
        Statement stmt=null;
        ResultSet rs=null;
        ArrayList<Fruit> fruits=new ArrayList<Fruit>();
        try {
            conn= JDBCTools.getConnection();
            stmt=conn.createStatement();
            String sql="select * from fruit order  by "+sort1+" desc";
            rs=stmt.executeQuery(sql);//封装查询结果
            while (rs.next()){
                Fruit fruit=new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                fruit.setImgUrl(rs.getString("imgUrl"));
                fruits.add(fruit); }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally { JDBCTools.release(rs,stmt,conn); }
        return fruits; }
    public int getTotalCount(){
        String sql="SELECT COUNT(1) FROM fruit";
        Connection conn = null;
        PreparedStatement preparedStatement=null;
        ResultSet rs = null;
        int count=-1;
        try {
            conn = JDBCTools.getConnection();
            preparedStatement= conn.prepareStatement(sql);
            rs=preparedStatement.executeQuery();
            if(rs.next())
            {count= rs.getInt(1); }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally { JDBCTools.release(rs,preparedStatement,conn); }
        return count; }


    //展示所有数据
    public ArrayList<Fruit> queryPageData(int PageCode, int PageSize) {
        Connection conn = null;
        ResultSet rs = null;
        PreparedStatement pspm=null;
        ArrayList<Fruit> list = new ArrayList<Fruit>();
        try { conn = JDBCTools.getConnection();
            String sql = "select * from fruit limit ?,?";
            pspm= conn.prepareStatement(sql);
            pspm.setInt(1 ,PageSize*(PageCode-1));
            pspm.setInt(2 ,PageSize);
            rs=pspm.executeQuery();
            while (rs.next()) {
                Fruit fruit= new Fruit();
                fruit.setNumber(rs.getString("number"));
                fruit.setName(rs.getString("name"));
                fruit.setPrice(rs.getDouble("price"));
                fruit.setUnit(rs.getString("unit"));
                fruit.setImgUrl(rs.getString("imgUrl"));
                list.add(fruit);
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            JDBCTools.release(rs, pspm, conn); }
        return list; }

}
