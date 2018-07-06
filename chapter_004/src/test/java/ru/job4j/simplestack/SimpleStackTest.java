package ru.job4j.simplestack;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;
/**
 * SimpleStackTest for task "5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack и Queue [#160]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 05.07.18.
 */
public class SimpleStackTest {
    SimpleStack<Integer> simpleStack = new SimpleStack<>();

    /**
     * stackCreation.
     */
    @Before
    public void stackCreation() {
        simpleStack.push(1);
        simpleStack.push(2);
        simpleStack.push(3);
    }

    /**
     * whenPollElementsAndStackIsStayingEmpty.
     */
    @Test
    public void whenPollElementsAndStackIsStayingEmpty() {
        assertThat(simpleStack.poll(), is(3));
        assertThat(simpleStack.poll(), is(2));
        assertThat(simpleStack.poll(), is(1));
        assertThat(simpleStack.size(), is(0));
    }
}