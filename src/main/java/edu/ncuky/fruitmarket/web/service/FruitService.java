package edu.ncuky.fruitmarket.web.service;

import edu.ncuky.fruitmarket.web.bean.Fruit;
import edu.ncuky.fruitmarket.web.dao.FruitDao;

import java.util.ArrayList;

public class FruitService {
    FruitDao dao=new FruitDao();
    //查询显示所有的水果信息
    public ArrayList<Fruit> queryAllFruit(){
        ArrayList<Fruit> fruits=dao.queryAllFruit();
        return fruits;
    }
    public ArrayList<Fruit> queryFruitByCond(Fruit fruit){
        ArrayList<Fruit> fruits=dao.queryFruitByCond(fruit);
        return fruits;
    }
    //添加水果信息
    public boolean addFruit(Fruit fruit){
        String number=fruit.getNumber();
        ArrayList<Fruit> fruits=queryAllFruit();
        for (Fruit f:fruits){
            if (number.equals(f.getNumber()))
                return false;
        }
        dao.addFruit(fruit);
        return true;
    }
    //修改水果信息
    public boolean updateFruit(Fruit fruit){
        String number=fruit.getNumber();
        ArrayList<Fruit> fruits=queryAllFruit();
        for (Fruit f:fruits){
            if(number.equals(f.getNumber())){
                dao.updateFruit(fruit);
                return true;
            }
        }
        return false;
    }
    //删除水果信息
    public boolean delFruit(String number){
        ArrayList<Fruit> fruits=queryAllFruit();
        for (Fruit f:fruits){
            if(number.equals(f.getNumber())){
                dao.delFruit(number);
                return true;
            }
        }
        return false;
    }
}
