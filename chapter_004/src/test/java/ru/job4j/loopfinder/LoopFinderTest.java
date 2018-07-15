package ru.job4j.loopfinder;

import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * LoopFinderTest for task "5.3.4. Задан связанный список. Определить цикличность. [#161]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 14.07.18.
 */
public class LoopFinderTest {
    LoopFinder loopFinder = new LoopFinder();

    /**
     * whenListLockedFromTailToHeadThenReturnTrue.
     */
    @Test
    public void whenListLockedFromTailToHeadThenReturnTrue() {
        assertThat(loopFinder.hasCycle(loopFinder.first), is(true));
    }

    /**
     * whenListIsUnlockedThenReturnFalse.
     */
    @Test
    public void whenListIsUnlockedThenReturnFalse() {
        loopFinder.four.next = null;
        assertThat(loopFinder.hasCycle(loopFinder.first), is(false));
    }

    /**
     * wheenListIsLockedToSecondElementvThenReturnTrue.
     */
    @Test
    public void wheenListIsLockedToSecondElementvThenReturnTrue() {
        loopFinder.four.next = loopFinder.two;
        assertThat(loopFinder.hasCycle(loopFinder.first), is(true));
    }

}