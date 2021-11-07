import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String[] pizzaInfo = scanner.nextLine().split("\\s+");
        String nameOfPizza = pizzaInfo[1];
        int numberOfToppings = Integer.parseInt(pizzaInfo[2]);

        Pizza pizza;
        try {
            pizza = new Pizza(nameOfPizza, numberOfToppings);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String[] DoughInfo = scanner.nextLine().split("\\s+");
        String flourType = DoughInfo[1];
        String bakingTechnique = DoughInfo[2];
        double doughWeight = Double.parseDouble(DoughInfo[3]);
        try {
            Dough dough = new Dough(flourType, bakingTechnique, doughWeight);
            pizza.setDough(dough);
        } catch (IllegalArgumentException e) {
            System.out.println(e.getMessage());
            return;
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] toppingInfo = input.split("\\s+");
            String toppingType = toppingInfo[1];
            double toppingWeight = Double.parseDouble(toppingInfo[2]);

            try {
                Topping topping = new Topping(toppingType, toppingWeight);
                pizza.addTopping(topping);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }

            input = scanner.nextLine();
        }

        System.out.printf("%s - %.2f", pizza.getName(), pizza.getOverallCalories());
    }
}
