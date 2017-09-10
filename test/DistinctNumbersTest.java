import org.junit.Test;

import static org.junit.Assert.*;

public class DistinctNumbersTest {

    private int[] input = {0, 1, 2, 3, 3, 5, 9, 9, 10, 12};

    @Test
    public void countDistinctNumbersInArray() {
        int expected = 8;
        assertEquals("Incorrect count of distinct numbers", expected, DistinctNumbers.countDistinctNumbersInArray(input));
    }

    @Test
    public void getDistinctNumbers() {
        String expected = "0 1 2 3 5 9 10 12 ";
        String actual = DistinctNumbers.getDistinctNumbers(input);

        assertTrue("Failed to get distinct numbers", expected.equals(actual));
    }

}