package ru.job4j.sortUser;

import org.junit.Test;

import java.util.ArrayList;
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
                new User("Jerker", 13), new User("Gray Balls", 47), new User("Chopstick", 13));
        TreeSet<User> resultSet = sortUser.sort(userList);
        String result = resultSet.toString();
        String expected = "[User{name='Chopstick', age=13}, User{name='Jerker', age=13}, User{name='Chopstick', age=15}, User{name='Buster', age=25}, User{name='Gray Balls', age=47}]";
        assertThat(result, is(expected));
    }

    /**
     * WhenListOfUsersSortByUsersNamesLength.
     */
    @Test
    public void WhenListOfUsersSortByUsersNamesLength() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("John", 23));
        users.add(new User("Adam", 34));
        users.add(new User("Ann", 19));
        users.add(new User("Sarah", 20));
        String result = sortUser.sortNameLength(users).toString();
        String expected = "[User{name='Ann', age=19}, User{name='Adam', age=34}, User{name='John', age=23}, User{name='Sarah', age=20}]";
        assertThat(result, is(expected));
    }

    /**
     * WhenListOfUsersSortByNameThenSortByAgeю
     */
    @Test
    public void WhenListOfUsersSortByNameThenSortByAge() {
        SortUser sortUser = new SortUser();
        ArrayList<User> users = new ArrayList<>();
        users.add(new User("Сергей", 25));
        users.add(new User("Иван", 30));
        users.add(new User("Сергей", 20));
        users.add(new User("Иван", 25));
        String result = sortUser.sortByAllFields(users).toString();
        String expected = "[User{name='Иван', age=25}, User{name='Иван', age=30}, User{name='Сергей', age=20}, User{name='Сергей', age=25}]";
        assertThat(result, is(expected));
    }
}
