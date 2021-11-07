public class Dough {
    private String flourType;
    private String bakingTechnique;
    private double weight;

    public Dough(String flourType, String bakingTechnique, double weight) {
        setFlourType(flourType);
        setBakingTechnique(bakingTechnique);
        setWeight(weight);
    }

    private void setFlourType(String flourType) {
        try {
            FlourType.valueOf(flourType.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.flourType = flourType;
    }

    private void setBakingTechnique(String bakingTechnique) {
        try {
            BakingTechnique.valueOf(bakingTechnique.toUpperCase());
        } catch (IllegalArgumentException e) {
            throw new IllegalArgumentException("Invalid type of dough.");
        }
        this.bakingTechnique = bakingTechnique;
    }


    private void setWeight(double weight) {
        if (weight < 1 || weight > 200) {
            throw new IllegalArgumentException("Dough weight should be in the range [1..200].");
        }
        this.weight = weight;
    }

    public double calculateCalories() {
        double modifierByFlourType = FlourType.valueOf(this.flourType.toUpperCase()).getModifier();
        double modifierByBakingTechnique = BakingTechnique.valueOf(this.bakingTechnique.toUpperCase()).getModifier();

        return 2 * weight * modifierByFlourType * modifierByBakingTechnique;
    }
}
