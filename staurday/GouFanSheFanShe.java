package examtion.staurday;

import java.lang.reflect.*;

public class GouFanSheFanShe
{
    public static void main(String[] args) throws Exception
    {
        // ʹ�÷��䴴�� dog ����
        Class<?> gouLei = Class.forName("examtion.staurday.gou");
        Constructor<?>[] gouGouZao = gouLei.getDeclaredConstructors();

        // ��������ӡ���й��췽��
        System.out.println("���й��췽����");
        for (Constructor<?> gouZao : gouGouZao)
        {
            System.out.println(gouZao);
        }

        // �����޲ι��췽������ʵ��
        Object gouShiLi = gouLei.getDeclaredConstructor().newInstance();

        // ���� eat ����
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
        System.out.println("������");
    }

    private void tiao()
    {
        System.out.println("��������ǽ");
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
