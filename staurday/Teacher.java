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

    // ʵ����Ȼ����
    @Override
    public int compareTo(Teacher other) {
        // ���Ȱ����併������
        int ageComparison = Integer.compare(other.age, this.age);
        if (ageComparison != 0) {
            return ageComparison;
        }
        // ������ͬ������°����ֽ�������
        return other.name.compareTo(this.name);
    }

    public static void main(String[] args) {
        Teacher a = new Teacher("jack", 15);
        Teacher b = new Teacher("marry", 14);
        Teacher c = new Teacher("tom", 15);
        Teacher d = new Teacher("lucy", 16);
        Teacher e = new Teacher("pink", 17);

        // ʹ����Ȼ����
        TreeSet<Teacher> naturalOrderSet = new TreeSet<>();
        naturalOrderSet.add(a);
        naturalOrderSet.add(b);
        naturalOrderSet.add(c);
        naturalOrderSet.add(d);
        naturalOrderSet.add(e);
        System.out.println("��Ȼ������������");
        for (Teacher teacher : naturalOrderSet) {
            System.out.println(teacher);
        }

        // ʹ���Զ�������
        TreeSet<Teacher> customOrderSet = new TreeSet<>(new Comparator<Teacher>() {
            @Override
            public int compare(Teacher teacher1, Teacher teacher2) {
                // ���Ȱ����併������
                int ageComparison = Integer.compare(teacher2.age, teacher1.age);
                if (ageComparison != 0) {
                    return ageComparison;
                }
                // ������ͬ������°����ֽ�������
                return teacher2.name.compareTo(teacher1.name);
            }
        });
        customOrderSet.add(a);
        customOrderSet.add(b);
        customOrderSet.add(c);
        customOrderSet.add(d);
        customOrderSet.add(e);
        System.out.println("\n�Զ���������������");
        for (Teacher teacher : customOrderSet) {
            System.out.println(teacher);
        }
    }
}

