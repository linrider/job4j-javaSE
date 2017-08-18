package ru.job4j.array;
/**
 * Test for RotateArray.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class RotateArrayTest {
    @Test
    public void whenRotateTwoRowTwoColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int [][] testArray = {{1, 2}, {3, 4}};
        int [][] resultArray = rotateArray.rotate(testArray);
        int [][] expextedArray = { {3, 1}, {4, 2} };
        assertThat(resultArray, is(expextedArray));
    }

    @Test
    public void whenRotateThreeRowThreeColArrayThenRotatedArray() {
        RotateArray rotateArray = new RotateArray();
        int [][] testArray = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        int [][] resultArray = rotateArray.rotate(testArray);
        int [][] expextedArray = { {7, 4, 1}, {8, 5, 2}, {9, 6, 3} };
        assertThat(resultArray, is(expextedArray));
    }
}
