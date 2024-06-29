package edu.ncuky.fruit.service;

import edu.ncuky.fruit.bean.Fruit;
import edu.ncuky.fruit.dao.FruitDao;

import java.util.ArrayList;

public class FruitService {
    FruitDao Dao=new FruitDao();
    public ArrayList<Fruit> queryAllFruit(){//查询显示所有的水果信息
        ArrayList<Fruit> fruits=Dao.queryAllFruit();
        return fruits;
    }
    //查询水果信息
    public ArrayList<Fruit> queryFruitByCond(Fruit fruit){
        ArrayList<Fruit> fruits=Dao.queryFruitByCond(fruit);
        return fruits;
    }
    //添加水果信息
    public boolean addFruit(Fruit fruit){
        String number=fruit.getNumber();
        ArrayList<Fruit> fruits=queryAllFruit();
        for(Fruit f:fruits){
            if(number.equals(f.getNumber()))
                return false;
        }
        Dao.addFruit(fruit);
        return true;
    }
    //修改水果信息
    public boolean updateFruit(Fruit fruit){
        String number=fruit.getNumber();
        ArrayList<Fruit> fruits=queryAllFruit();
        for(Fruit f:fruits){
            if(number.equals(f.getNumber()))
            {
                Dao.updateFruit(fruit);
                return true;
            }
        }return false;
    }
    //删除水果信息
    public boolean deleteFruit(String number){
        ArrayList<Fruit> fruits=queryAllFruit();
        for(Fruit f:fruits)
        {
            if(number.equals(f.getNumber()))
            {
                Dao.delFruit(number);
                return true;
            }
        }
        return false;
    }
}
