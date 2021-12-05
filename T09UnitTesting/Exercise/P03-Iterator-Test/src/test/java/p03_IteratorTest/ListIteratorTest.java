package p03_IteratorTest;

import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

import static org.junit.Assert.*;

public class ListIteratorTest {
    private static final String[] INITIAL_STRINGS = {"Pesho", "Ivo", "3", "Empty"};
    private ListIterator listIterator;


    @Before
    public void setUpTests() throws OperationNotSupportedException {
        this.listIterator = new ListIterator(INITIAL_STRINGS);
    }

    @Test
    public void testConstructorWithValidInput() {

        assertEquals(INITIAL_STRINGS[0], listIterator.print());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNullInput() throws OperationNotSupportedException {
        new ListIterator(null);
    }

    @Test
    public void testHasNextWhenThereIsNextElement() {
        assertTrue(this.listIterator.hasNext());
    }

    @Test
    public void testHasNextWhenAtLastElement() {
        for (int i = 0; i < INITIAL_STRINGS.length - 1; i++) {
            assertTrue(this.listIterator.hasNext());
            this.listIterator.move();
        }
        assertFalse(this.listIterator.hasNext());
    }

    @Test
    public void testMoveWhenThereIsNextElement() {
        assertTrue(this.listIterator.hasNext());
        assertTrue(this.listIterator.move());
    }

    @Test
    public void testMoveWhenAtLastElement() {
        for (int i = 0; i < INITIAL_STRINGS.length - 1; i++) {
            assertTrue(this.listIterator.hasNext());
            assertTrue(this.listIterator.move());
            assertEquals(INITIAL_STRINGS[i + 1], this.listIterator.print());
        }
        assertFalse(this.listIterator.hasNext());
        assertFalse(this.listIterator.move());
        assertEquals(INITIAL_STRINGS[INITIAL_STRINGS.length - 1], this.listIterator.print());
    }

    @Test
    public void testPrintWhenThereIsValidElement() {
        int index = 0;
        assertEquals(INITIAL_STRINGS[index], this.listIterator.print());
        while (this.listIterator.hasNext()) {
            this.listIterator.move();
            index++;
            assertEquals(INITIAL_STRINGS[index], this.listIterator.print());
        }
    }


    @Test(expected = IllegalStateException.class)
    public void testMoveWhenThereIsNoElements() throws OperationNotSupportedException {
        ListIterator listIterator = new ListIterator();
        listIterator.print();
    }
}