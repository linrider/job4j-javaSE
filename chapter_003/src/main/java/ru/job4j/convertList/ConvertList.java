package ru.job4j.convertList;

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
    public static List<Integer> toList (int[][] array) {
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
    public static int[][] toArray (List<Integer> list, int rows) {
        int [][] array2D = new int[rows][rows];
        while (list.size() % rows != 0) { list.add(0); }

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < rows; j++) {
                array2D[i][j] = list.get(0);
                list.remove(0);
            }
        }

        return array2D;
    }

    /**
     * main.
     * @param args - String[].
     */
    public static void main(String[] args) {
        int[][] array = { {1, 2, 3, 4}, {5, 6, 7, 8} };
        for (Integer x : toList(array)) {
            System.out.print(String.format("%s ", x));
        }
        System.out.println();

        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) { list.add(i); }

        for (int[] x : toArray(list, 3)) {
            for (int y : x) {
                System.out.print(String.format("%s ", y));
            }
            System.out.println("");
        }
    }
}
