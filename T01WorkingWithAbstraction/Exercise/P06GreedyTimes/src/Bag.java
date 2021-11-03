import java.util.LinkedHashMap;
import java.util.Map;

public class Bag {
    private long quantityOfItems;
    private final Map<String, Item> items;
    private boolean hasItems;

    public Bag() {
        this.quantityOfItems = 0;
        this.items = new LinkedHashMap<>();
        this.hasItems = false;
    }

    public long getAmountOfItems() {
        return quantityOfItems;
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        items.values()
                .stream()
                .sorted(Item::compareTo)
                .forEach(e -> stringBuilder.append("##").append(e).append(System.lineSeparator()));
        return stringBuilder.toString();
    }

    public void addItem(Item item){
        this.items.putIfAbsent(item.getName(), new Item(item.getName(), 0L));
        Item gemItem = this.items.get(item.getName());
        gemItem.addQuantity(item.getQuantity());
        this.quantityOfItems += item.getQuantity();
        this.hasItems = true;
    }

    public boolean hasItems() {
        return this.hasItems;
    }
}
