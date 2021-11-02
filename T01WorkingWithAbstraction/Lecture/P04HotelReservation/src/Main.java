import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] commandData = scanner.nextLine().split("\\s+");

        double price = Double.parseDouble(commandData[0]);
        int numberOfDays = Integer.parseInt(commandData[1]);
        String season = commandData[2];
        String discountType = commandData[3];

        PriceCalculator priceCalculator = new PriceCalculator(price, numberOfDays, season, discountType);
        System.out.printf("%.2f", priceCalculator.calculate());
    }
}
