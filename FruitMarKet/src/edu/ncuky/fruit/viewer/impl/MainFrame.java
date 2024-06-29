package edu.ncuky.fruit.viewer.impl;

import edu.ncuky.fruit.viewer.AbstractMainFrame;

public class MainFrame extends AbstractMainFrame {
    @Override
    public void showAdminDialog() {
        System.out.println("欢迎进入管理界面！");
        new AdminDialog().setVisible(true);
    }
}
