package storage;

import java.lang.reflect.Method;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfPeople = Integer.parseInt(scanner.nextLine());

        Map<String, Buyer> buyers = new LinkedHashMap<>();

        while (numberOfPeople-- > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");
            if (commandData.length == 4) {
                String citizenName = commandData[0];
                int citizenAge = Integer.parseInt(commandData[1]);
                String citizenId = commandData[2];
                String citizenBirtDate = commandData[3];
                buyers.putIfAbsent(citizenName, new Citizen(citizenName, citizenAge, citizenId, citizenBirtDate));
            } else {
                String rebelName = commandData[0];
                int rebelAge = Integer.parseInt(commandData[1]);
                String rebelGroup = commandData[2];
                buyers.putIfAbsent(rebelName, new Rebel(rebelName, rebelAge, rebelGroup));
            }
        }

        String name = scanner.nextLine();
        while (!name.equals("End")) {
            if (buyers.containsKey(name)) {
                Buyer buyer = buyers.get(name);
                buyer.buyFood();
            }
            name = scanner.nextLine();
        }
        int totalFood = buyers.values().stream()
                .mapToInt(Buyer::getFood)
                .sum();
        System.out.println(totalFood);
    }
}
