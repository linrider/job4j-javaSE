package ru.job4j.array;
/**
 * FindWord. task "Проверка, что одно слово находится в другом слове [#228]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class FindWord {
    /**
     * Sort.
     * @param origin - String.
     * @param sub - String.
     */
    public  boolean contains(String origin, String sub) {
        boolean isContained = true;
        char [] originChars = origin.toCharArray();
        char [] subChars = sub.toCharArray();

        for (int i = 0; i < originChars.length; i++) {
            if (originChars[i] == subChars[0]) {
                for (int j = 1; j < subChars.length; j++) {
                    if (subChars[j] == originChars[i + j]) isContained = true;
                    else {
                        isContained = false;
                        break;
                    }
                }
            }
        }
        return isContained;
    }
}
