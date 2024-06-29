package edu.ncuky.fruit.viewer;

import edu.ncuky.fruit.tools.GUITools;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public abstract class AbstractAdminDialog extends JDialog {
    private JLabel tableTitle = new JLabel("水果列表");
    protected JTable table = new JTable();
    private JScrollPane tablePane = new JScrollPane();
    //数据标题
    private JLabel numberLabel = new JLabel("水果编号");
    private JLabel nameLabel = new JLabel("水果名称");
    private JLabel priceLabel = new JLabel("水果单价");
    private JLabel unitLabel = new JLabel("计价单位");
    //添加功能组件
    protected JTextField addNumberText = new JTextField(6);
    protected JTextField addNameText = new JTextField(6);
    protected JTextField addPriceText = new JTextField(6);
    protected JTextField addUnitText = new JTextField(6);
    private JButton addBtn = new JButton("添加水果");
    //修改功能组件
    protected JTextField updateNumberText = new JTextField(6);
    protected JTextField updateNameText = new JTextField(6);
    protected JTextField updatePriceText = new JTextField(6);
    protected JTextField updateUnitText = new JTextField(6);
    private JButton updateBtn = new JButton("修改水果");
    //删除功能组件
    protected JTextField deleteNumberText = new JTextField(6);
    private JButton deleteBtn = new JButton("删除水果");
    //查询功能组件
    protected JTextField queryNumberText = new JTextField(6);
    protected JTextField queryNameText = new JTextField(6);
    protected JTextField queryPriceText = new JTextField(6);
    protected JTextField queryUnitText = new JTextField(6);
    private JButton queryBtn = new JButton("查询水果");

    public AbstractAdminDialog() {
        this(null, true);
    }

    public AbstractAdminDialog(Frame owner, boolean modal) {
        super(owner, modal);
        init();
        addComponent();
        addListener();
    }

    //初始化对话框
    private void init() {
        setTitle("水果超市货物管理");
        setSize(600, 480);
        GUITools.center(this);
        setResizable(false);
    }

    //添加组件
    private void addComponent() {
        setLayout(null);
        tableTitle.setBounds(265, 20, 70, 25);
        add(tableTitle);
        table.getTableHeader().setReorderingAllowed(false);
        table.getTableHeader().setResizingAllowed(false);
        table.setEnabled(false);
        tablePane.setBounds(50, 50, 500, 200);
        tablePane.setViewportView(table);
        add(tablePane);
        //设置并添加数据字段标题
        numberLabel.setBounds(50, 250, 70, 25);
        nameLabel.setBounds(150, 250, 70, 25);
        priceLabel.setBounds(250, 250, 70, 25);
        unitLabel.setBounds(350, 250, 70, 25);
        add(numberLabel);
        add(nameLabel);
        add(priceLabel);
        add(unitLabel);
        //设置并添加增加组件
        addNumberText.setBounds(50, 280, 80, 25);
        addNameText.setBounds(150, 280, 80, 25);
        addPriceText.setBounds(250, 280, 80, 25);
        addUnitText.setBounds(350, 280, 80, 25);
        addBtn.setBounds(460, 280, 90, 25);
        add(addNumberText);
        add(addNameText);
        add(addPriceText);
        add(addUnitText);
        add(addBtn);
        //设置并添加修改组件
        updateNumberText.setBounds(50, 310, 80, 25);
        updateNameText.setBounds(150, 310, 80, 25);
        updatePriceText.setBounds(250, 310, 80, 25);
        updateUnitText.setBounds(350, 310, 80, 25);
        updateBtn.setBounds(460, 310, 90, 25);
        add(updateNumberText);
        add(updateNameText);
        add(updatePriceText);
        add(updateUnitText);
        add(updateBtn);
        //设置并添加修改组件
        deleteNumberText.setBounds(50, 340, 80, 25);
        deleteBtn.setBounds(460, 340, 90, 25);
        add(deleteNumberText);
        add(deleteBtn);
        //设置并查询修改组件
        queryNumberText.setBounds(50, 370, 80, 25);
        queryNameText.setBounds(150, 370, 80, 25);
        queryPriceText.setBounds(250, 370, 80, 25);
        queryUnitText.setBounds(350, 370, 80, 25);
        queryBtn.setBounds(460, 370, 90, 25);
        add(queryNumberText);
        add(queryNameText);
        add(queryPriceText);
        add(queryUnitText);
        add(queryBtn);
    }

    //添加监听器
    private void addListener() {
        addBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                addFruit();
            }
        });
        updateBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateFruit();
            }
        });
        deleteBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                deleteFruit();
            }
        });
        queryBtn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                queryFruitsByCond();
            }
        });
    }

    protected abstract void queryAllFruits();
    public abstract void addFruit();
    public abstract void updateFruit();
    public abstract void deleteFruit();
    public abstract void queryFruitsByCond();

}
