package rpg_lab;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class DummyTest {
    private static final int AXE_ATTACK = 10;
    private static final int AXE_DURABILITY = 100;
    private static final int DUMMY_HEALTH = 100;
    private static final int DUMMY_EXPERIENCE = 50;

    private Axe axe;
    private Dummy dummy;
    private Dummy deadDummy;

    @Before
    public void initializeTestObjects() {
        this.axe = new Axe(AXE_ATTACK, AXE_DURABILITY);
        this.dummy = new Dummy(DUMMY_HEALTH, DUMMY_EXPERIENCE);
        this.deadDummy = new Dummy(0, DUMMY_EXPERIENCE);
    }

    @Test
    public void dummyLosesHealthWhenAttacked() {
        Assert.assertEquals(DUMMY_HEALTH, this.dummy.getHealth());
        this.axe.attack(this.dummy);
        Assert.assertEquals(DUMMY_HEALTH - AXE_ATTACK, this.dummy.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void deadDummyThrowsExceptionWhenAttacked() {

        this.axe.attack(this.deadDummy);
    }

    @Test
    public void deadDummyGivesExperience() {
        assertEquals(DUMMY_EXPERIENCE, this.deadDummy.giveExperience());
    }

    @Test(expected = IllegalStateException.class)
    public void aliveDummyCanNotGiveExperience() {
        this.dummy.giveExperience();
    }
}