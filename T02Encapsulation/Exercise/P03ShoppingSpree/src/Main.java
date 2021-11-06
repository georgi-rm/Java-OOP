import java.util.*;
import java.util.stream.Collectors;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Person> people = new LinkedHashMap<>();
        Map<String, Product> products = new HashMap<>();

        String[] inputPeopleData = scanner.nextLine().split(";");
        for (String peopleData : inputPeopleData) {
            String[] personData = peopleData.split("=");
            String name = personData[0];
            double money = Double.parseDouble(personData[1]);
            try {
                Person person = new Person(name, money);
                people.put(name, person);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String[] inputProductData = scanner.nextLine().split(";");
        for (String productsData : inputProductData) {
            String[] productData = productsData.split("=");
            String name = productData[0];
            double cost = Double.parseDouble(productData[1]);

            try {
                Product product = new Product(name, cost);
                products.put(name, product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
                return;
            }
        }

        String input = scanner.nextLine();
        while (!input.equals("END")) {
            String[] sale = input.split("\\s+");
            String personName = sale[0];
            String productName = sale[1];

            try {
                Product product = products.get(productName);
                Person person = people.get(personName);
                person.buyProduct(product);
            } catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }
            input = scanner.nextLine();
        }

        for (Person person : people.values()) {
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(person.getName()).append(" - ");
            List<Product> peopleProducts = person.getProducts();
            if (peopleProducts.isEmpty()) {
                stringBuilder.append("Nothing bought");
            } else {
                stringBuilder.append(peopleProducts.stream()
                        .map(Product::getName)
                        .collect(Collectors.joining(", ")));
            }
            System.out.println(stringBuilder);
        }

    }
}
