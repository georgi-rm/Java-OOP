package collections;

public class AddCollection extends Collection implements Addable{
    @Override
    public int add(String element) {
        super.items.add(element);
        return super.items.size() - 1;
    }
}
