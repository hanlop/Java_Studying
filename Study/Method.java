package Study;
import java.util.Scanner;
public class Method {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("�������һ��ֵ:");
        int a=sc.nextInt();
        System.out.println("������ڶ���ֵ:");
        int b=sc.nextInt();
        System.out.println("�����������ֵ:");
        int c=sc.nextInt();

        getmid(a,b,c);

    }

    public static void getmid(int a,int b,int c){
            if(a>b)
            {
                if(c>a)
                {
                    System.out.println("�м�ֵ:"+a);
                }
                else if(b>c)
                {
                    System.out.println("�м�ֵ:"+b);
                }
                else
                {
                    System.out.println("�м�ֵ:"+c);
                }
            }
            else if(b>a)
            {
                if(c>b)
                {
                    System.out.println("�м�ֵ:"+b);
                }
                else if(c<a)
                {
                    System.out.println("�м�ֵ:"+a);
                }
                else
                {
                    System.out.println("�м�ֵ:"+c);
                }
            }
    }
}
