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
    private LinkedContainer<Integer> linkedContainer = new LinkedContainer<>();

    /**
     * primaryListCreation.
     */
    @Before
    public void primaryListCreation() {
        linkedContainer.addToTail(1);
        linkedContainer.addToTail(2);
        linkedContainer.addToTail(3);
        linkedContainer.addToTail(4);
        linkedContainer.addToTail(5);
    }

    /**
     * whenGetTwoElementsForControlHowWasTheyAdded.
     */
    @Test
    public void whenGetTwoElementsForControlHowWasTheyAdded() {
        assertThat(linkedContainer.get(1), is(2));
        assertThat(linkedContainer.get(4), is(5));
    }

    @Test
    public void whenAddElementAddToHeadThenGetIt() {
        linkedContainer.addToHead(6);
        assertThat(linkedContainer.get(0), is(6));
    }

    /**
     * whenRemoveLastElementThemReturnNewLastElement.
     */
    @Test
    public void whenRemoveFirstElementThemReturnNewFirstElement() {
        assertThat(linkedContainer.removeFirst(), is(2));
    }

    /**
     * whenRemoveLastElementThemReturnNewLastElement.
     */
    @Test
    public void whenRemoveLastElementThemReturnNewLastElement() {
        assertThat(linkedContainer.removeLast(), is(4));
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
        linkedContainer.addToTail(6);
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