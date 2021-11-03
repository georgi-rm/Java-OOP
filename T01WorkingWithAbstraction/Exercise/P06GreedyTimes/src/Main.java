import java.util.Scanner;

public class Main {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        long capacityOfInventory = Long.parseLong(scanner.nextLine());
        String[] allItemsInSafe = scanner.nextLine().split("\\s+");

        Safe safe = new Safe(allItemsInSafe);

        Inventory playerInventory = new Inventory(capacityOfInventory);
        for (Item item : safe) {
            playerInventory.addItem(item);
        }

        System.out.println(playerInventory);
    }
}