package rpg_lab;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class HeroTest {
    private static final int TARGET_EXPERIENCE = 50;

    private static class FakeAxe implements Weapon {

        @Override
        public int getAttackPoints() {
            return 0;
        }

        @Override
        public int getDurabilityPoints() {
            return 0;
        }

        @Override
        public void attack(Target target) {

        }
    }

    private static class FakeDeadTarget implements Target {

        @Override
        public int getHealth() {
            return 0;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return TARGET_EXPERIENCE;
        }

        @Override
        public boolean isDead() {
            return true;
        }
    }

    private static class FakeAliveTarget implements Target {

        @Override
        public int getHealth() {
            return 100;
        }

        @Override
        public void takeAttack(int attackPoints) {

        }

        @Override
        public int giveExperience() {
            return TARGET_EXPERIENCE;
        }

        @Override
        public boolean isDead() {
            return false;
        }
    }

    private Hero hero;

    @Before
    public void initializeTestObjects() {
        this.hero = new Hero("Zub Zero", new FakeAxe());
    }

    @Test
    public void testUponTargetKillHeroGetsExperience() {
        assertEquals(0, this.hero.getExperience());
        this.hero.attack(new FakeDeadTarget());
        assertEquals(TARGET_EXPERIENCE, this.hero.getExperience());
    }

    @Test
    public void testUponTargetAttackWithTargetIsStillAlive() {
        assertEquals(0, this.hero.getExperience());
        this.hero.attack(new FakeAliveTarget());
        assertEquals(0, this.hero.getExperience());
    }
}