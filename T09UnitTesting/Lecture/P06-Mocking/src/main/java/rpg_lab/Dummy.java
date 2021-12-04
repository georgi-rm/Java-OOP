package rpg_lab;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Dummy implements Target{

    private int health;
    private int experience;

    private List<Weapon> possibleLoot;

    public Dummy(int health, int experience) {
        this.health = health;
        this.experience = experience;
        this.possibleLoot = new ArrayList<>();
        this.possibleLoot.add(new Axe(10, 10));
        this.possibleLoot.add(new Axe(100, 100));
    }

    @Override
    public int getHealth() {
        return this.health;
    }

    @Override
    public void takeAttack(int attackPoints) {
        if (this.isDead()) {
            throw new IllegalStateException("Dummy is dead.");
        }

        this.health -= attackPoints;
    }

    @Override
    public int giveExperience() {
        if (!this.isDead()) {
            throw new IllegalStateException("Target is not dead.");
        }

        return this.experience;
    }

    @Override
    public Weapon giveLoot() {
        Random random = new Random();
        return possibleLoot.get(random.nextInt() % possibleLoot.size());
    }

    @Override
    public boolean isDead() {
        return this.health <= 0;
    }
}
