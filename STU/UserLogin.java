package GUI.STU;

import javax.swing.*;
import javax.swing.event.AncestorEvent;
import javax.swing.event.AncestorListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/*
    案例: GUI案例1(用户登录)
        1. 已知用户名和密码
            admin
            123456
        2. 用户名和密码的长度都是6-12位
        3.点击登录按钮
            先判断输入的数据长度是否合法
            再判断是否登录成功
 */
public class UserLogin {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400, 300);
        jf.setTitle("用户登录");//设置窗体标题
        jf.setLocationRelativeTo(null);//设置窗体位置在中央弹出
        jf.setDefaultCloseOperation(3);//设置窗体关闭停止程序
        jf.setAlwaysOnTop(true);//设置窗体置顶
        jf.setLayout(null);//取消默认布局

        //用户名文本
        JLabel usernameJLabel = new JLabel("用户名");
        usernameJLabel.setBounds(50, 50, 50, 20);
        jf.add(usernameJLabel);
        //密码文本
        JLabel passwordJLabel = new JLabel("密码");
        passwordJLabel.setBounds(50, 100, 50, 20);
        jf.add(passwordJLabel);

        //用户名输入框
        JTextField usernameJTextField = new JTextField();
        usernameJTextField.setBounds(150, 50, 180, 20);
        jf.add(usernameJTextField);
        //密码输入框
        JPasswordField passwordJTextField = new JPasswordField();
        passwordJTextField.setBounds(150, 100, 180, 20);
        jf.add(passwordJTextField);

        //登录按钮
        JButton submitJButton = new JButton("登录");
        submitJButton.setBounds(50,200,280, 20);
        jf.add(submitJButton);

        //定义用户名和密码 (模拟注册的过程)
        String username = "heima001";
        String password = "123456";
        //给按钮添加点击事件
        submitJButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String name=usernameJTextField.getText();
                String pass=passwordJTextField.getText();

                //判断用户名长度
                if(name.length()<6||name.length()>12)
                {
                    JOptionPane.showMessageDialog(jf,"用户名长度6-12");
                    //弹窗提示
                    usernameJTextField.setText("");
                    return;
                }

                //判断密码长度
                if(pass.length()<6||pass.length()>12)
                {
                    JOptionPane.showMessageDialog(jf,"密码长度6-12");
                    //弹窗提示
                    passwordJTextField.setText("");
                    return;
                }


                //判断密码是否正确
                if(name.equals(username)&&pass.equals(password))
                {
                    JOptionPane.showMessageDialog(jf,"登录成功");
                    passwordJTextField.setText(" ");
                    usernameJTextField.setText(" ");
                }
                else
                {
                    JOptionPane.showMessageDialog(jf,"登录失败");
                }
            }
        });



        jf.setVisible(true);//设置显示窗体(一般写在最后)
    }
}
