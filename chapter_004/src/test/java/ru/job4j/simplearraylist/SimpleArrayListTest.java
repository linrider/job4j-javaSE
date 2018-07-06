package ru.job4j.simplearraylist;

import org.junit.Test;
import org.junit.Before;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

/**
 * SimpleArrayTest for task "5.3.0 Создать метод delete для односвязного списка [#51424]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 23.06.18.
 */
public class SimpleArrayListTest {
    private SimpleArrayList<Integer> list;

    /**
     * beforeTest.
     */
    @Before
    public void beforeTest() {
        list = new SimpleArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
    }

    /**
     * whenDeleteFirstElementAndReturnNewFirsElement.
     */
    @Test
    public void whenDeleteFirstElementAndReturnNewFirsElement() {
        assertThat(list.delete(), is(2));
        assertThat(list.delete(), is(1));
        assertThat(list.delete(), is(nullValue()));


    }

    /**
     * whenAddThreeElementsThenUseGetOneResultTwo.
     */
    @Test
    public void whenAddThreeElementsThenUseGetOneResultTwo() {
        assertThat(list.get(1), is(2));
    }

    /**
     * whenAddThreeElementsThenUseGetSizeResultThree.
     */
    @Test
    public void whenAddThreeElementsThenUseGetSizeResultThree() {
        assertThat(list.getSize(), is(3));
    }


}