import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] weekDays = new String[5];

        weekDays[0] = "Monday";
        weekDays[1] = "Tuesday";
        weekDays[2] = "Wednesday";
        weekDays[3] = "Thursday";
        weekDays[4] = "Friday";

        for (int i = 0; i <= weekDays.length; i++) {
            try {
                System.out.println(weekDays[i]);
            } catch (ArrayIndexOutOfBoundsException ex) {
                break;
            }
        }

        scanner.nextLine();
    }
}
