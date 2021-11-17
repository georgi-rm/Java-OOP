package vehicles;

import java.text.DecimalFormat;

public abstract class Vehicle {
    private double fuelQuantity;
    private final double fuelConsumption;

    public Vehicle(double fuelQuantity, double fuelConsumption) {
        this.fuelQuantity = fuelQuantity;
        this.fuelConsumption = fuelConsumption;
    }

    public String drive(double distance) {
        double fuelNeeded = distance * this.getFuelConsumption();
        if (fuelNeeded > this.getFuelQuantity()) {
            return this.getClass().getSimpleName() + " needs refueling";
        }
        this.setFuelQuantity(this.getFuelQuantity() - fuelNeeded);
        DecimalFormat formatter = new DecimalFormat("##.##");
        return String.format("%s travelled %s km", this.getClass().getSimpleName(), formatter.format(distance));
    }

    public void refuel(double liters) {
        this.fuelQuantity += liters;
    }

    public double getFuelQuantity() {
        return fuelQuantity;
    }

    public double getFuelConsumption() {
        return fuelConsumption;
    }

    private void setFuelQuantity(double fuelQuantity) {
        this.fuelQuantity = fuelQuantity;
    }
}
