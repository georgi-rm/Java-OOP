public class Jedi {
    private int row;
    private int column;
    private long collectedStars;

    public Jedi(int row, int column) {
        this.row = row;
        this.column = column;
        collectedStars = 0;
    }

    public long getCollectedStars() {
        return collectedStars;
    }

    public void collectStars(long newStars) {
        this.collectedStars += newStars;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }

    public boolean move(int maxColumn) {
        if (this.row >= 0 && this.column < maxColumn) {
            this.row--;
            this.column++;
            return true;
        }
        return false;
    }
}
