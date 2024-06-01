package examtion.staurday;

class Animal {
    public void makeSound() {
        System.out.println("动物发出声音");
    }
}

class Dog extends Animal {
    @Override
    public void makeSound() {
        System.out.println("汪汪汪~");
    }
}

class Cat extends Animal {
    @Override
    public void makeSound() {
        System.out.println("喵喵喵~");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Animal animal1 = new Dog();
        Animal animal2 = new Cat();

        animal1.makeSound();
        animal2.makeSound();

        // 使用 instanceof 进行类型检查
        if (animal1 instanceof Dog) {
            Dog dog = (Dog) animal1;
            dog.makeSound();
        } else if (animal1 instanceof Cat) {
            Cat cat = (Cat) animal1;
            cat.makeSound();
        }
    }
}
