package ru.job4j.convertlist;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * PaintTest.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 26.11.17
 */
public class ConvertListTest {
    /**
     * whenConvertArrayToList.
     */
    @Test
    public void whenConvertArrayToList() {
        ConvertList convertList = new ConvertList();
        int[][] array = {{1, 2, 3, 4}, {5, 6, 7, 8}};
        List<Integer> result = convertList.toList(array);
        List<Integer> expexted = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8);
        assertThat(expexted, is(result));
    }

    /**
     * whenConvertListToArray.
     */
    @Test
    public void whenConvertListToArray() {
        ConvertList convertList = new ConvertList();
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= 7; i++) {
            list.add(i);
        }
        int[][] result = convertList.toArray(list, 3);
        int[][] expected = {{1, 2, 3}, {4, 5, 6}, {7, 0, 0}};
        assertThat(expected, is(result));
    }

    /**
     * WhenConverListOfTwoArraysToList.
     */
    @Test
    public void whenConvertListOfTwoArraysToList() {
        ConvertList convertList = new ConvertList();
        List<int[]> listOfArrays = new ArrayList<>();
        listOfArrays.add(new int[]{1, 2});
        listOfArrays.add(new int[]{3, 4, 5, 6});
        List<Integer> result = convertList.convert(listOfArrays);
        List<Integer> expected = Arrays.asList(1, 2, 3, 4, 5, 6);
        assertThat(expected, is(result));
    }

}
