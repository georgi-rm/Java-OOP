package farm;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        List<Animal> animals = new ArrayList<>();

        String input = scanner.nextLine();
        while (!input.equals("End")) {
            String[] commandData = input.split("\\s+");
            Animal animal = createAnimal(commandData);

            commandData = scanner.nextLine().split("\\s+");
            Food food = createFood(commandData);

            animal.makeSound();
            try {
                animal.eat(food);
            } catch (IllegalArgumentException ex) {
                System.out.println(ex.getMessage());
            }
            animals.add(animal);
            input = scanner.nextLine();
        }
        animals.forEach(System.out::println);
    }

    static Food createFood(String[] commandData) {
        String foodType = commandData[0];
        Integer foodQuantity = Integer.parseInt(commandData[1]);

        switch (foodType) {
            case "Vegetable":
                return new Vegetable(foodQuantity);
            case "Meat":
                return new Meat(foodQuantity);
            default:
                throw new IllegalArgumentException("No such food");
        }
    }

    private static Animal createAnimal(String[] commandData) {
        String animalType = commandData[0];
        String animalName = commandData[1];
        Double animalWeight = Double.parseDouble(commandData[2]);
        String animalRegionOfLiving = commandData[3];
        switch (animalType) {
            case "Mouse":
                return new Mouse(animalName, animalType, animalWeight, animalRegionOfLiving);
            case "Zebra":
                return new Zebra(animalName, animalType, animalWeight, animalRegionOfLiving);
            case "Tiger":
                return new Tiger(animalName, animalType, animalWeight, animalRegionOfLiving);
            case "Cat":
                String catBreed = commandData[4];
                return new Cat(animalName, animalType, animalWeight, animalRegionOfLiving, catBreed);
            default:
                throw new IllegalArgumentException("No such animal");
        }
    }
}
