public class Rectangle {
    private Point bottomLeftPoint;
    private Point topRightPoint;

    public Rectangle(int bottomLestPointX, int bottomLestPointY, int topRightPointX, int topRightPointY) {
        this.bottomLeftPoint = new Point(bottomLestPointX, bottomLestPointY);
        this.topRightPoint = new Point(topRightPointX, topRightPointY);
    }

    public boolean contains(Point point) {
        if (!point.isGreaterThan(this.bottomLeftPoint)) {
            return false;
        }

        return point.isLeaserThan(this.topRightPoint);
    }
}
