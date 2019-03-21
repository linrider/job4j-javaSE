package ru.job4j.arrayCollation;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * ArrayCollationTest for ArrayCollation task.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 20.03.19.
 */
public class ArrayCollationTest {

    /**
     * whenTheBothArraysAreIdenticalTHeGetTrue.
     */
    @Test
    public void whenTheBothArraysAreIdenticalTHeGetTrue() {
        String[] arr1 = {"Васька", "Мурка", "Шарик", "Васька", "Бася"} ;
        String[] arr2 = { "Мурка", "Бася", "Васька", "Шарик", "Васька"};
        ArrayCollation<String> arrayCollation = new ArrayCollation<>();
        assertThat(arrayCollation.arraysCompare(arr1, arr2),is(true));
    }

    /**
     * whenTheArraysAreNonidenticalThenGetFalse.
     */
    @Test
    public void whenTheArraysAreNonidenticalThenGetFalse() {
        String[] arr1 = {"Васька", "Мурка", "Барбос", "Васька", "Бася"} ;
        String[] arr2 = { "Мурка", "Бася", "Васька", "Шарик", "Васька"};
        ArrayCollation<String> arrayCollation = new ArrayCollation<>();
        assertThat(arrayCollation.arraysCompare(arr1, arr2),is(false));
    }
}
