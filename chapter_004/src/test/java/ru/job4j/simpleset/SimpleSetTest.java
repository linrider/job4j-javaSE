package ru.job4j.simpleset;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleListTest for task "1. Реализовать коллекцию Set на массиве [#996]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 19.07.18.
 */
public class SimpleSetTest {
    SimpleSet<String> simpleSet = new SimpleSet<>();

    /**
     * setInit.
     */
    @Before
    public void setInit() {
        simpleSet.add("One");
        simpleSet.add("Two");
        simpleSet.add("Three");
        simpleSet.add("Four");

    }

    /**
     * whenTryToAddExistingElementThenGetTheSameSize.
     */
    @Test
    public void whenTryToAddExistingElementThenGetTheSameSize() {
        simpleSet.add("One");
        assertThat(simpleSet.size(), is(4));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<String> it = simpleSet.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("One"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Two"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Three"));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is("Four"));
        assertThat(it.hasNext(), is(false));
    }
}