package ru.job4j.matrixiterator;

import org.junit.Before;
import org.junit.Test;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;

/**
 * MatrixIteratorTest (final).
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.03.18
 */
public class MatrixIteratorTest {

    private Iterator<Integer> it;

    /**
     * setUp.
     */
    @Before
    public void setUp(){
        it = new MatrixIterator(new int[][]{{1, 2, 3}, {4, 5, 6}});
    }

    /**
     * hasNextNextSequentialInvocation.
     */
    @Test
    public void hasNextNextSequentialInvocation () {
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
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(6));
        assertThat(it.hasNext(), is(false));
    }

    /**
     * testsThatNextMethodDoesntDependsOnPriorHasNextInvocation.
     */
    @Test
    public void testsThatNextMethodDoesntDependsOnPriorHasNextInvocation () {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }

    @Test(expected = NoSuchElementException.class)
    public void testForNoSuchElement() {
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
        it.next();
    }

    /**
     * sequentialHasNextInvocationDoesntAffectRetrievalOrder.
     */
    @Test
    public void sequentialHasNextInvocationDoesntAffectRetrievalOrder () {
        assertThat(it.hasNext(), is(true));
        assertThat(it.hasNext(), is(true));
        assertThat(it.next(), is(1));
        assertThat(it.next(), is(2));
        assertThat(it.next(), is(3));
        assertThat(it.next(), is(4));
        assertThat(it.next(), is(5));
        assertThat(it.next(), is(6));
    }


    /**
     * shouldThrowNoSuchElementException.
     */
    @Test(expected = NoSuchElementException.class)
    public void shouldThrowNoSuchElementException () {
        it = new MatrixIterator(new int[][]{});
        it.next();
    }
}