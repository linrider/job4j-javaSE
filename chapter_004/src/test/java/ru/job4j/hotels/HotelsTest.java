package ru.job4j.hotels;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * HotelsTest for Hotels task "Отели [#121887]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 21.03.19.
 */
public class HotelsTest {
    /**
     * whenAddFiveHotelsThenGetTheirStars.
     */
    @Test
    public void whenAddFiveHotelsThenGetTheirStars() {
        Hotels hotels = new Hotels();
        int[] result = {4, 2, 5, 3, 1};
        List<Integer> ratings = Arrays.asList(99, 2, 100, 50, 1);
        assertThat(hotels.getStars(5, ratings), is(result));
    }

    /**
     * whenAddTenHotelsThenGetTheirStars.
     */
    @Test
    public void whenAddTenHotelsThenGetTheirStars() {
        Hotels hotels = new Hotels();
        int[] result = {5, 5, 1, 1, 3, 3, 2, 2, 4, 4};
        List<Integer> ratings = Arrays.asList(100, 90, 10, 20, 50, 60, 40, 30, 80, 70);
        assertThat(hotels.getStars(10, ratings), is(result));
    }
}