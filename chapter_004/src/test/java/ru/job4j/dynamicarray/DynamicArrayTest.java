package ru.job4j.dynamicarray;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * SimpleArrayList for task "5.3.1. Создать динамический список на базе массива [#158]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 24.06.18.
 */
public class DynamicArrayTest {
    DynamicArray<Integer> dynamicArray = new DynamicArray<>(3);

    /**
     * setUp.
     */
    @Before
    public void setUP() {
        dynamicArray.add(1);
        dynamicArray.add(2);
        dynamicArray.add(3);
        dynamicArray.add(4);
    }

    /**
     * whenReturnSizeOfListAfterRecentlyAddedElementsReturn.
     */
    @Test
    public void whenReturnSizeOfListAfterRecentlyAddedElementsReturn() {
        assertThat(dynamicArray.size(), is(4));
    }

    /**
     * whenReturnEveryMembersOfList.
     */
    @Test
    public void whenReturnEveryMembersOfList() {
        assertThat(dynamicArray.get(0), is(1));
        assertThat(dynamicArray.get(1), is(2));
        assertThat(dynamicArray.get(2), is(3));
        assertThat(dynamicArray.get(3), is(4));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<Integer> it = dynamicArray.iterator();
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
        Iterator<Integer> it = dynamicArray.iterator();
        it.next();
        dynamicArray.add(5);
        it.next();
    }
}