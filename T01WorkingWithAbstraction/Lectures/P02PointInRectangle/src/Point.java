public class Point {
    private final int x;
    private final int y;

    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean isGreaterThan(Point point) {
        return this.x >= point.x && this.y >= point.y;
    }

    public boolean isLeaserThan(Point point) {
        return this.x <= point.x && this.y <= point.y;
    }
}
