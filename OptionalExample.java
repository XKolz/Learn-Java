import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        Optional<String> name = Optional.ofNullable(null);

        // Use Optional to avoid null pointer exception
        System.out.println(name.orElse("Default Name"));
    }
}
