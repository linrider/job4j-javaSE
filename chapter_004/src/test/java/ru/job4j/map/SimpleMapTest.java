package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.GregorianCalendar;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class SimpleMapTest {
    SimpleMap<User, String> simpleMap = new SimpleMap<>();

    @Before
    public void setUsers() {
        User user1 = new User("John", 2, new GregorianCalendar(1972, 8, 01));
        User user2 = new User("Paul", 0, new GregorianCalendar(2000, 0, 18));
        User user3 = new User("George", 3, new GregorianCalendar(1984, 5, 30));
    }

    @Test
    public void insert() {
        assertThat(simpleMap.insert(user1, "plumber"), is(true));
    }

    @Test
    public void get() {
    }

    @Test
    public void delete() {
    }

    @Test
    public void iterator() {
    }
}