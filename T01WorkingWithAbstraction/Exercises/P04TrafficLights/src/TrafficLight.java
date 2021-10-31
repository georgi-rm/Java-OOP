public class TrafficLight {
    private LightSignal lightSignal;

    public TrafficLight(LightSignal lightSignal) {
        this.lightSignal = lightSignal;
    }

    public void changeSignal() {
        switch (this.lightSignal) {
            case RED:
                this.lightSignal = LightSignal.GREEN;
                break;
            case GREEN:
                this.lightSignal = LightSignal.YELLOW;
                break;
            case YELLOW:
                this.lightSignal = LightSignal.RED;
                break;
        }
    }

    public LightSignal getLightSignal() {
        return lightSignal;
    }

    @Override
    public String toString() {
        return this.lightSignal.name();
    }
}
