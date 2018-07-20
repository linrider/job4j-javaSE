package ru.job4j.simplearray;

import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.*;
/**
 * SimpleListTest.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 21.05.18
 */
public class SimpleArrayTest {

    /**
     * whenCreateContainerShouldReturnTheSameType.
     */
    @Test
    public void whenCreateContainerShouldReturnTheSameType() {
        SimpleArray<String> simple = new SimpleArray<String>(4);
        simple.add("test");
        String result = simple.get(0);

        assertThat(result, is("test"));
    }

    /**
     * whenTypeIntShouldReturnTheSameType.
     */
    @Test
    public void whenTypeIntShouldReturnTheSameType() {
        SimpleArray<Integer> simple = new SimpleArray<>(4);
        simple.add(2);
        int result = simple.get(0);

        assertThat(result, is(2));
    }

    /**
     * whenCreatedContainerIsOverflowing.
     */
    @Test(expected = ArrayIndexOutOfBoundsException.class)
    public void whenCreatedContainerIsOverflowing() {
        SimpleArray<Integer> simple = new SimpleArray<>(2);
        simple.add(1);
        simple.add(2);
        simple.add(3);
    }

    /**
     * whenCreateContainerAndChangeOneEntryThenReturnChangedValue.
     */
    @Test
    public void whenCreateContainerAndChangeOneEntryThenReturnChangedValue() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("one");
        simple.add("two");
        simple.add("three");
        simple.add("four");
        simple.set(2, "changed");
        String result = simple.get(2);

        assertThat(result, is("changed"));
    }

    /**
     * whenCreateContainerAndDeleteOneEntryThenReturnChangedValue.
     */
    @Test
    public void whenCreateContainerAndDeleteOneEntryThenReturnChangedValue() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("one");
        simple.add("two");
        simple.add("three");
        simple.add("four");
        simple.delete(2);
        String result = simple.get(2);

        assertThat(result, is(nullValue()));
    }

    /**
     * whenCreateContainerAndGetIterator.
     */
    @Test
    public void whenCreateContainerAndGetIterator() {
        SimpleArray<String> simple = new SimpleArray<>(4);
        simple.add("one");
        simple.add("two");
        simple.add("three");
        simple.add("four");
        Iterator it = simple.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("one"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("three"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("four"));
        assertThat(it.hasNext(), is(false));
    }


}