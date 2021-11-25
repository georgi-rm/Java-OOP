import java.util.Arrays;

public class Tracker {
    public static void printMethodsByAuthor() {
        Arrays.stream(Reflection.class.getDeclaredMethods())
                .filter(e -> e.getAnnotation(Author.class) != null)
                .map(e -> e.getAnnotation(Author.class))
                .forEach(e -> System.out.printf("Method author is: %s%n", e.name()));
    }
}
