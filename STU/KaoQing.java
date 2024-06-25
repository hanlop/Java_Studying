package GUI.STU;

import javax.swing.*;

public class KaoQing {
    public static void main(String[] args) {
        //创建窗体对象
        JFrame jf=new JFrame();
        //窗体标题设置
        jf.setTitle("考勤");
        //窗体大小
        jf.setSize(400,300);
        //窗体关闭，控制台关闭
        jf.setDefaultCloseOperation(3);
        //窗体居中
        jf.setLocationRelativeTo(null);
        //窗体置顶
        jf.setAlwaysOnTop(true);
        //取消默认设置
        jf.setLayout(null);

        //考勤日期标签
        JLabel date=new JLabel("考勤日期");
        date.setBounds(50,20,100,20);
        jf.add(date);


        //开始时间标签
        JLabel star=new JLabel("开始时间");
        star.setBounds(50,70,100,20);
        jf.add(star);
        DateChooser date1=DateChooser.getInstance("yyyy-MM-dd");
        DateChooser date2=DateChooser.getInstance("yyyy-MM-dd");
        // 开始时间文本框
        JTextField time=new JTextField();
        time.setBounds(50,100,100,20);
        date1.register(time);
        jf.add(time);

        //结束时间标签
        JLabel end=new JLabel("结束时间");
        end.setBounds(250,70,100,20);
        jf.add(end);
        // 结束时间文本框
        JTextField endtime=new JTextField();
        endtime.setBounds(250,100,100,20);
        date2.register(endtime);
        jf.add(endtime);


        //按钮
        JButton btn=new JButton("确定");
        btn.setBounds(250,180,60,20);
        jf.add(btn);



        //设置窗体可见
        jf.setVisible(true);

    }
}
