package ru.job4j.arrayCollation;

import java.util.HashMap;
import java.util.Map;

/**
 * ArrayCollation for task "Сравнение массивов".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 20.03.19.
 */
public class ArrayCollation<E> {

    /**
     * toMap.
     * @param array - E[].
     * @return Map<E, Integer>.
     */
    private Map<E, Integer> toMap(E[] array) {
        Map<E, Integer> result = new HashMap<>();
        for (E element : array)
            if (result.containsKey(element)) {
                Integer value = result.get(element);
                result.put(element, ++value);
            } else {
                result.put(element, 1);
            }
        return result;
    }

    /**
     * arraysCompare.
     * @param arr1 - E[].
     * @param arr2 - E[].
     * @return boolean.
     */
    boolean arraysCompare(E[] arr1, E[] arr2) {
        Map<E, Integer> map1 = toMap(arr1);
        Map<E, Integer> map2 = toMap(arr2);
        return map1.size() == map2.size() && map1.equals(map2);
    }
}
