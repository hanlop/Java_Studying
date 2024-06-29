package edu.ncuky.fruit.viewer;

import edu.ncuky.fruit.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractMainFrame extends JFrame {
    private JLabel titleLabel=new JLabel(new ImageIcon("img/FruitStore.png"));
    private JButton btn=new JButton("进入系统");

    public AbstractMainFrame(){
        init();
        addComponent();
        addListener();
    }
    //窗口初始化
    private void init() {
        setTitle("水果超市欢迎你！");
        setSize(600, 400);
        GUITools.center(this);
        GUITools.setTitleImage(this, "img/title.png");
        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    //添加组件
    private void addComponent(){
        add(titleLabel, BorderLayout.NORTH);
        JPanel btnPanel=new JPanel();
        btnPanel.setLayout(null);
        btn.setBounds(240,20,120,50);
        btnPanel.add(btn);
        this.add(btnPanel);
    }
    //添加监听器
    private void addListener(){
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                showAdminDialog();
            }
        });
    }

    public abstract void showAdminDialog();
}
