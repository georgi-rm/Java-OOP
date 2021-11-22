package collections;

import java.util.ArrayList;
import java.util.List;

public abstract class Collection {
    private final int maxSize;
    List<String> items;

    public Collection() {
        this.maxSize = 100;
        this.items = new ArrayList<>();
    }
}
