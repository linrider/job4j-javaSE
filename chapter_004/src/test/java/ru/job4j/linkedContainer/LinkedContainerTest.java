package ru.job4j.linkedContainer;

import org.junit.Before;
import org.junit.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * LinkedContainerTest for task "5.3.2. Создать контейнер на базе связанного списка  [#159]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 28.06.18.
 */
public class LinkedContainerTest {
    LinkedContainer<Integer> linkedContainer = new LinkedContainer<>();

    /**
     * primaryListCreation.
     */
    @Before
    public void primaryListCreation() {
        linkedContainer.add(1);
        linkedContainer.add(2);
        linkedContainer.add(3);
        linkedContainer.add(4);
        linkedContainer.add(5);
    }

    /**
     * whenGetTwoElementsForControlHowWasTheyAdded.
     */
    @Test
    public void whenGetTwoElementsForControlHowWasTheyAdded() {
        assertThat(linkedContainer.get(1), is(2));
        assertThat(linkedContainer.get(4), is(5));
    }

    /**
     * whenCreateIteratorThenReturnHasNextResultsAndValues.
     */
    @Test
    public void whenCreateIteratorThenReturnHasNextResultsAndValues() {
        Iterator<Integer> it = linkedContainer.iterator();
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(2));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(3));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(4));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(5));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * whenTryConcurrentModifyThenReturnException.
     */
    @Test (expected = ConcurrentModificationException.class)
    public void whenTryConcurrentModifyThenReturnException() {
        Iterator<Integer> it = linkedContainer.iterator();
        it.next();
        linkedContainer.add(6);
        it.next();
    }

    /**
     * whenTryToUseIteratorWithEmptyListThenGetNoSuchElementException.
     */
    @Test (expected = NoSuchElementException.class)
    public void whenTryToUseIteratorWithEmptyListThenGetNoSuchElementException() {
        LinkedContainer<Integer> emptyList = new LinkedContainer<>();
        Iterator<Integer> it = emptyList.iterator();
        it.next();
    }
}