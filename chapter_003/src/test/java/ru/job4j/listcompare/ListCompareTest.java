package ru.job4j.listcompare;

import org.junit.Test;
import java.util.Arrays;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * ListCompareTest.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 30.12.17
 */
public class ListCompareTest {
    /**
     * whenLeftAndRightEqualsThenZero.
     */
    @Test
    public void whenLeftAndRightEqualsThenZero() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2, 3),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(0));
    }

    /**
     * whenLeftGreatRightThenMunis.
     */
    @Test
    public void whenLeftGreatRightThenMinus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(-1));
    }

    /**
     * whenLeftLessRightThenPlus
     */
    @Test
    public void whenLeftLessRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(1, 2),
                Arrays.asList(1, 1)
        );
        assertThat(rst, is(1));
    }

    /**
     * whenLeftLessAndShorterThanRightThenPlus.
     */
    @Test
    public void whenLeftLessAndShorterThanRightThenPlus() {
        ListCompare compare = new ListCompare();
        int rst = compare.compare(
                Arrays.asList(2),
                Arrays.asList(1, 2, 3)
        );
        assertThat(rst, is(1));
    }
}


