package Learn_Java_1;
abstract class Animal {
    abstract void sound(); // Abstract method

    void sleep() {
        System.out.println("Sleeping...");
    }
}

class Cat extends Animal {
    @Override
    void sound() {
        System.out.println("Meow");
    }
}

public class AbstractionExamples {
    public static void main(String[] args) {
        Animal cat = new Cat();
        cat.sound(); // Output: Meow
        cat.sleep(); // Output: Sleeping...
    }
}
