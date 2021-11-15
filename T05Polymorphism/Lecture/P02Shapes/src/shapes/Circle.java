package shapes;

public class Circle extends Shape{
    private final Double radius;

    public Circle(Double radius) {
        this.radius = radius;
    }


    public final Double getRadius() {
        return radius;
    }

    @Override
    public Double calculatePerimeter() {
        super.setPerimeter(2 * Math.PI * this.radius);
        return super.getPerimeter();
    }

    @Override
    public Double calculateArea() {
        super.setArea(Math.PI * this.radius * this.radius);
        return super.getArea();
    }
}
