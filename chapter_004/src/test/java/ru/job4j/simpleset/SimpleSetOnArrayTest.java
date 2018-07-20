package ru.job4j.simpleset;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleSetOnArrayTest for task "1. Реализовать коллекцию Set на массиве [#996]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 19.07.18.
 */
public class SimpleSetOnArrayTest {
    SimpleSetOnArray<String> simpleSetOnArray = new SimpleSetOnArray<>();

    /**
     * setInit.
     */
    @Before
    public void setInit() {
        simpleSetOnArray.add("One");
        simpleSetOnArray.add("Two");
        simpleSetOnArray.add("Three");
        simpleSetOnArray.add("Four");

    }

    /**
     * whenTryToAddExistingElementThenGetTheSameSize.
     */
    @Test
    public void whenTryToAddExistingElementThenGetTheSameSize() {
        simpleSetOnArray.add("One");
        assertThat(simpleSetOnArray.size(), is(4));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<String> it = simpleSetOnArray.iterator();
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