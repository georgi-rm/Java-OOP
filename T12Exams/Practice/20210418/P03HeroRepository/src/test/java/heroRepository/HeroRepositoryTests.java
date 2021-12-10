package heroRepository;

import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

import static org.junit.Assert.*;

public class HeroRepositoryTests {
    private static final String BLANK_NAME = "     ";
    private static final String NOT_EXISTING_HERO_NAME = "Not Existing Hero";
    private HeroRepository heroRepository;
    private List<Hero> testHeroes;

    @Before
    public void setUpTests() {
        this.heroRepository = new HeroRepository();
        this.testHeroes = new ArrayList<>();
        this.testHeroes.add(new Hero("Zub-Zero", 52));
        this.testHeroes.add(new Hero("Shinok", 100));
        this.testHeroes.add(new Hero("Scorpion", 65));
    }

    @Test
    public void testCreateWithValidHeroes() {
        for (Hero testHero : testHeroes) {
            String result = this.heroRepository.create(testHero);
            String expectedResult = String.format("Successfully added hero %s with level %d", testHero.getName(), testHero.getLevel());
            assertEquals( expectedResult, result);
        }
    }

    @Test(expected = NullPointerException.class)
    public void testCreateThrowExceptionForNullHero() {
        this.heroRepository.create(null);
    }


    @Test(expected = IllegalArgumentException.class)
    public void testCreateThrowExceptionForHeroesWithDuplicateNames() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(new Hero(this.testHeroes.get(0).getName(), 1));
    }

    @Test
    public void testCountWithValidHeroes() {
        for (int i = 0; i < this.testHeroes.size(); i++) {
            this.heroRepository.create(this.testHeroes.get(i));
            assertEquals(i + 1, this.heroRepository.getCount());
        }
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowExceptionForNullName() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.remove(null);
    }

    @Test(expected = NullPointerException.class)
    public void testRemoveThrowExceptionForBlankName() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.remove(BLANK_NAME);
    }

    @Test
    public void testRemoveReturnFalseWhenNoSuchHero() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        assertFalse(this.heroRepository.remove(NOT_EXISTING_HERO_NAME));
    }


    @Test
    public void testRemoveReturnTrueOnSuccessfulRemove() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        assertTrue(this.heroRepository.remove(this.testHeroes.get(1).getName()));
    }

    @Test(expected = UnsupportedOperationException.class)
    public void testGetHeroesReturnsUnmodifiableCollection() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        this.heroRepository.getHeroes().clear();
    }

    @Test
    public void testGetHeroWithHighestLevelWhenThereIsNoHeroes() {
        assertNull(this.heroRepository.getHeroWithHighestLevel());
    }

    @Test
    public void testGetHeroWithHighestLevelWithValidHeroes() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        Hero heroWithHighestLevel = this.heroRepository.getHeroWithHighestLevel();
        Hero expectedHero = this.testHeroes.stream()
                .sorted(Comparator.comparing(Hero::getLevel).reversed())
                .limit(1).collect(Collectors.toList()).get(0);

        assertEquals(expectedHero, heroWithHighestLevel);
    }

    @Test
    public void testGetHeroByNameWhenThereIsNoHeroes() {
        assertNull(this.heroRepository.getHero(NOT_EXISTING_HERO_NAME));
    }

    @Test
    public void testGetHeroByNameWhenThereIsNoSuchHero() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        assertNull(this.heroRepository.getHero(NOT_EXISTING_HERO_NAME));
    }

    @Test
    public void testGetHeroByNameUsingExistingHeroName() {
        this.heroRepository.create(this.testHeroes.get(0));
        this.heroRepository.create(this.testHeroes.get(1));
        this.heroRepository.create(this.testHeroes.get(2));
        Hero heroFound = this.heroRepository.getHero(this.testHeroes.get(1).getName());

        assertEquals(this.testHeroes.get(1), heroFound);
    }
}
