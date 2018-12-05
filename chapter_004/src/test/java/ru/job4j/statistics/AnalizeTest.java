package ru.job4j.statistics;
/**
 *  AnalizeTest for task "Статистика по коллекции. [#45889]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 25.11.18.
 */
import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;

public class AnalizeTest {
    private Analize analizer = new Analize();

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        analizer.add(new Analize.User("John Lennon", 1));
        analizer.add(new Analize.User("Paul McCartney", 2));
        analizer.add(new Analize.User("George Harrison", 3));
        analizer.add(new Analize.User("Ringo Starr", 4));
        analizer.add(new Analize.User("Peter Best", 5));
        analizer.backup();
    }

    /**
     * whenOneElementAddedThenAnswerResult.
     */
    @Test
    public void whenOneElementAddedThenAnswerResult() {
        analizer.add(new Analize.User("Eric Clapton", 6));
        assertThat(analizer.diff().added, is(1));
    }

    /**
     * whenOneElementDeletedThenAnswerResult.
     */
    @Test
    public void whenOneElementDeletedThenAnswerResult() {
        analizer.delete("Peter Best");
        assertThat(analizer.diff().deleted, is(1));
    }

    /**
     * whenOneElementChangedThenAnswerResult.
     */
    @Test
    public void whenOneElementChangedThenAnswerResult() {
        analizer.change("John Lennon", "Eric Clapton");
        assertThat(analizer.diff().changed, is(1));
    }

}