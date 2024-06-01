package examtion.staurday;

public class ZiDingYiLei
{
    // 私有成员变量
    private String mingzi;
    private int nianling;

    // 静态代码块
    static
    {
        System.out.println("静态代码块：类加载时执行");
    }

    // 构造块
    {
        System.out.println("构造块：对象创建时执行");
    }

    // 无参构造器
    public ZiDingYiLei()
    {
        this.mingzi = "默认名";
        this.nianling = 0;
        System.out.println("无参构造器：创建默认对象");
    }

    // 有参构造器
    public ZiDingYiLei(String mingzi, int nianling)
    {
        this.mingzi = mingzi;
        this.nianling = nianling;
        System.out.println("有参构造器：创建带参数的对象");
    }

    // Getter方法
    public String getMingzi()
    {
        return mingzi;
    }

    public int getNianling()
    {
        return nianling;
    }

    // Setter方法
    public void setMingzi(String mingzi)
    {
        this.mingzi = mingzi;
    }

    public void setNianling(int nianling)
    {
        this.nianling = nianling;
    }

    // toString()方法
    @Override
    public String toString()
    {
        return "ZiDingYiLei{mingzi='" + mingzi + "', nianling=" + nianling + "}";
    }

    // 主方法，测试代码
    public static void main(String[] args)
    {
        System.out.println("使用无参构造器创建第一个对象：");
        ZiDingYiLei duixiang1 = new ZiDingYiLei();
        System.out.println(duixiang1);

        System.out.println("\n使用有参构造器创建第二个对象：");
        ZiDingYiLei duixiang2 = new ZiDingYiLei("小明", 25);
        System.out.println(duixiang2);
    }
}
