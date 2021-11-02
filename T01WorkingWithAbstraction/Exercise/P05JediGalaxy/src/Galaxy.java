public class Galaxy {
    private final BattleField battleField;
    private final Jedi jedi;
    private final Evil evil;

    public Galaxy(BattleField battleField, Jedi jedi, Evil evil) {
        this.battleField = battleField;
        this.jedi = jedi;
        this.evil = evil;
    }

    public void play(){
        do {
            this.battleField.setValue(this.evil.getRow(), this.evil.getColumn(), 0);
        }
        while (this.evil.moveEvil());

        do {
            this.jedi.collectStars(this.battleField.getValue(this.jedi.getRow(), this.jedi.getColumn()));
        }
        while (this.jedi.move(battleField.getMaxColumn()));
    }
}
