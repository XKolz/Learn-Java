package Learn_Java_1;
import java.util.ArrayList;

public class LambdaExample {
    public static void main(String[] args) {
        ArrayList<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);

        // Using lambda to iterate
        numbers.forEach(number -> System.out.println(number));
    }
}
