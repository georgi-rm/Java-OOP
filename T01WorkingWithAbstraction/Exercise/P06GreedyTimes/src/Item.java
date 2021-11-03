public class Item implements Comparable<Item> {
    private final String name;
    private long quantity;

    public Item(String name, long quantity) {
        this.name = name;
        this.quantity = quantity;
    }

    public String getName() {
        return name;
    }

    public long getQuantity() {
        return quantity;
    }

    public void addQuantity(long quantityToAdd) {
        this.quantity += quantityToAdd;
    }

    @Override
    public String toString() {
        return String.format("%s - %d", this.name, this.quantity);
    }

    @Override
    public int compareTo(Item other) {
        int result = other.name.compareTo(this.name);
        if (result == 0) {
            result = Long.compare(this.quantity, other.quantity);
        }
        return result;
    }
}
