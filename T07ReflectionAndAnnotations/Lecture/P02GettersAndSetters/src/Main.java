import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {

        Class<?> reflectionClass = Reflection.class;

        Method[] allMethods = reflectionClass.getDeclaredMethods();

        List<Method> listOfGettersAndSetters = Arrays.stream(allMethods)
                .filter(m -> m.getName().startsWith("get") || m.getName().startsWith("set"))
                .sorted(Comparator.comparing(Method::getName))
                .collect(Collectors.toList());

        for (Method method : listOfGettersAndSetters) {
            if (method.getName().startsWith("get")) {
                System.out.printf("%s will return class %s%n", method.getName(), method.getReturnType().getName());
            } else {
                Class<?>[] parameterTypes = method.getParameterTypes();
                System.out.printf("%s and will set field of class %s%n", method.getName(), parameterTypes[0].getName());
            }
        }
    }
}
