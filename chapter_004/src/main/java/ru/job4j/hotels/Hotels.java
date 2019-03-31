package ru.job4j.hotels;

import java.util.*;
/**
 * Hotels for task "Отели [#121887]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 21.03.19.
 */
public class Hotels {

    /**
     * @param n - int.
     * @param ratings - List<>Integer>.
     * @return Object[].
     */
    protected Object[] getStars(int n, List<Integer> ratings) {
        Map<Integer, Integer> starsMap = new LinkedHashMap<>();
        for (Integer shuttle : ratings) {
            starsMap.put(shuttle, 0);
        }
        Integer stars = 1;
        int step = n / 5;
        int count = 1;
        TreeSet<Integer> ratingSet = new TreeSet<>(ratings);
        for (Integer shuttle : ratingSet) {
            if (count > step) {
                stars++;
                count = 1;
            }
            starsMap.put(shuttle, stars);
            count++;
        }
        return starsMap.values().toArray();
    }
}
