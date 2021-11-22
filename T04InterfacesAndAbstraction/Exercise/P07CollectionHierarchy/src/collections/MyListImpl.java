package collections;

public class MyListImpl extends Collection implements MyList{
    @Override
    public String remove() {
        return super.items.remove(0);
    }

    @Override
    public int add(String element) {
        super.items.add(0, element);
        return 0;
    }

    @Override
    public int getUsed() {
        return super.items.size();
    }
}
