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
        int leftSum = 0;
        int rightSum = 0;
        for (Integer x : left) {
            leftSum += x;
        }
        for (Integer x : right) {
            rightSum += x;
        }
        final int res = Integer.compare(left.size(), right.size());
        return res == 0 ? Integer.compare(leftSum, rightSum) : res;
    }

}
