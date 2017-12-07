package ru.job4j.array;

/**
 * Test for ArrayDuplicate.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class ArrayDuplicateTest {
    @Test
    public void whenRemoveDuplicatesThenArrayWithoutDuplicate() {
        ArrayDuplicate arrayDuplicate = new ArrayDuplicate();
        String[] testArray = {"cat", "dog", "mouse", "cat", "dog", "dog", "parrot", "chicken", "pig", "cow", "pig"};
        String[] resultArray = arrayDuplicate.remove(testArray);
        String[] expectedArray = {"cat", "dog", "mouse", "parrot", "chicken", "pig", "cow"};
        assertThat(resultArray, is(expectedArray));

    }
}
