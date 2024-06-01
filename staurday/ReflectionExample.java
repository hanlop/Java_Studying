package examtion.staurday;

import java.lang.reflect.*;

public class ReflectionExample {
    public static void main(String[] args) {
        try {
            // 通过反射创建 Dog 类的实例
            Class<?> dogClass = Class.forName("examtion.staurday.dog");
            Object dogInstance = dogClass.newInstance();

            // 调用 eat() 方法
            Method eatMethod = dogClass.getMethod("eat");
            eatMethod.invoke(dogInstance);

            // 遍历所有构造方法
            Constructor<?>[] constructors = dogClass.getDeclaredConstructors();
            System.out.println("所有构造方法：");
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
        System.out.println("狗吃肉");
    }

    private void jump() {
        System.out.println("狗急了跳墙");
    }

    @Override
    public String toString() {
        return "dog{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
