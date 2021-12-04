package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

public class AxeTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 100;

    private Axe axe;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
    }

    @Test
    public void axeLoosesDurabilityOnAttack() {
        Dummy dummy = Mockito.mock(Dummy.class);
        this.axe.attack(dummy);

        Assert.assertEquals(AXE_DURABILITY - 1, this.axe.getDurabilityPoints());
    }

    @Test(expected = IllegalStateException.class)
    public void axeCanNotAttackWhenBroken() {
        Axe axeWithOneDurability = new Axe(AXE_ATTACK, 1);
        Dummy dummy = Mockito.mock(Dummy.class);

        axeWithOneDurability.attack(dummy);
        axeWithOneDurability.attack(dummy);
    }
}