package ru.job4j.user;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * UserConvertTest for task "2. Написать программу преобразования List в Map".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 27.11.17
 */
public class UserConvertTest {
    /**
     * WhenUsersListConvertToMap.
     */
    @Test
    public void  WhenUsersListConvertToMap() {
        UserConvert userConvert = new UserConvert();
        List<User> userList = new ArrayList<>();
        User robertSmith = new User("Robert Smith", "New York", 1);
        User angusYoung = new User("Angus Young", "Sidney", 2);
        userList.add(robertSmith);
        userList.add(angusYoung);
        HashMap<Integer, User> result = userConvert.process(userList);
        HashMap<Integer, User> expected = new HashMap<>();
        expected.put(1, robertSmith);
        expected.put(2, angusYoung);
        assertThat(expected, is(result));
    }
}
