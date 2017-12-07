package ru.job4j.array;
/**
 * RotateArray. task "5.2. Создание программы поворота квадратного массива. [#223]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class RotateArray {
    /**
     * Rotate.
     * @param array - array[][].
     */
    public int[][] rotate(int[][] array) {

        int[][] rotated = new int[array.length][array.length];
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length; j++) {
                rotated [j][array.length - i - 1] = array [i][j];
            }
        }
        return rotated;
    }
}
