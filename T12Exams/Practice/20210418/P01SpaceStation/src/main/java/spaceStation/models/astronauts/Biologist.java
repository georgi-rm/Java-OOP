package spaceStation.models.astronauts;

public class Biologist extends BaseAstronaut {
    private static final double INITIAL_OXYGEN_UNITS = 70.0;
    private static final double DEFAULT_OXYGEN_BREATHED = 5.0;

    public Biologist(String name) {
        super(name, INITIAL_OXYGEN_UNITS);
    }

    @Override
    public void breath() {
        super.breath(DEFAULT_OXYGEN_BREATHED);
    }
}
