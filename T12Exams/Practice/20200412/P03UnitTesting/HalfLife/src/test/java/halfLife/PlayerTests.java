package halfLife;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class PlayerTests {

    private static final String VALID_USERNAME = "Pesho";
    private static final String BLANK_USERNAME = "    ";
    private static final int VALID_HEALTH = 100;
    private static final int INVALID_HEALTH = -1;

    List<Gun> testGuns;

    @Before
    public void setUpTests(){
        this.testGuns = new ArrayList<>();
        this.testGuns.add(new Gun("Makarov", 5));
        this.testGuns.add(new Gun("Desert Eagle", 8));
    }

    @Test
    public void testConstructorCorrectData() {
        new Player(VALID_USERNAME, VALID_HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowExceptionForNullUsername() {
        new Player(null, VALID_HEALTH);
    }

    @Test(expected = NullPointerException.class)
    public void testConstructorThrowExceptionForBlankUsername() {
        new Player(BLANK_USERNAME, VALID_HEALTH);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testConstructorThrowExceptionForInvalidHealth() {
        new Player(VALID_USERNAME, INVALID_HEALTH);
    }

    @Test
    public void testGetUsername() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        assertEquals(VALID_USERNAME, player.getUsername());
    }

    @Test
    public void testGetHealth() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        assertEquals(VALID_HEALTH, player.getHealth());
    }

    @Test(expected = NullPointerException.class)
    public void testAddGunThrowExceptionForNullGun() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(null);
    }

    @Test
    public void testAddGunWithValidGun() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
    }

    @Test
    public void testGetGunsReturnsCorrectGuns() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
        assertEquals(1, player.getGuns().size());
        player.addGun(this.testGuns.get(1));
        assertEquals(2, player.getGuns().size());
        assertEquals(this.testGuns.get(0), player.getGuns().get(0));
        assertEquals(this.testGuns.get(1), player.getGuns().get(1));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetGunsIsUnmodifiable() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
        player.addGun(this.testGuns.get(1));
        player.getGuns().clear();
    }

    @Test
    public void testRemoveGunRemovesCorrectGun() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
        player.addGun(this.testGuns.get(1));
        assertEquals(2, player.getGuns().size());
        assertEquals(this.testGuns.get(0), player.getGuns().get(0));
        assertEquals(this.testGuns.get(1), player.getGuns().get(1));
        player.removeGun(this.testGuns.get(0));
        assertEquals(1, player.getGuns().size());
        assertEquals(this.testGuns.get(1), player.getGuns().get(0));
    }

    @Test
    public void testGetGunByNameToFindCorrectGun() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
        player.addGun(this.testGuns.get(1));

        assertEquals(this.testGuns.get(1), player.getGun(this.testGuns.get(1).getName()));
    }

    @Test
    public void testGetGunByNameWithNotExistingGun() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.addGun(this.testGuns.get(0));
        player.addGun(this.testGuns.get(1));

        assertNull(player.getGun("Not Existing"));
    }

    @Test
    public void testTakeDamageOnLivingPlayer() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.takeDamage(1);
        assertEquals(VALID_HEALTH - 1, player.getHealth());
        player.takeDamage(VALID_HEALTH);
        assertEquals(0, player.getHealth());
    }

    @Test(expected = IllegalStateException.class)
    public void testTakeDamageOnDeadPlayer() {
        Player player = new Player(VALID_USERNAME, VALID_HEALTH);
        player.takeDamage(VALID_HEALTH);
        assertEquals(0, player.getHealth());
        player.takeDamage(1);
    }
}
