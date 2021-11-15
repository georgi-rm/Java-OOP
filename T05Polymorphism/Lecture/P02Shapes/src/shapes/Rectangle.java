package shapes;

public class Rectangle extends Shape{
    private final Double height;
    private final Double width;

    public Rectangle(Double height, Double width) {
        this.height = height;
        this.width = width;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * this.height + 2 * this.width);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(this.height * this.width);
        return super.getArea();
    }

    public final Double getHeight() {
        return height;
    }

    public final Double getWidth() {
        return width;
    }
}
