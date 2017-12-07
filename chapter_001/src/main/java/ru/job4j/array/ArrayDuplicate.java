package ru.job4j.array;
/**
 * ArrayDuplicate. task "5.3. Удаление дубликатов в массиве. [#225]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import java.util.Arrays;

public class ArrayDuplicate {
    /**
     * Sort.
     * @param array - array[].
     */
    public String[] remove(String[] array) {
        //заменяем дубли на пустые элемнеты
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i + 1; j < array.length; j++) {
                if (array[i].equals(array[j])) {
                    array[j] = "";
                }
            }
        }
        //двигаем пустые элементы в конец массива
        for (int i = 0; i < array.length - 1; i++) {
            for (int j = i; j < array.length; j++) {
                if (array[i].equals("")) {
                    array[i] = array[j];
                    array[j] = "";
                }
            }
        }
        // находим количесво оригинальных элементов
        int count = 0;
        for (int i = 0; i < array.length; i++) {
            if (!array[i].equals("")) {
                count++;
            }
        }

        String[] newArray = Arrays.copyOf(array, count);
        return newArray;
    }
}
