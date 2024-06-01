package examtion.staurday;

import java.util.*;

public class Teacher implements Comparable<Teacher> {
    public String name;
    public int age;

    public Teacher(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    // 实现自然排序法
    @Override
    public int compareTo(Teacher other) {
        // 首先按年龄降序排列
        int ageComparison = Integer.compare(other.age, this.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        // 年龄相同的情况下按名字降序排列
        return other.name.compareTo(this.name);
    }

    public static void main(String[] args) {
        Teacher a = new Teacher("jack", 15);
        Teacher b = new Teacher("marry", 14);
        Teacher c = new Teacher("tom", 15);
        Teacher d = new Teacher("lucy", 16);
        Teacher e = new Teacher("pink", 17);

        // 使用自然排序法
        TreeSet<Teacher> naturalOrderSet = new TreeSet<>();
        naturalOrderSet.add(a);
        naturalOrderSet.add(b);
        naturalOrderSet.add(c);
        naturalOrderSet.add(d);
        naturalOrderSet.add(e);
        System.out.println("自然排序法排序结果：");
        for (Teacher teacher : naturalOrderSet) {
            System.out.println(teacher);
        }

        // 使用自定义排序法
        TreeSet<Teacher> customOrderSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher teacher1, Teacher teacher2) {
                // 首先按年龄降序排列
                int ageComparison = Integer.compare(teacher2.age, teacher1.age);
                if (ageComparison != 0) {
                    return ageComparison;
                }
                // 年龄相同的情况下按名字降序排列
                return teacher2.name.compareTo(teacher1.name);
            }
        });
        customOrderSet.add(a);
        customOrderSet.add(b);
        customOrderSet.add(c);
        customOrderSet.add(d);
        customOrderSet.add(e);
        System.out.println("\n自定义排序法排序结果：");
        for (Teacher teacher : customOrderSet) {
            System.out.println(teacher);
        }
    }
}

