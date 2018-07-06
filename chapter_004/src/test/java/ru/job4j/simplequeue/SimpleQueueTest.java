package ru.job4j.simplequeue;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

/**
 * SimpleQueueTest for task "5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack и Queue [#160]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 05.07.18.
 */
public class SimpleQueueTest {
    SimpleQueue<Integer> simpleQueue = new SimpleQueue<>();

    /**
     * queueCreation.
     */
    @Before
    public void queueCreation() {
        simpleQueue.push(1);
        simpleQueue.push(2);
        simpleQueue.push(3);
    }

    /**
     * whenPollElementsFromQueueThenItIsStayingEmpty.
     */
    @Test
    public void whenPollElementsFromQueueThenItIsStayingEmpty() {
        assertThat(simpleQueue.poll(), is(1));
        assertThat(simpleQueue.poll(), is(2));
        assertThat(simpleQueue.poll(), is(3));
        assertThat(simpleQueue.size(), is(0));

    }
}