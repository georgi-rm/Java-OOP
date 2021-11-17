package vehicles;

import java.text.DecimalFormat;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Map<String, Vehicle> vehicles = new LinkedHashMap<>();

        String[] carData = scanner.nextLine().split("\\s+");
        String inputVehicleType = carData[0];
        double carFuelQuantity = Double.parseDouble(carData[1]);
        double carConsumption = Double.parseDouble(carData[2]);
        vehicles.put(inputVehicleType, new Car(carFuelQuantity, carConsumption));

        String[] truckData = scanner.nextLine().split("\\s+");
        inputVehicleType = truckData[0];
        double truckFuelQuantity = Double.parseDouble(truckData[1]);
        double truckConsumption = Double.parseDouble(truckData[2]);
        vehicles.put(inputVehicleType, new Truck(truckFuelQuantity, truckConsumption));

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        while (numberOfCommands-- > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");
            String commandType = commandData[0];
            String vehicleType = commandData[1];

            switch (commandType) {
                case "Drive":
                    double distance = Double.parseDouble(commandData[2]);
                    System.out.println(vehicles.get(vehicleType).drive(distance));
                    break;
                case "Refuel":
                    double litters = Double.parseDouble(commandData[2]);
                    vehicles.get(vehicleType).refuel(litters);
                    break;
            }
        }
        vehicles.values().forEach(v -> System.out.printf("%s: %.2f%n", v.getClass().getSimpleName(), v.getFuelQuantity()));
    }
}
