package ru.job4j.strategy;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * PaintTest.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 05.10.17
 */
public class PaintTest {
    /**
     * whenWeNeedSquareThenStrategyDrawsSquare.
     */
    @Test
    public void whenWeNeedSquareThenStrategyDrawsSquare() {
        Paint paint = new Paint(new Square());
        String lineEnd = System.getProperty("line.separator");
        String expected = String.format("++++%s+  +%s+  +%s++++", lineEnd, lineEnd, lineEnd);
        String result = paint.defineShape();
        assertThat(expected, is(result));
    }

    /**
     * whenWeNeedTriangleThenStrategyDrawsTriangle.
     */
    @Test
    public void  whenWeNeedTriangleThenStrategyDrawsTriangle() {
        Paint paint = new Paint(new Triangle());
        String lineEnd = System.getProperty("line.separator");
        String expected = String.format("   +   %s  + +  %s +   + %s+++++++", lineEnd, lineEnd, lineEnd);
        String result = paint.defineShape();
        assertThat(expected, is(result));
    }

}
