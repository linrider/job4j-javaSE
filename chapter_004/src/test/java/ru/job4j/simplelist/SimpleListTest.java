package ru.job4j.simplelist;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * SimpleLinkedList for task "5.3.1. Создать динамический список на базе массива [#158]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 24.06.18.
 */
public class SimpleListTest {
    SimpleList<Integer> simpleList = new SimpleList<>(3);

    /**
     * setUp.
     */
    @Before
    public void setUP() {
        simpleList.add(1);
        simpleList.add(2);
        simpleList.add(3);
        simpleList.add(4);
    }

    /**
     * whenReturnSizeOfListAfterRecentlyAddedElementsReturn.
     */
    @Test
    public void whenReturnSizeOfListAfterRecentlyAddedElementsReturn() {
        assertThat(simpleList.size(), is(4));
    }

    /**
     * whenReturnEveryMembersOfList.
     */
    @Test
    public void whenReturnEveryMembersOfList() {
        assertThat(simpleList.get(0), is(1));
        assertThat(simpleList.get(1), is(2));
        assertThat(simpleList.get(2), is(3));
        assertThat(simpleList.get(3), is(4));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<Integer> it = simpleList.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * whenTryConcurrentModifyThenReturnException.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenTryConcurrentModifyThenReturnException() {
        Iterator<Integer> it = simpleList.iterator();
        it.next();
        simpleList.add(5);
        it.next();
    }
}