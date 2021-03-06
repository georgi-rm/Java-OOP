public class Box {
    private double length;
    private double width;
    private double height;

    public Box(double length, double width, double height) {
        setLength(length);
        setWidth(width);
        setHeight(height);
    }

    private void setLength(double length) {
        ensureSide("Length", length);
        this.length = length;
    }

    private void setWidth(double width) {
        ensureSide("Width", width);
        this.width = width;
    }

    private void setHeight(double height) {
        ensureSide("Height", height);
        this.height = height;
    }

    private void ensureSide(String sideName, double sideSize) {
        if (sideSize <= 0.0) {
            throw new IllegalArgumentException(sideName + " cannot be zero or negative.");
        }
    }

    public double calculateSurfaceArea() {
        return 2 * this.length * this.width + 2 * this.length*this.height
                + 2 * this.width * this.height;
    }

    public double calculateLateralSurfaceArea() {
        return 2 * this.length * this.height + 2 * this.width * this.height;
    }

    public double calculateVolume() {
        return this.length * this.width * this.height;
    }
}
