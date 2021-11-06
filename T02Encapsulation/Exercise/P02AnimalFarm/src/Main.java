import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String nameOfChicken = scanner.nextLine();
        int ageOfChicken = Integer.parseInt(scanner.nextLine());

        try {
            Chicken chicken = new Chicken(nameOfChicken, ageOfChicken);
            System.out.printf("%s can produce %.2f eggs per day.", chicken, chicken.productPerDay());
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }

    }
}
