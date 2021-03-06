package ru.job4j.sortuser;

import java.util.*;
/**
 * SortUser for task "1. Организовать сортировку User".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 03.12.17
 */
public class SortUser {

    /**
     * sort.
     * @param users - List<User>.
     * @return - TreeSet<User>.
     */
    public TreeSet<User> sort(List<User> users) {
        TreeSet<User> userSet = new TreeSet<>(users);
        return userSet;
    }

    /**
     * sortNameLength.
     * @param users - Lisr<User>.
     * @return - Lisr<User>.
     */
    public List<User> sortNameLength(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User left, User right) {
                return left.name.length() > right.name.length() ? 1 :  -1;
            }
        });
        return users;
    }

    /**
     * sortByAllFields.
     * @param users - List<User>.
     * @return - List<User>.
     */
    public List<User> sortByAllFields(List<User> users) {
        users.sort(new Comparator<User>() {
            @Override
            public int compare(User left, User right) {
                final int res = left.name.compareTo(right.name);
                return res != 0 ? res : Integer.compare(left.age, right.age);
            }
        });
        return users;
    }
}
