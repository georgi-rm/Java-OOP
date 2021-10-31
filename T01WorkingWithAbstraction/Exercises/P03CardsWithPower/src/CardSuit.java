public enum CardSuit {
    CLUBS(0),
    DIAMONDS(13),
    HEARTS(26),
    SPADES(39);

    int power;

    CardSuit(int power) {
        this.power = power;
    }
}
