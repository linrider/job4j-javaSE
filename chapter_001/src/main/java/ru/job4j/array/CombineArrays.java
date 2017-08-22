package ru.job4j.array;

/**
 * CombineArrays. task "Объединение двух массивов с последующей сортировкой".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 22.08.17
 *
 */public class CombineArrays {
    /**
     * Back.
     * @param array1 - array[].
     * @param array2 - array[].
     */
    public int[] combine(int[] array1, int[] array2) {
        int[] combinedArray = new int[array1.length + array2.length];

        for (int i = 0; i < array1.length; i++) combinedArray[i] = array1[i];
        for (int i = 0; i < array2.length; i++) combinedArray[i + array1.length] = array2[i];

        return combinedArray;
    }
}
