package ru.job4j.userconvert;

import java.util.HashMap;
import java.util.List;
/**
 * UserConvert for task "2. Написать программу преобразования List в Map".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 27.11.17
 */
public class UserConvert {

    /**
     * process.
     * @param list - List<User> list.
     * @return HashMap<Integer, User>.
     */

    public HashMap<Integer, User> process(List<User> list) {
        HashMap<Integer, User> userMap = new HashMap<>();
        for (User user : list) {
            userMap.put(user.id, user);
        }

        return userMap;
    }
}
