import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] dimensions = getCoordinates(scanner.nextLine());
        int rowsOfBattleField = dimensions[0];
        int columnsOfBattleField = dimensions[1];
        BattleField battleField = new BattleField(rowsOfBattleField, columnsOfBattleField);

        String command = scanner.nextLine();

        long starsCollected = 0;
        while (!command.equals("Let the Force be with you")) {

            int[] coordinatesOfPlayer = getCoordinates(command);
            Jedi jedi = new Jedi(coordinatesOfPlayer[0], coordinatesOfPlayer[1]);

            int[] coordinatesOfEvil = getCoordinates(scanner.nextLine());
            Evil evil = new Evil(coordinatesOfEvil[0], coordinatesOfEvil[1]);

            Galaxy galaxy = new Galaxy(battleField, jedi, evil);
            galaxy.play();
            starsCollected += jedi.getCollectedStars();
            command = scanner.nextLine();
        }
        System.out.println(starsCollected);


    }

    private static int[] getCoordinates(String command) {
        return Arrays.stream(command.split("\\s+"))
                .mapToInt(Integer::parseInt)
                .toArray();
    }
}
