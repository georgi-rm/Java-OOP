public class BattleField {
    private final int[][] field;

    public BattleField(int rows, int columns) {
        this.field = new int[rows][columns];
        fillBattleField();
    }

    private void fillBattleField() {
        int value = 0;
        for (int row = 0; row < field.length; row++) {
            for (int column = 0; column < field[row].length; column++) {
                field[row][column] = value++;
            }
        }
    }

    public boolean isInBounds(int row, int column) {
        return row >= 0 && row < this.field.length && column >= 0 && column < this.field[row].length;
    }

    public int getValue(int row, int column){
        if (isInBounds(row, column)) {
            return field[row][column];
        }
        return 0;
    }

    public void setValue(int row, int column, int value){
        if (isInBounds(row, column)) {
            this.field[row][column] = value;
        }
    }

    public int getMaxColumn() {
        return field[0].length;
    }
}
