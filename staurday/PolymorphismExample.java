package examtion.staurday;

class Animal {
    public void makeSound() {
        System.out.println("���﷢������");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("������~");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("������~");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound();
        animal2.makeSound();

        // ʹ�� instanceof �������ͼ��
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;
            dog.makeSound();
        } else if (animal1 instanceof Cat) {
            Cat cat = (Cat) animal1;
            cat.makeSound();
        }
    }
}
