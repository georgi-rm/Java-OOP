import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int number = Integer.parseInt(scanner.nextLine());

        try {
            System.out.println(calculateSqrt(number));
        } catch (IllegalArgumentException ex) {
            System.out.println(ex.getMessage());
        } finally {
            System.out.println("Good bye");
        }
    }

    public static double calculateSqrt(int number) {
        if (number < 0) {
            throw new IllegalArgumentException("Invalid number");
        }
        return Math.sqrt(number);
    }
}
