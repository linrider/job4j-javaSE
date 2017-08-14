package ru.job4j.max;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Max from 2 and 3 numbers "3.4. Максимум из трех чисел [#190]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */


public class MaxTest {
    /**
     * Test max from 2.
     */
    @Test
    public void whenFirstLessSecond() {
        Max maxim = new Max();
        int result = maxim.max(1, 2);
        assertThat(result, is(2));
    }
    /**
     * Test max from 3.
     */
    @Test
    public void whenFirstLessSecondAndThird() {
        Max maxim = new Max();
        int result = maxim.max(1, 2, 3);
        assertThat(result, is(3));
    }
}
