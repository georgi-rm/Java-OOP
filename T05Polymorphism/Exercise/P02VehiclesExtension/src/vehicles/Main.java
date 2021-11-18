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
        Vehicle vehicle = getVehicle(carData);
        vehicles.put("Car", vehicle);

        String[] truckData = scanner.nextLine().split("\\s+");
        vehicle = getVehicle(truckData);
        vehicles.put("Truck", vehicle);

        String[] busData = scanner.nextLine().split("\\s+");
        vehicle = getVehicle(busData);
        vehicles.put("Bus", vehicle);

        int numberOfCommands = Integer.parseInt(scanner.nextLine());

        while (numberOfCommands-- > 0) {
            String[] commandData = scanner.nextLine().split("\\s+");
            String commandType = commandData[0];
            String vehicleType = commandData[1];

            switch (commandType) {
                case "Drive":
                    double distance = Double.parseDouble(commandData[2]);
                    vehicle = vehicles.get(vehicleType);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setIsEmpty(false);
                    }

                    System.out.println(vehicle.drive(distance));
                    break;
                case "Refuel":
                    double litters = Double.parseDouble(commandData[2]);
                    try {
                        vehicles.get(vehicleType).refuel(litters);
                    } catch (IllegalArgumentException e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case "DriveEmpty":
                    double distanceForBus = Double.parseDouble(commandData[2]);
                    vehicle = vehicles.get(vehicleType);
                    if (vehicle instanceof Bus) {
                        ((Bus) vehicle).setIsEmpty(true);
                    }

                    System.out.println(vehicle.drive(distanceForBus));
                    break;
            }
        }
        vehicles.values().forEach(v -> System.out.printf("%s: %.2f%n", v.getClass().getSimpleName(), v.getFuelQuantity()));
    }

    private static Vehicle getVehicle(String[] vehicleData) {
        String vehicleType = vehicleData[0];
        double fuelQuantity = Double.parseDouble(vehicleData[1]);
        double fuelConsumption = Double.parseDouble(vehicleData[2]);
        double tankCapacity = Double.parseDouble(vehicleData[3]);
        Vehicle vehicle = null;

        switch (vehicleType) {
            case "Car":
                vehicle = new Car(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Truck":
                vehicle = new Truck(fuelQuantity, fuelConsumption, tankCapacity);
                break;
            case "Bus":
                vehicle = new Bus(fuelQuantity, fuelConsumption, tankCapacity);
                break;
        }

        return vehicle;
    }
}
