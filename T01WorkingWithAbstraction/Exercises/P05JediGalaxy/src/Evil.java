public class Evil {
    private int row;
    private int column;

    public Evil(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public boolean moveEvil() {
        if (this.row >= 0 && this.column >= 0) {
            this.row--;
            this.column--;
            return true;
        }
        return false;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}
