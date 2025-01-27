import java.util.ArrayList;

public class CollectionsExample {
    public static void main(String[] args) {
        // Create an ArrayList
        ArrayList<String> fruits = new ArrayList<>();

        // Add items to the list
        fruits.add("Apple");
        fruits.add("Banana");
        fruits.add("Cherry");

        // Iterate through the list
        System.out.println("Fruits in the list:");
        for (String fruit : fruits) {
            System.out.println(fruit);
        }
    }
}
