import java.util.ArrayList;
import java.util.List;

public class Pizza {
    private String name;
    private Dough dough;
    private final List<Topping> toppings;

    public Pizza(String name, int numberOfToppings) {
        setName(name);
        setToppings(numberOfToppings);
        this.toppings = new ArrayList<>();
    }

    public void addTopping(Topping topping) {
        toppings.add(topping);
    }

    public double getOverallCalories() {
        double calories = dough.calculateCalories();
        for (Topping topping : toppings) {
            calories += topping.calculateCalories();
        }
        return calories;
    }

    private void setToppings(int numberOfToppings) {
        if (numberOfToppings < 0 || numberOfToppings > 10) {
            throw new IllegalArgumentException("Number of toppings should be in range [0..10].");
        }
    }

    public String getName() {
        return name;
    }

    private void setName(String name) {
        name = name.trim();

        if (name.isEmpty() || name.length() > 15) {
            throw new IllegalArgumentException("Pizza name should be between 1 and 15 symbols.");
        }
        this.name = name;
    }

    public Dough getDough() {
        return dough;
    }

    public void setDough(Dough dought) {
        this.dough = dought;
    }
}
