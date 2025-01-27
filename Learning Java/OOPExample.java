// Define a class
class Person {
    String name;
    int age;

    // Constructor
    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Method to display details
    void displayDetails() {
        System.out.println("Name: " + name);
        System.out.println("Age: " + age);
    }
}

// Main class
public class OOPExample {
    public static void main(String[] args) {
        // Create an object
        Person person = new Person("Samuel", 25);
        person.displayDetails();
    }
}
