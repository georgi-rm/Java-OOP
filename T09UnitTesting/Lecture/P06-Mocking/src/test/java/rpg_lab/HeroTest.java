package rpg_lab;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mockito;

import static org.junit.Assert.*;

public class HeroTest {
    private static final int TARGET_EXPERIENCE = 50;

    private Hero hero;

    @Before
    public void initializeTestObjects() {
        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        this.hero = new Hero("Zub Zero", mockedWeapon);
    }

    @Test
    public void testUponTargetKillHeroGetsExperience() {
        assertEquals(0, this.hero.getExperience());
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(TARGET_EXPERIENCE);
        this.hero.attack(mockedTarget);
        assertEquals(TARGET_EXPERIENCE, this.hero.getExperience());
    }

    @Test
    public void testUponTargetAttackWithTargetIsStillAliveHeroDoNotGetExperience() {
        assertEquals(0, this.hero.getExperience());
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.isDead()).thenReturn(false);
        Mockito.when(mockedTarget.giveExperience()).thenReturn(TARGET_EXPERIENCE);
        this.hero.attack(mockedTarget);
        assertEquals(0, this.hero.getExperience());
    }

    @Test
    public void testUponTargetKillHeroGetsLoot() {
        assertEquals(0, this.hero.getInventory().size());

        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.giveLoot()).thenReturn(mockedWeapon);
        Mockito.when(mockedTarget.isDead()).thenReturn(true);
        this.hero.attack(mockedTarget);
        assertEquals(1, this.hero.getInventory().size());
    }

    @Test
    public void testUponTargetAttackWithTargetIsStillAliveHeroDoNotGetLoot() {
        assertEquals(0, this.hero.getInventory().size());

        Weapon mockedWeapon = Mockito.mock(Weapon.class);
        Target mockedTarget = Mockito.mock(Target.class);
        Mockito.when(mockedTarget.giveLoot()).thenReturn(mockedWeapon);
        Mockito.when(mockedTarget.isDead()).thenReturn(false);
        this.hero.attack(mockedTarget);
        assertEquals(0, this.hero.getInventory().size());
    }
}