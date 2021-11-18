package vehicles;

import java.text.DecimalFormat;

public class Bus extends Vehicle{
    private static final double AC_ADDITIONAL_CONSUMPTION = 1.4;
    private boolean isEmpty;

    public Bus(double fuelQuantity, double fuelConsumption, double tankCapacity) {
        super(fuelQuantity, fuelConsumption + AC_ADDITIONAL_CONSUMPTION, tankCapacity);
        this.isEmpty = false;
    }

    public void setIsEmpty(boolean isEmpty) {
        if (this.isEmpty == isEmpty) {
            return;
        }
        this.isEmpty = isEmpty;
        if (isEmpty) {
            super.setFuelConsumption(super.getFuelConsumption() - AC_ADDITIONAL_CONSUMPTION);
        } else {
            super.setFuelConsumption(super.getFuelConsumption() + AC_ADDITIONAL_CONSUMPTION);
        }
    }
}
