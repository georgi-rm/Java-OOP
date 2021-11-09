public class Main {
    public static void main(String[] args) {
        RandomArrayList<Integer> myList = new RandomArrayList<>();

        myList.add(43);
        myList.add(52);
        myList.add(4);
        myList.add(2);
        myList.add(13);
        myList.add(22);
        myList.add(3);
        myList.add(2);

        System.out.println(myList.getRandomElement());
        System.out.println(myList.getRandomElement());
        System.out.println(myList.getRandomElement());
        System.out.println(myList.getRandomElement());

    }
}
