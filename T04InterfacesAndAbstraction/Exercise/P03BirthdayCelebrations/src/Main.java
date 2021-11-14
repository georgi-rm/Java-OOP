import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Birthable> birthableThings = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] entryParameters = input.split("\\s+");
            switch (entryParameters[0]) {
                case "Citizen":
                    String citizenName = entryParameters[1];
                    int citizenAge = Integer.parseInt(entryParameters[2]);
                    String citizenId = entryParameters[3];
                    String citizenBirtDate = entryParameters[4];
                    birthableThings.add(new Citizen(citizenName, citizenAge, citizenId, citizenBirtDate));
                    break;
                case "Pet":
                    String petName = entryParameters[1];
                    String petBirtDate = entryParameters[2];
                    birthableThings.add(new Pet(petName, petBirtDate));
                    break;
                case "Robot":
                    break;
            }
            input = scanner.nextLine();
        }
        String yearToSearch = scanner.nextLine();

        birthableThings.stream()
                .map(Birthable::getBirthDate)
                .filter(e -> e.endsWith(yearToSearch))
                .forEach(System.out::println);
    }
}
