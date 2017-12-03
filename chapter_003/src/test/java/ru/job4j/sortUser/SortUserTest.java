package ru.job4j.sortUser;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.TreeSet;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * Package for SortUserTest.
 * @author Wladyslaw Lazin (mailto:wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 03.12.17
 */
public class SortUserTest {
    /**
     * WhenListOfUsersConvertToTreeSetOfUsers.
     */
    @Test
    public void WhenListOfUsersConvertToTreeSetOfUsers() {
        SortUser sortUser = new SortUser();
        List<User> userList = Arrays.asList(new User("Buster", 25), new User("Chopstick", 15),
                new User("Gray Balls", 47), new User("Chopstick", 13));
        TreeSet<User> resultSet = sortUser.sort(userList);
        String result = resultSet.toString();
        String expected = "[User{name='Chopstick', age=13}, User{name='Chopstick', age=15}, User{name='Buster', age=25}, User{name='Gray Balls', age=47}]";
        assertThat(result, is(expected));
    }
}
