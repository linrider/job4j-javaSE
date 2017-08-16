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

        return first > second ? first : second;
    }

    public int max(int first, int second, int third) {

        return max(first, max(second, third));
    }
}
