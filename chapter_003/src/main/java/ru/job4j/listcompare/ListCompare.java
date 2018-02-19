package ru.job4j.listcompare;

import java.util.Comparator;
import java.util.List;

/**
 * ListCompare for task "3. Компаратор для массивов. [#35008]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 30.12.17
 */
public class ListCompare implements Comparator<List<Integer>> {

    /**
     * compare.
     * @param left - List<Integer>.
     * @param right - List<Integer>.
     * @return int.
     */
    @Override
    public int compare(List<Integer> left, List<Integer> right) {
        int res = 0;
        for (int i = 0; i < (left.size() < right.size() ? left.size() : right.size()); i++) {
            res = Integer.compare(left.get(i), right.get(i));
            if (res != 0) {
                break;
            }
        }

        return res == 0 ? Integer.compare(left.size(), right.size()) : res;
    }

}
