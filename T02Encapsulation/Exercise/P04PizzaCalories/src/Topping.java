public class Topping {
    private String toppingType;
    private double weight;

    public Topping(String toppingType, double weight) {
        setToppingType(toppingType);
        setWeight(weight);
    }

    public void setToppingType(String toppingType) {
        try {
            ToppingType.valueOf(toppingType.toUpperCase());
        } catch (IllegalArgumentException e) {
            String exceptionMessage = String.format("Cannot place %s on top of your pizza.", toppingType);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.toppingType = toppingType;
    }

    public void setWeight(double weight) {
        if (weight < 1 || weight > 50) {
            String exceptionMessage = String.format("%s weight should be in the range [1..50].", this.toppingType);
            throw new IllegalArgumentException(exceptionMessage);
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifier = ToppingType.valueOf(this.toppingType.toUpperCase()).getModifier();
        return 2 * this.weight * modifier;
    }
}
