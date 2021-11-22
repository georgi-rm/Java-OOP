package collections;

import java.util.Arrays;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        AddCollection addCollection = new AddCollection();
        AddRemoveCollection addRemoveCollection = new AddRemoveCollection();
        MyListImpl myList = new MyListImpl();

        String[] inputData = scanner.nextLine().split("\\s+");

        Arrays.stream(inputData)
                .map(addCollection::add)
                .forEach(e -> System.out.printf("%d ", e));
        System.out.println();

        Arrays.stream(inputData)
                .map(addRemoveCollection::add)
                .forEach(e -> System.out.printf("%d ", e));
        System.out.println();

        Arrays.stream(inputData)
                .map(myList::add)
                .forEach(e -> System.out.printf("%d ", e));
        System.out.println();

        int numberOfRemoves = Integer.parseInt(scanner.nextLine());

        for (int i = 0; i < numberOfRemoves; i++) {
            System.out.printf("%s ", addRemoveCollection.remove());
        }
        System.out.println();

        for (int i = 0; i < numberOfRemoves; i++) {
            System.out.printf("%s ", myList.remove());
        }
        System.out.println();
    }
}
