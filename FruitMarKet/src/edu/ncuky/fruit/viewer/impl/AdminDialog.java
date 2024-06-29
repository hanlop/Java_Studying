package edu.ncuky.fruit.viewer.impl;

import edu.ncuky.fruit.bean.Fruit;
import edu.ncuky.fruit.service.FruitService;
import edu.ncuky.fruit.viewer.AbstractAdminDialog;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.util.ArrayList;

public class AdminDialog extends AbstractAdminDialog {
    FruitService service = new FruitService();
    public AdminDialog(){
        super();
        queryAllFruits();
    }

    @Override
    public void queryAllFruits() {
        String[] thead={"水果编号","水果名称","水果单价","计价单位"};
//        String[][] tbody= {
//                {"001","西瓜","2.5","斤"},
//                {"003","榴莲","100","个"},
//                {"005","苹果","50","箱"},
//                {"007","香蕉","5","斤"}
//        };
//        TableModel model=new DefaultTableModel(tbody,thead);
//        table.setModel(model);
        ArrayList<Fruit>fruits=service.queryAllFruit();
        String [][] tbody=listToArray(fruits);
        TableModel data=new DefaultTableModel(tbody,thead);
        table.setModel(data);
    }
    private String[][] listToArray(ArrayList<Fruit>fruits){
        String[][] body=new String[fruits.size()][4];
        for(int i=0;i<fruits.size();i++){
            Fruit fruit=fruits.get(i);
            body[i][0]=fruit.getNumber();
            body[i][1]=fruit.getName();
            body[i][2]=""+fruit.getPrice();
            body[i][3]=fruit.getUnit();
       }
        return body;
    }

    @Override
    public void addFruit() {
        String number=addNumberText.getText().trim();
        String name=addNameText.getText().trim();
        String price=addPriceText.getText().trim();
        String unit=addUnitText.getText().trim();
        if (number!=null&&number.length()>0) {
            try {
                if (Double.parseDouble(price) < 0) {
                    JOptionPane.showMessageDialog(this,
                            "水果单价不能为负数，请验证后重新输入");
                } else {
                    Fruit fruit = new Fruit(number, name, Double.parseDouble(price), unit);
                    boolean success = service.addFruit(fruit);
                    if (success) {
                        JOptionPane.showMessageDialog(this, "数据添加成功！");
                        queryAllFruits();
                        addNumberText.setText("");
                        addNameText.setText("");
                        addPriceText.setText("");
                        addUnitText.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "水果编号不能重复，请验证后再输入！");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "水果单价格式错误，请验证后再输入！");
            }
        }else{
                JOptionPane.showMessageDialog(this,
                        "水果单价不能为空，请重新输入！");
            }

//        System.out.println("添加成功");
    }

    @Override
    public void updateFruit() {
        String number=updateNumberText.getText().trim();
        String name=updateNameText.getText().trim();
        String price=updatePriceText.getText().trim();
        String unit=updateUnitText.getText().trim();
        if (number!=null&&number.length()>0) {
            try {
                if (Double.parseDouble(price) < 0) {
                    JOptionPane.showMessageDialog(this,
                            "水果单价不能为负数，请验证后重新输入");
                } else {
                    Fruit fruit = new Fruit(number, name, Double.parseDouble(price), unit);
                    boolean success = service.updateFruit(fruit);
                    if (success) {
                        JOptionPane.showMessageDialog(this,
                                "数据修改成功！");
                        queryAllFruits();
                        updateNumberText.setText("");
                        updateNameText.setText("");
                        updatePriceText.setText("");
                        updateUnitText.setText("");
                    } else {
                        JOptionPane.showMessageDialog(this,
                                "水果编号不存在，无法进行修改，请重新再输入！");
                    }
                }
            } catch (NumberFormatException e) {
                JOptionPane.showMessageDialog(this,
                        "水果单价格式错误，请验证后再输入！");
            }
        }else{
            JOptionPane.showMessageDialog(this,
                    "水果单价不能为空，请重新输入！");
        }

//        System.out.println("修改成功");
    }

    @Override
    public void deleteFruit() {
        String number=deleteNumberText.getText().trim();
        if(number!=null&&number.length()>0){
         boolean success = service.deleteFruit(number);
         if(success){
             JOptionPane.showMessageDialog(this,"数据删除成功！");
             queryAllFruits();
             deleteNumberText.setText("");
         }
         else
         {
             JOptionPane.showMessageDialog(this,
                     "水果信息不存在，无法删除，请重新输入！");
         }
        }else{
            JOptionPane.showMessageDialog(this,
                    "水果编号不能为空，请重新输入！");
        }
//        System.out.println("删除成功");
    }

    @Override
    public void queryFruitsByCond() {
        String number=queryNumberText.getText().trim();
        String name=queryNameText.getText().trim();
        String price=queryPriceText.getText().trim();
        String unit=queryUnitText.getText().trim();
        try {
            Fruit fruit = new Fruit();
            fruit.setNumber(number);
            fruit.setName(name);
            if (price != null && price.length() > 0) {
                fruit.setPrice(Double.parseDouble(price));
            } else {
                fruit.setPrice(null);
            }
            fruit.setUnit(unit);
            ArrayList<Fruit> fruits = service.queryFruitByCond(fruit);
            String[] thead = new String[]{"水果编号", "水果名称", "水果单价(元)", "计价单位"};
            String[][] tbody = listToArray(fruits);
            TableModel data = new DefaultTableModel(tbody, thead);
            table.setModel(data);
        }catch (NumberFormatException e){
            JOptionPane.showMessageDialog(this,"水果单价格式错误，请重新输入！");
        }
    }
}
