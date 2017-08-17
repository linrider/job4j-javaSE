package ru.job4j.array;

/**
 * Test for Turn.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class TurnTest {
    @Test
    public void whenTurnArrayWithEvenAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] testArray = {2, 6, 1, 4};
        int[] result = turn.back(testArray);
        int[] expected = {4, 1, 6, 2};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий переворот массива с чётным числом элементов, например {2, 6, 1, 4}.
    }

    @Test
    public void whenTurnArrayWithOddAmountOfElementsThenTurnedArray() {
        Turn turn = new Turn();
        int[] testArray = {1, 2, 3, 4, 5};
        int[] result = turn.back(testArray);
        int[] expected = {5, 4, 3, 2, 1};
        assertThat(result, is(expected));
        //напишите здесь тест, проверяющий переворот массива с нечётным числом элементов, например {1, 2, 3, 4, 5}.
    }
}
