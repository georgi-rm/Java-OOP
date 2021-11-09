import java.util.ArrayList;

public class StackOfStrings {
    private final ArrayList<String> data;

    public StackOfStrings() {
        this.data = new ArrayList<>();
    }

    public void push(String item) {
        this.data.add(item);
    }

    public String pop() {
        int indexOfLastElement = this.data.size() - 1;
        return this.data.remove(indexOfLastElement);
    }

    public String peek() {
        int indexOfLastElement = this.data.size() - 1;
        return this.data.get(indexOfLastElement);
    }

    public boolean isEmpty() {
        return this.data.isEmpty();
    }
}
