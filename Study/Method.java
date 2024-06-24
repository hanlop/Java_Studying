package Study;
import java.util.Scanner;
public class Method {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        System.out.println("请输入第一个值:");
        int a=sc.nextInt();
        System.out.println("请输入第二个值:");
        int b=sc.nextInt();
        System.out.println("请输入第三个值:");
        int c=sc.nextInt();

        getmid(a,b,c);

    }

    public static void getmid(int a,int b,int c){
            if(a>b)
            {
                if(c>a)
                {
                    System.out.println("中间值:"+a);
                }
                else if(b>c)
                {
                    System.out.println("中间值:"+b);
                }
                else
                {
                    System.out.println("中间值:"+c);
                }
            }
            else if(b>a)
            {
                if(c>b)
                {
                    System.out.println("中间值:"+b);
                }
                else if(c<a)
                {
                    System.out.println("中间值:"+a);
                }
                else
                {
                    System.out.println("中间值:"+c);
                }
            }
    }
}
