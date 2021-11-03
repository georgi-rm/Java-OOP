import java.util.LinkedHashMap;
import java.util.Map;

public class Inventory {
    private final long capacity;
    private final Map<String, Bag> bags;

    public Inventory(long capacity) {
        this.capacity = capacity;
        this.bags = new LinkedHashMap<>();
        this.bags.put("Gold", new Bag());
        this.bags.put("Gem", new Bag());
        this.bags.put("Cash", new Bag());
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        this.bags.entrySet().stream()
                .sorted((e1, e2) -> Long.compare(e2.getValue().getAmountOfItems(), e1.getValue().getAmountOfItems()))
                .filter(e -> e.getValue().hasItems())
                .forEach(e -> stringBuilder.append(String.format("<%s> $%d%n", e.getKey(), e.getValue().getAmountOfItems()))
                        .append(e.getValue()));

        return stringBuilder.toString();
    }

    public void addItem(Item item) {
        if (item.getName().length() == 3) {
            if (canAddCash(item.getQuantity())) {
                this.bags.get("Cash").addItem(item);
            }
        } else if (item.getName().toLowerCase().endsWith("gem")) {
            if (canAddGems(item.getQuantity())) {
                this.bags.get("Gem").addItem(item);
            }
        } else if (item.getName().equalsIgnoreCase("gold")) {
            if (!isCapacityFull(item.getQuantity())) {
                this.bags.get("Gold").addItem(item);
            }
        }
    }

    private boolean isCapacityFull(long amountToAdd) {
        return this.bags.get("Gold").getAmountOfItems() + this.bags.get("Cash").getAmountOfItems()
                + this.bags.get("Gem").getAmountOfItems() + amountToAdd > this.capacity;
    }

    private boolean canAddCash(long amountToAdd) {
        if (isCapacityFull(amountToAdd)) {
            return false;
        }

        if (!this.bags.get("Gem").hasItems()) {
            return false;
        }

        return this.bags.get("Cash").getAmountOfItems() + amountToAdd <= this.bags.get("Gem").getAmountOfItems();
    }

    private boolean canAddGems(long amountToAdd) {
        if (isCapacityFull(amountToAdd)) {
            return false;
        }

        if (!this.bags.get("Gold").hasItems()) {
            return false;
        }

        return this.bags.get("Gem").getAmountOfItems() + amountToAdd <= this.bags.get("Gold").getAmountOfItems();
    }
}
