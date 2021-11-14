package telephony;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<String> numbers = new ArrayList<>();
        List<String> urls = new ArrayList<>();

        String[] allNumbers = scanner.nextLine().split("\\s+");
        Collections.addAll(numbers, allNumbers);

        String[] allUrls = scanner.nextLine().split("\\s+");
        Collections.addAll(urls, allUrls);

        Smartphone smartphone = new Smartphone(numbers, urls);

        System.out.print(smartphone.call());
        System.out.println(smartphone.browse());
    }
}
