package Study;

public class StudentTest {
    public static void main(String[] args) {
        Student s=new Student();
        s.name="������";
        s.age=18;

        System.out.println(s.name);
        System.out.println(s.age);
        s.eat();
    }
}
