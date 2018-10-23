package ru.job4j.diapason;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Diapason for task "Подсчет функции в диапазоне. [#24251]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 22.10.18.
 */
public class Diapason {

    /**
     * @param start - int.
     * @param end - int.
     * @param func - Function<Double, Double>.
     * @return List<Double>.
     */
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (int i = start; i <= end; i++) {
        result.add(func.apply((double) i));
        }
        return result;

    }


}
