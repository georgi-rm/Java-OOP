package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class AxeTest {
    private static final int AXE_DURABILITY = 10;

    @Test
    public void axeLoosesDurabilityOnAttack() {

        Axe axe = new Axe(10, AXE_DURABILITY);
        Dummy target = new Dummy(10, 10);

        axe.attack(target);

        Assert.assertEquals(AXE_DURABILITY - 1, axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeCanNotAttackWhenBroken() {
        Axe axe = new Axe(10, 1);
        Dummy target = new Dummy(10, 10);

        axe.attack(target);
        axe.attack(target);
    }
}