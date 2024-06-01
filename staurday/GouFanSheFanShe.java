package examtion.staurday;

import java.lang.reflect.*;

public class GouFanSheFanShe
{
    public static void main(String[] args) throws Exception
    {
        // 使用反射创建 dog 对象
        Class<?> gouLei = Class.forName("examtion.staurday.gou");
        Constructor<?>[] gouGouZao = gouLei.getDeclaredConstructors();

        // 遍历并打印所有构造方法
        System.out.println("所有构造方法：");
        for (Constructor<?> gouZao : gouGouZao)
        {
            System.out.println(gouZao);
        }

        // 调用无参构造方法创建实例
        Object gouShiLi = gouLei.getDeclaredConstructor().newInstance();

        // 调用 eat 方法
        Method chiFangFa = gouLei.getMethod("chi");
        chiFangFa.invoke(gouShiLi);
    }
}

class gou
{
    private String name;
    private int age;
    public String address;

    public gou() {}

    public gou(String name, int age)
    {
        this.name = name;
        this.age = age;
    }

    private gou(String address)
    {
        this.address = address;
    }

    public void chi()
    {
        System.out.println("狗吃肉");
    }

    private void tiao()
    {
        System.out.println("狗急了跳墙");
    }

    @Override
    public String toString()
    {
        return "gou{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
