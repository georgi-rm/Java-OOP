package CounterStriker.models.guns;

public class Pistol extends GunImpl {
    private static final int BULLETS_SHOT_AT_ONCE = 1;

    protected Pistol(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (getBulletsCount() < BULLETS_SHOT_AT_ONCE) {
            return 0;
        }
        return BULLETS_SHOT_AT_ONCE;
    }
}
