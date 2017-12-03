package ru.job4j.sortUser;

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
    public TreeSet<User> sort (List<User> users) {
        TreeSet<User> userSet = new TreeSet<>(new Comparator<User>() {
            @Override
            public int compare(User left, User right) {
                return Integer.compare(left.age, right.age);
            }
        });
        userSet.addAll(users);
        return userSet;
    }
}
