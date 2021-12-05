package p01_Database;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class DatabaseTest {
    private static final Integer[] NUMBERS_ARRAY = {0, 1, 2, 3, 4, 5};
    private static final int TOO_MANY_ELEMENTS = 17;
    private static final Integer VALUE_TO_ADD = 13;
    private Database database;

    @Before
    public void setUpTests() throws OperationNotSupportedException {
        this.database = new Database(NUMBERS_ARRAY);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWithZeroElements() throws OperationNotSupportedException {
        Database database = new Database();
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorThrowExceptionWithBiggerInputArray() throws OperationNotSupportedException {
        Database database = new Database(new Integer[TOO_MANY_ELEMENTS]);
    }

    @Test
    public void testConstructorWithCorrectInput() {
        Integer[] actualElements = this.database.getElements();
        assertEquals(NUMBERS_ARRAY.length, actualElements.length);
        assertArrayEquals(NUMBERS_ARRAY, actualElements);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testAddWithNullElement() throws OperationNotSupportedException {
        this.database.add(null);
    }

    @Test
    public void testAddWithCorrectElement() throws OperationNotSupportedException {
        this.database.add(VALUE_TO_ADD);

        Integer[] actualElements = this.database.getElements();
        assertEquals(NUMBERS_ARRAY.length + 1, actualElements.length);
        assertEquals(VALUE_TO_ADD, actualElements[actualElements.length - 1]);
    }

    @Test
    public void testRemoveElementWithElements() throws OperationNotSupportedException {
        this.database.remove();
        Integer[] actualElements = this.database.getElements();
        assertEquals(NUMBERS_ARRAY.length - 1, actualElements.length);
        assertEquals(NUMBERS_ARRAY[NUMBERS_ARRAY.length - 2], actualElements[actualElements.length - 1]);

    }

    @Test(expected = OperationNotSupportedException.class)
    public void testRemoveThrowExceptionWhenThereIsNoElements() throws OperationNotSupportedException {
        for (int i = 0; i < NUMBERS_ARRAY.length; i++) {
            database.remove();
        }
        database.remove();
    }
}