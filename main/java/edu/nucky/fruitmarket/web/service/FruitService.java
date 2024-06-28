package edu.nucky.fruitmarket.web.service;



import edu.nucky.fruitmarket.web.bean.Fruit;
import edu.nucky.fruitmarket.web.bean.User;
import edu.nucky.fruitmarket.web.dao.FruitDao;
import edu.nucky.fruitmarket.web.dao.UserDao;
import edu.nucky.fruitmarket.web.tools.JDBCTools;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class FruitService {
    FruitDao dao = new FruitDao();

    public ArrayList<Fruit> queryAllFruit() {
        ArrayList<Fruit> fruits = dao.queryAllFruit();
        return fruits;
    }

    //添加水果信息
    public boolean addFruit(Fruit fruit) {
        String number = fruit.getNumber();
        ArrayList<Fruit> fruits = queryAllFruit();
        for (Fruit f : fruits) {
            if (number.equals(f.getNumber()))
                return false;
        }
        dao.addFruit(fruit);
        return true;
    }

    //修改水果信息
    public boolean updateFruit(Fruit fruit) {
        String number = fruit.getNumber();
        ArrayList<Fruit> fruits = queryAllFruit();
        for (Fruit f : fruits) {
            if (number.equals(f.getNumber())) {
                dao.updateFruit(fruit);
                return true;
            }
        }
        return false;
    }

    //删除水果信息
    public boolean delFruit(String number) {
        ArrayList<Fruit> fruits = queryAllFruit();
        for (Fruit f : fruits) {
            if (number.equals(f.getNumber())) {
                dao.delFruit(number);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Fruit> queryFruitByCond(Fruit fruit) {
        ArrayList<Fruit> fruits = dao.queryFruitByCond(fruit);
        return fruits;

    }

    public ArrayList<User> queryUser() {
        ArrayList<User> data = dao.queryUserData();
        return data;
    }

    public boolean UpdateUser(String newpassword, String oldpassword) {
        ArrayList<User> data = queryUser();
        for (int i = 0; i < data.size(); i++) {
            User user = data.get(i);
            if (oldpassword.equals(user.getPassword())) {
                User thisUser = new User(user.getId(), user.getUsername(), newpassword);
                System.out.println(user.getId());
                System.out.println(user.getUsername());
                System.out.println(user.getPassword());
                FruitDao.pass(thisUser);
                return true;
            }
        }
        return false;
    }

    public ArrayList<Fruit> sortFruit(String sort) {
        ArrayList<Fruit> fruits = dao.sortFruit(sort);
        return fruits;


    }

    public ArrayList<Fruit> sortDecFruit(String sort1) {
        ArrayList<Fruit> fruits = dao.sortDecFruit(sort1);
        return fruits;
    }

}