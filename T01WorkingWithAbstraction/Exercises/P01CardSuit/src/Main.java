public class Main {
    public static void main(String[] args) {

        System.out.println("Card Suits:");
        for (SuitsOfCards suit : SuitsOfCards.values()) {
            System.out.printf("Ordinal value: %d; Name value: %s%n", suit.ordinal(), suit.name());
        }
    }
}
