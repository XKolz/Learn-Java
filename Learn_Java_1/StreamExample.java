package Learn_Java_1;
import java.util.Arrays;
import java.util.List;

public class StreamExample {
    public static void main(String[] args) {
        List<String> names = Arrays.asList("John", "Jane", "Jack", "Jill");

        // Filter names that start with 'J' and print them
        names.stream()
             .filter(name -> name.startsWith("J"))
             .forEach(System.out::println);
    }
}
