import java.util.Scanner;
import java.util.stream.IntStream;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (true) {
            try {
                int start = Integer.parseInt(scanner.nextLine());
                int end = Integer.parseInt(scanner.nextLine());

                printNumbers(start, end);
                break;
            } catch (NumberFormatException ex) {
                System.out.println("Please enter valid integers");
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
        }
    }

    private static void printNumbers(int start, int end) {
        if (!isValidRange(start, end)) {
            throw new IllegalArgumentException("Please enter valid range");
        }
        IntStream.rangeClosed(start, end)
                .forEach(System.out::println);
    }

    private static boolean isValidRange(int start, int end) {
        return (start > 1) && (start < end) && (end < 100);
    }
}
