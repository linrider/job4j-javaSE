package ru.job4j.max;

/**
 * Max.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Max {
    public int max(int first, int second) {
        int max;
        max = first > second ? first : second;
        return max;
    }
}
