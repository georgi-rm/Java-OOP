package p05_CustomLinkedList;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CustomLinkedListTest {
    private static final String[] ELEMENTS = {"First", "Second", "Third", "Forth"};
    private static final String VALUE_NOT_IN_ELEMENTS = "Not in elements";
    private static final int INDEX_TO_SET = 1;
    private static final int INDEX_TO_REMOVE = 1;
    private static final int INDEX_TO_FIND = 1;
    CustomLinkedList<String> customLinkedList;

    @Before
    public void setUpTests() {
        this.customLinkedList = new CustomLinkedList<>();
        for (int i = 0; i < ELEMENTS.length; i++) {
            this.customLinkedList.add(ELEMENTS[i]);
        }
    }

    @Test
    public void testAddFirstAndSecondElements() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(ELEMENTS[0]);
        assertEquals(0, customLinkedList.indexOf(ELEMENTS[0]));
        assertEquals(ELEMENTS[0], customLinkedList.get(0));
        customLinkedList.add(ELEMENTS[1]);
        assertEquals(1, customLinkedList.indexOf(ELEMENTS[1]));
        assertEquals(ELEMENTS[1], customLinkedList.get(1));
    }

    @Test
    public void testGetByIndexWithValidIndex() {
        assertEquals(ELEMENTS[0], this.customLinkedList.get(0));
        assertEquals(ELEMENTS[1], this.customLinkedList.get(1));
        assertEquals(ELEMENTS[ELEMENTS.length - 1], this.customLinkedList.get(ELEMENTS.length - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIndexWithIndexZeroOnEmptyList() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.get(0);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIndexWithIndexOutOfBounds() {
        this.customLinkedList.get(ELEMENTS.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testGetByIndexWithNegativeIndex() {
        this.customLinkedList.get(-1);
    }

    @Test
    public void testSetByIndexWithValidIndex() {
        assertEquals(ELEMENTS[INDEX_TO_SET], this.customLinkedList.get(INDEX_TO_SET));
        this.customLinkedList.set(INDEX_TO_SET, VALUE_NOT_IN_ELEMENTS);
        assertEquals(VALUE_NOT_IN_ELEMENTS, this.customLinkedList.get(INDEX_TO_SET));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetByIndexWithIndexOutOfBounds() {
        this.customLinkedList.set(ELEMENTS.length, VALUE_NOT_IN_ELEMENTS);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testSetByIndexWithNegativeIndex() {
        this.customLinkedList.set(-1, VALUE_NOT_IN_ELEMENTS);
    }

    @Test
    public void testRemoveByIndexWithValidIndex() {
        assertEquals(ELEMENTS[INDEX_TO_REMOVE], this.customLinkedList.get(INDEX_TO_REMOVE));
        this.customLinkedList.removeAt(INDEX_TO_REMOVE);
        assertEquals(ELEMENTS[INDEX_TO_REMOVE + 1], this.customLinkedList.get(INDEX_TO_REMOVE));
    }

    @Test
    public void testRemoveByIndexWhenThereIsOnlyOneItem() {
        CustomLinkedList<String> customLinkedList = new CustomLinkedList<>();
        customLinkedList.add(ELEMENTS[0]);
        customLinkedList.removeAt(0);
    }

    @Test
    public void testRemoveFirstItemByIndex() {
        assertEquals(ELEMENTS[0], this.customLinkedList.get(0));
        this.customLinkedList.removeAt(0);
        assertEquals(ELEMENTS[1], this.customLinkedList.get(0));
    }

    @Test
    public void testRemoveLastItemByIndex() {
        assertEquals(ELEMENTS[ELEMENTS.length - 1], this.customLinkedList.get(ELEMENTS.length - 1));
        assertEquals(ELEMENTS[ELEMENTS.length - 1], this.customLinkedList.removeAt(ELEMENTS.length - 1));
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveByIndexWithIndexOutOfBounds() {
        this.customLinkedList.removeAt(ELEMENTS.length);
    }

    @Test(expected = IllegalArgumentException.class)
    public void testRemoveByIndexWithNegativeIndex() {
        this.customLinkedList.removeAt(-1);
    }

    @Test
    public void testRemoveByItemWhenItemExists() {
        assertEquals(ELEMENTS[INDEX_TO_REMOVE], this.customLinkedList.get(INDEX_TO_REMOVE));
        assertEquals(INDEX_TO_REMOVE, this.customLinkedList.remove(ELEMENTS[INDEX_TO_REMOVE]));
        assertEquals(ELEMENTS[INDEX_TO_REMOVE + 1], this.customLinkedList.get(INDEX_TO_REMOVE));
    }

    @Test
    public void testRemoveByItemWhenItemDoesNotExists() {
        assertEquals(ELEMENTS[INDEX_TO_REMOVE], this.customLinkedList.get(INDEX_TO_REMOVE));
        assertEquals(-1, this.customLinkedList.remove(VALUE_NOT_IN_ELEMENTS));
        assertEquals(ELEMENTS[INDEX_TO_REMOVE], this.customLinkedList.get(INDEX_TO_REMOVE));
    }

    @Test
    public void testIndexOfItemWhenItemExists() {
        assertEquals(INDEX_TO_FIND, this.customLinkedList.indexOf(ELEMENTS[INDEX_TO_FIND]));
    }

    @Test
    public void testIndexOfItemWhenItemDoesNotExists() {
        assertEquals(-1, this.customLinkedList.indexOf(VALUE_NOT_IN_ELEMENTS));
    }

    @Test
    public void testContainsItemWhenItemExists() {
        assertTrue(this.customLinkedList.contains(ELEMENTS[INDEX_TO_FIND]));
    }

    @Test
    public void testContainsItemWhenItemDoesNotExists() {
        assertFalse(this.customLinkedList.contains(VALUE_NOT_IN_ELEMENTS));
    }
}