package GUI.STU;

import javax.swing.*;

public class KaoQing {
    public static void main(String[] args) {
        //�����������
        JFrame jf=new JFrame();
        //�����������
        jf.setTitle("����");
        //�����С
        jf.setSize(400,300);
        //����رգ�����̨�ر�
        jf.setDefaultCloseOperation(3);
        //�������
        jf.setLocationRelativeTo(null);
        //�����ö�
        jf.setAlwaysOnTop(true);
        //ȡ��Ĭ������
        jf.setLayout(null);

        //�������ڱ�ǩ
        JLabel date=new JLabel("��������");
        date.setBounds(50,20,100,20);
        jf.add(date);


        //��ʼʱ���ǩ
        JLabel star=new JLabel("��ʼʱ��");
        star.setBounds(50,70,100,20);
        jf.add(star);
        DateChooser date1=DateChooser.getInstance("yyyy-MM-dd");
        DateChooser date2=DateChooser.getInstance("yyyy-MM-dd");
        // ��ʼʱ���ı���
        JTextField time=new JTextField();
        time.setBounds(50,100,100,20);
        date1.register(time);
        jf.add(time);

        //����ʱ���ǩ
        JLabel end=new JLabel("����ʱ��");
        end.setBounds(250,70,100,20);
        jf.add(end);
        // ����ʱ���ı���
        JTextField endtime=new JTextField();
        endtime.setBounds(250,100,100,20);
        date2.register(endtime);
        jf.add(endtime);


        //��ť
        JButton btn=new JButton("ȷ��");
        btn.setBounds(250,180,60,20);
        jf.add(btn);



        //���ô���ɼ�
        jf.setVisible(true);

    }
}
