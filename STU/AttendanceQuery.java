package GUI.STU;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/*
    案例: GUI案例5(考勤查询日历控件)
        用日历控件,改进考勤查询的日期字符串填写

    日期控件使用步骤
        1. 创建日期选择器对象，指定日期字符串格式
        DateChooser dateChooser = DateChooser.getInstance("yyyy-MM-dd");
        2. 文本框对象
        JTextField showDateField = new JTextField("单击选择日期");
        showDateField.setBounds(50, 50, 100, 20);
        3. 把日历控件和文本框进行绑定
        dateChooser.register(showDateField);

    最终需求:
        根据开始时间和结束时间的字符串
        解析为日期提示出来

 */
public class AttendanceQuery {
    public static void main(String[] args) {
        JFrame jf = new JFrame();
        jf.setSize(400, 300);
        jf.setTitle("考勤查询");//设置窗体标题
        jf.setLocationRelativeTo(null);//设置窗体位置在中央弹出
        jf.setDefaultCloseOperation(3);//设置窗体关闭停止程序
        jf.setAlwaysOnTop(true);//设置窗体置顶
        jf.setLayout(null);//取消默认布局

        //创建日期选择器对象，指定日期字符串格
        DateChooser dateChooser1 = DateChooser.getInstance("yyyy-MM-dd"); //日历控件展示的格式
        DateChooser dateChooser2 = DateChooser.getInstance("yyyy-MM-dd");

        //考勤日期文本
        JLabel date = new JLabel("考勤日期");
        date.setBounds(50, 20, 100, 20);
        jf.add(date);

        //开始时间文本
        JLabel startTime = new JLabel("开始时间");
        startTime.setBounds(50, 70, 100, 20);
        jf.add(startTime);
        //开始时间文本框
        JTextField startTimeText = new JTextField();
        startTimeText.setBounds(50, 100, 100, 20);
        //把日历控件和文本框进行绑定
        dateChooser1.register(startTimeText);
        jf.add(startTimeText);

        //结束时间文本
        JLabel endTime = new JLabel("结束时间");
        endTime.setBounds(250, 70, 100, 20);
        jf.add(endTime);
        //结束时间文本框
        JTextField endTimeText = new JTextField();
        endTimeText.setBounds(250, 100, 100, 20);
        //把日历控件和文本框进行绑定
        dateChooser2.register(endTimeText);
        jf.add(endTimeText);

        //确定按钮
        JButton btn = new JButton("确定");
        btn.setBounds(250, 180, 60, 20);
        jf.add(btn);

        //给确定按钮加入点击事件
        btn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //定义日期格式化对象 -> 解析 -> 格式要和字符串一致
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                //分别获取文本框的开始时间和结束时间
                String startTimeStr = startTimeText.getText();
                String endTimeStr = endTimeText.getText();
                try{
                    //分别解析两个字符串,得到两个Date对象
                    Date startDate = sdf.parse(startTimeStr); //这里出现异常, alt+回车解决即可
                    Date endDate = sdf.parse(endTimeStr);
                    //弹框打印Date对象 -> 加了一个换行
                    JOptionPane.showMessageDialog(jf, startDate + "\n" + endDate);
                }catch (ParseException ee){
                    ee.printStackTrace();
                }
            }
        });

        jf.setVisible(true);//设置显示窗体(一般写在最后)
    }
}
