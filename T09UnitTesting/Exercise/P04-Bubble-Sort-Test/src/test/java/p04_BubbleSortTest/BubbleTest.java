package p04_BubbleSortTest;

import org.junit.Test;

import static org.junit.Assert.*;

public class BubbleTest {

    @Test
    public void testSort() {
        int[] unsortedData = { 12, 15, 0, -1, 4, 5, 3 };
        int[] sortedData = { -1, 0, 3, 4, 5, 12, 15 };
        Bubble.sort(unsortedData);
        assertArrayEquals(sortedData, unsortedData);
    }

}