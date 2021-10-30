public enum DiscountType {
    VIP(20),
    SECONDVISIT(10),
    NONE(0);

    private final double discountPercentage;

    DiscountType(double discountPercentage) {
        this.discountPercentage = discountPercentage;
    }

    public double getDiscountPercentage() {
        return discountPercentage;
    }
}
