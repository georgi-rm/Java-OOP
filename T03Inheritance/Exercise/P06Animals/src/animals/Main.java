package animals;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String input = scanner.nextLine();

        while (!input.equals("Beast!")) {
            String[] animalParameters = scanner.nextLine().split("\\s+");
            String nameOfAnimal = animalParameters[0];
            int ageOfAnimal = Integer.parseInt(animalParameters[1]);
            String genderOfAnimal = animalParameters[2];

            Animal animal;
            try {
                switch (input) {
                    case "animals.Dog":
                        animal = new Dog(nameOfAnimal, ageOfAnimal, genderOfAnimal);
                        break;
                    case "animals.Frog":
                        animal = new Frog(nameOfAnimal, ageOfAnimal, genderOfAnimal);
                        break;
                    case "animals.Cat":
                        animal = new Cat(nameOfAnimal, ageOfAnimal, genderOfAnimal);
                        break;
                    case "animals.Kitten":
                        animal = new Kitten(nameOfAnimal, ageOfAnimal);
                        break;
                    case "animals.Tomcat":
                        animal = new Tomcat(nameOfAnimal, ageOfAnimal);
                        break;
                    default:
                        throw new IllegalArgumentException("Invalid input!");

                }

                System.out.println(animal);
            }catch (IllegalArgumentException e) {
                System.out.println(e.getMessage());
            }

            input = scanner.nextLine();
        }
    }
}
