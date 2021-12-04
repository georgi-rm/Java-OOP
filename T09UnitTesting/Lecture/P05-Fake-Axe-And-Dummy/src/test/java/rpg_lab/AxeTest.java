package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 100;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 50;

    private Axe axe;
    private Dummy dummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
    }
    @Test
    public void axeLoosesDurabilityOnAttack() {
        this.axe.attack(this.dummy);

        Assert.assertEquals(AXE_DURABILITY - 1, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeCanNotAttackWhenBroken() {
        Axe axeWithOneDurability = new Axe(AXE_ATTACK, 1);

        axeWithOneDurability.attack(this.dummy);
        axeWithOneDurability.attack(this.dummy);
    }
}