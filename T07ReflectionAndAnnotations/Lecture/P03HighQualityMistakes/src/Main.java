import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<?> reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();
        Arrays.stream(reflectionClass.getDeclaredFields())
                .filter(f -> !Modifier.isPrivate(f.getModifiers()))
                .sorted(Comparator.comparing(Field::getName))
                .forEach(f -> System.out.printf("%s must be private!%n", f.getName()));

        List<Method> listOfGettersAndSetters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());

        for (Method method : listOfGettersAndSetters) {
            if (method.getName().startsWith("get")) {
                if (!Modifier.isPublic(method.getModifiers())) {
                    System.out.printf("%s have to be public!%n", method.getName());
                }
            } else {
                if (!Modifier.isPrivate(method.getModifiers())) {
                    System.out.printf("%s have to be private!%n", method.getName());
                }
            }
        }
    }
}
