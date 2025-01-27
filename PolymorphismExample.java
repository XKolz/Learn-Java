class Shape {
    void draw() {
        System.out.println("Drawing a shape.");
    }
}

class Circle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a circle.");
    }
}

class Rectangle extends Shape {
    @Override
    void draw() {
        System.out.println("Drawing a rectangle.");
    }
}

public class PolymorphismExample {
    public static void main(String[] args) {
        Shape shape;

        shape = new Circle();
        shape.draw(); // Output: Drawing a circle.

        shape = new Rectangle();
        shape.draw(); // Output: Drawing a rectangle.
    }
}
