import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.function.Consumer;

public class Safe implements Iterable<Item>{
    private final List<Item> items;

    public Safe(String... data) {
        this.items = new ArrayList<>();
        for (int i = 0; i < data.length; i += 2) {
            String itemName = data[i];
            long itemQuantity = Long.parseLong(data[i + 1]);
            Item item = new Item(itemName, itemQuantity);
            this.items.add(item);
        }
    }


    @Override
    public Iterator<Item> iterator() {
        return items.iterator();
    }

    @Override
    public void forEach(Consumer<? super Item> action) {
        items.forEach(action);
    }
}
