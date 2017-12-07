package ru.job4j.convertlist;

import java.util.ArrayList;
import java.util.List;
/**
 * ConvertList for task "3. Конвертация двумерного массива в ArrayList и наоборот".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 25.11.17
 */
public class ConvertList {

    /**
     * toList.
     * @param array -int[][].
     * @return List<Integer>.
     */
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();

        for (int[] x : array) {
            for (int y : x) {
                list.add(y);
            }
        }
        return list;
    }

    /**
     * toArray.
     * @param list - List.
     * @param rows - int.
     * @return int[][].
     */
    public int[][] toArray(List<Integer> list, int rows) {
        int[][] array2D = new int[rows][rows];
        while (list.size() % rows != 0) {
            list.add(0);
        }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                array2D[i][j] = list.get(0);
                list.remove(0);
            }
        }
        return array2D;
    }

    /**
     * convert.
     * @param list - List<Integer>.
     * @return - List<int[]>.
     */
    public List<Integer> convert(List<int[]> list) {
        List<Integer> result = new ArrayList<>();
        for (int[] arrray : list) {
            for (int value : arrray) {
                result.add(value);
            }
        }
        return result;
    }
}
