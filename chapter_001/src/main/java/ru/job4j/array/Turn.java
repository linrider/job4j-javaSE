package ru.job4j.array;

/**
 * Turn. task "5.0 Перевернуть массив [#4441]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Turn {

    /**
     * Back.
     * @param array - array[].
     */

    public int[] back(int[] array) {
        int tmp;
        for (int i = 0; i < array.length / 2; i++) {
            tmp = array[array.length - i - 1];
            array[array.length - i - 1] = array[i];
            array[i] = tmp;
        }
        return array;
    }

}
