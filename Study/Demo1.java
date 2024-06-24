package Study;

import java.util.Scanner;
public class Demo1 {
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);

        int a=sc.nextInt();
        int b=sc.nextInt();
        int max=getmax(a,b);

        System.out.println(max);
    }

    public static int getmax(int a,int b)
    {
        return a>b?a:b;
    }



}
