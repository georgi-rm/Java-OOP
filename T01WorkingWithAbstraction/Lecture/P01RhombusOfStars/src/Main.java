import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int sizeOfRhombus = Integer.parseInt(scanner.nextLine());

        Rhombus rhombus = new Rhombus(sizeOfRhombus);
        System.out.println(rhombus);
    }
}