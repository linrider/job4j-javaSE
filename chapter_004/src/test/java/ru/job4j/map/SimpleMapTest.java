package ru.job4j.map;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.GregorianCalendar;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

/**
 * SimpleMapTest for task "8. Реализовать собственную структуру данных - HashMap [#1008]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 15.08.18.
 */
public class SimpleMapTest {
    SimpleMap<User, String> simpleMap = new SimpleMap<>();
    User user1 = new User("John", 2, new GregorianCalendar(1972, 8, 01));
    User user2 = new User("Paul", 0, new GregorianCalendar(2000, 0, 18));
    User user3 = new User("George", 3, new GregorianCalendar(1984, 5, 30));

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        simpleMap.insert(user1, "plumber");
        simpleMap.insert(user2, "baker");
        simpleMap.insert(user3, "doctor");
    }

    /**
     * whenTryToInsertExistingEntryThenGetFalse.
     */
    @Test
    public void whenTryToInsertExistingEntryThenGetFalse() {
        assertThat(simpleMap.insert(user1, "loyer"), is(false));
    }

    /**
     * whenRequestKeyThenGetValue.
     */
    @Test
    public void whenRequestKeyThenGetValue() {
        assertThat(simpleMap.get(user1), is("plumber"));
    }

    /**
     * whenDeleteOneEntryThenChangeMapSizeAndGetTrue.
     */
    @Test
    public void whenDeleteOneEntryThenChangeMapSizeAndGetTrue() {
        assertThat(simpleMap.size(), is(3));
        assertThat(simpleMap.delete(user1), is(true));
        assertThat(simpleMap.size(), is(2));
    }

    /**
     * whenAddingEntriesOverflowPrimaryTableThenTableResize.
     */
    @Test
    public void whenAddingEntriesOverflowPrimaryTableThenTableResize() {
        SimpleMap<Integer, String> resizedMap = new SimpleMap<>();
        for (int i = 1; i < 32; i++) {
            resizedMap.insert(i, "value");
        }
        assertThat(resizedMap.getTableSize(), is(32));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<SimpleMap<User, String>.Entry<User, String>> it = simpleMap.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("plumber"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("baker"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next().getValue(), is("doctor"));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * whenTryConcurrentModifyThenReturnException.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenTryConcurrentModifyThenReturnException() {
        Iterator<SimpleMap<User, String>.Entry<User, String>> it = simpleMap.iterator();
        it.next();
        simpleMap.insert(new User("Simon", 0, new GregorianCalendar(1982, 11, 31)), "useless");
        it.next();
    }

    /**
     * whenTryToStartIterationsWithEmptyMap.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenTryToStartIterationsWithEmptyMap() {
        SimpleMap<User, String> emptyMap = new SimpleMap<>();
        Iterator<SimpleMap<User, String>.Entry<User, String>> it = emptyMap.iterator();
        it.next();
    }
}