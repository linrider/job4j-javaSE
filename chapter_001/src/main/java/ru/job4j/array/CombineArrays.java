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
        int tmp;
        for (int i = 0; i < array2.length; i++) {
            for (int j = i; j < combinedArray.length - 1; j++) {
                if (array2[i] <= combinedArray[j]) {
                    tmp = combinedArray[j + 1];
                    for (int k = j; k < combinedArray.length; k++) {
                        combinedArray[k] = tmp;
                    }
                    combinedArray[j] = combinedArray[i];
                }
            }
        }

        return combinedArray;
    }

}
