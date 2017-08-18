package ru.job4j.array;

/**
 * BubbleSort. task "5.1. Создать программу для сортировки массива методом перестановки. [#195]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class BubbleSort {
    /**
     * Sort.
     * @param array - array[].
     */
    public int[] sort(int[] array) {
        int tmp;
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i] > array[j]) {
                    tmp = array[i];
                    array[i] = array[j];
                    array[j] = tmp;
                }
            }
        }
        return array;
    }
}
