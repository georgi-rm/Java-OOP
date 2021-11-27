package blackBoxInteger;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Scanner scanner = new Scanner(System.in);

        Constructor<BlackBoxInt> blackBoxIntConstructor = BlackBoxInt.class.getDeclaredConstructor();
        blackBoxIntConstructor.setAccessible(true);
        BlackBoxInt blackBoxInt = blackBoxIntConstructor.newInstance();

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] commandData = input.split("_");
            String commandName = commandData[0];
            int value = Integer.parseInt(commandData[1]);

            Method method = blackBoxInt.getClass().getDeclaredMethod(commandName, int.class);
            method.setAccessible(true);
            method.invoke(blackBoxInt, value);

            Field fieldBlackBoxIntValue = BlackBoxInt.class.getDeclaredField("innerValue");
            fieldBlackBoxIntValue.setAccessible(true);
            System.out.println(fieldBlackBoxIntValue.get(blackBoxInt));
            input = scanner.nextLine();
        }
    }
}
