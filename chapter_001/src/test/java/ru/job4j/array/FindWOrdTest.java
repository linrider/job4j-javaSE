package ru.job4j.array;
/**
 * Test for FindWord.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */
import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class FindWOrdTest {
    @Test
    public void whenFooundSubWordInOriginWordThenGetTrue() {
        FindWord findWord = new FindWord();
        String origin = "Привет";
        String sub = "иве";
        Boolean result = findWord.contains(origin, sub);
        assertThat(result, is(true));

    }
    @Test
    public void whenNotFooundSubWordInOriginWordThenGetFalse() {
        FindWord findWord = new FindWord();
        String origin = "Трансплантация";
        String sub = "ква";
        Boolean result = findWord.contains(origin, sub);
        assertThat(result, is(false));

    }
}
