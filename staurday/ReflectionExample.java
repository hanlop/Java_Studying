package examtion.staurday;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // ͨ�����䴴�� Dog ���ʵ��
            Class<?> dogClass = Class.forName("examtion.staurday.dog");
            Object dogInstance = dogClass.newInstance();

            // ���� eat() ����
            Method eatMethod = dogClass.getMethod("eat");
            eatMethod.invoke(dogInstance);

            // �������й��췽��
            Constructor<?>[] constructors = dogClass.getDeclaredConstructors();
            System.out.println("���й��췽����");
            for (Constructor<?> constructor : constructors) {
                System.out.println(constructor);
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException
                | NoSuchMethodException | InvocationTargetException e) {
            e.printStackTrace();
        }
    }
}

class dog {
    private String name;
    private int age;
    public String address;

    public dog() {}

    public dog(String name, int age) {
        this.name = name;
        this.age = age;
    }

    private dog(String address) {
        this.address = address;
    }

    public void eat() {
        System.out.println("������");
    }

    private void jump() {
        System.out.println("��������ǽ");
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
