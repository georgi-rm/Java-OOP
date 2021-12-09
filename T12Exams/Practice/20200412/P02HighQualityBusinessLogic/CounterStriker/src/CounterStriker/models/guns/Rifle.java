package CounterStriker.models.guns;

public class Rifle extends GunImpl {
    private static final int BULLETS_SHOT_AT_ONCE = 10;

    public Rifle(String name, int bulletsCount) {
        super(name, bulletsCount);
    }

    @Override
    public int fire() {
        if (super.getBulletsCount() < BULLETS_SHOT_AT_ONCE) {
            return 0;
        }
        super.setBulletsCount(super.getBulletsCount() - BULLETS_SHOT_AT_ONCE);
        return BULLETS_SHOT_AT_ONCE;
    }
}
