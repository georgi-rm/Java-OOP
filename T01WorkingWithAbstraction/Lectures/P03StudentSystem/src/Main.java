import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentSystem studentSystem = new StudentSystem();

        while (true) {
            String[] input = scanner.nextLine().split(" ");
            String parseResult = studentSystem.parseCommand(input);
            if ("Exit".equals(parseResult) ){
                break;
            }

            if (parseResult != null) {
                System.out.println(parseResult);
            }
        }
    }
}
