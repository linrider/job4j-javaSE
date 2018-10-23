package ru.job4j.diapason;

import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * DiapasonTest for task "Подсчет функции в диапазоне. [#24251]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 22.10.18.
 */
public class DiapasonTest {
    Diapason diap = new Diapason();
    private List<Double> buffer = new ArrayList<>();

    /**
     * whenLinearFunctionSentThenGotItsValues.
     */
    @Test
    public void whenLinearFunctionSentThenGotItsValues() {
        buffer.addAll(diap.diapason(1, 5, arg -> 2 * arg));
        assertThat(buffer, is(Arrays.asList(2D, 4D, 6D, 8D, 10D)));
    }

    /**
     * whenQuadraticFunctionSentThenGotItsValues.
     */
    @Test
    public void whenQuadraticFunctionSentThenGotItsValues() {
        buffer.addAll(diap.diapason(1, 5, arg -> Math.pow(arg, 2)));
        assertThat(buffer, is(Arrays.asList(1D, 4D, 9D, 16D, 25D)));
    }

    /**
     * whenLogarithmicFunctionSentThenGotItsValues.
     */
    @Test
    public void whenLogarithmicFunctionSentThenGotItsValues() {
        buffer.addAll(diap.diapason(1, 5, arg -> Math.round(Math.log(arg) * 100) / 100D));
        assertThat(buffer, is(Arrays.asList(0D, 0.69D, 1.1D, 1.39D, 1.61D)));
    }

}