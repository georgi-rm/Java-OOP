public class PriceCalculator {
    private final double price;
    private final int numberOfDays;
    private final Season season;
    private final DiscountType discountType;

    public PriceCalculator(double price, int numberOfDays, String season, String discountType) {
        this.price = price;
        this.numberOfDays = numberOfDays;
        this.season = Season.valueOf(season.toUpperCase());
        this.discountType = DiscountType.valueOf(discountType.toUpperCase());
    }

    public double calculate() {
        return this.price * this.numberOfDays * season.getMultiplier() * (1 - discountType.getDiscountPercentage() / 100);
    }
}
