package ru.job4j.statistics;
/**
 *  StoreTest for task "Статистика по коллекции. [#45889]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 25.11.18.
 */
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class StoreTest {
    private Store store = new Store();

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        store.add(new Store.User("John Lennon", 1));
        store.add(new Store.User("Paul McCartney", 2));
        store.add(new Store.User("George Harrison", 3));
        store.add(new Store.User("Ringo Starr", 4));
        store.add(new Store.User("Peter Best", 5));
        store.backup();
    }

    /**
     * whenOneElementAddedThenAnswerResult.
     */
    @Test
    public void whenOneElementAddedThenAnswerResult() {
        store.add(new Store.User("Eric Clapton", 6));
        assertThat(store.diff().getAdded(), is(1));
    }

    /**
     * whenOneElementDeletedThenAnswerResult.
     */
    @Test
    public void whenOneElementDeletedThenAnswerResult() {
        store.delete("Peter Best");
        assertThat(store.diff().getDeleted(), is(1));
    }

    /**
     * whenOneElementChangedThenAnswerResult.
     */
    @Test
    public void whenOneElementChangedThenAnswerResult() {
        store.change("John Lennon", "Eric Clapton");
        assertThat(store.diff().getChanged(), is(1));
    }

}