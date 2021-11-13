import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Identifiable> everyoneWhoEnters = new ArrayList<>();
        String  input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] inputParameters = input.split("\\s+");
            if (inputParameters.length == 3) {
                String name = inputParameters[0];
                int age = Integer.parseInt(inputParameters[1]);
                String id = inputParameters[2];
                everyoneWhoEnters.add(new Citizen(name, age, id));
            } else {
                String model = inputParameters[0];
                String id = inputParameters[1];
                everyoneWhoEnters.add(new Robot(model, id));
            }

            input = scanner.nextLine();
        }

        String fakeDigitsOfId = scanner.nextLine();

        everyoneWhoEnters.stream()
                .map(Identifiable::getId)
                .filter(e -> e.endsWith(fakeDigitsOfId))
                .forEach(System.out::println);
    }
}
