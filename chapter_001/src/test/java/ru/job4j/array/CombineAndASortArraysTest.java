package ru.job4j.array;
/**
 * Test for CombineArrays.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class CombineAndASortArraysTest {
    @Test
    public void whenCombineTwoArraysThenCombinedSortedArray() {
        CombineArrays combineArrays = new CombineArrays();
        BubbleSort bubbleSort = new BubbleSort();
        int[] testArray1 = {1, 3, 5, 7, 9};
        int[] testArray2 = {0, 2, 4, 6, 8};
        int[] resultArray = bubbleSort.sort(combineArrays.combine(testArray1, testArray2));
        int[] expectedArray = {0, 1, 2, 3, 4, 5, 6, 7, 8, 9};
        assertThat(resultArray, is(expectedArray));
    }

}
