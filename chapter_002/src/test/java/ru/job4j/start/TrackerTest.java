package ru.job4j.start;

import org.junit.Test;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

/**
 * Test for Tracker "2. Реализовать класс Tracker [#396]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$2. Реализовать класс Tracker [#396]
 * @since 12.09.17
 */
public class TrackerTest {
    /**
     * test for findByName method.
     */
    @Test
    public void  whenAddNameThenReturnName() {
        Tracker tracker = new Tracker();
        Item itemTest = new Item("test", "testDescription", "123");
        tracker.add(itemTest);
        Item[] itemsTest = tracker.findByName(itemTest.getName());
        assertThat(itemsTest[0].getName(), is("test"));
    }
    /**
     * test for update method.
     */
    @Test
    public void whenUpdateNameThenReturnNewName() {
        Tracker tracker = new Tracker();
        Item previous = new Item("test1", "testDescription", "123");
        tracker.add(previous);
        Item next = new Item("test2", "testDescription2", "1234");
        next.setId(previous.getId());
        tracker.update(next);
        assertThat(tracker.findById(previous.getId()).getName(), is("test2"));
    }
    /**
     * test for delete method.
     */
    @Test
    public void whenDeleteItemThenReturnZeroLengthArray() {
        Tracker tracker = new Tracker();
        Item itemTest = new Item("test", "testDescription", "123");
        tracker.add(itemTest);
        tracker.delete(itemTest);
        assertThat(tracker.findByName(itemTest.getName()).length, is(0));

    }
    /**
    * test for findAll method.
     */
    @Test
    public void whenFindNotEmtyItemsThenReturnArrayOfItems() {
        Tracker tracker = new Tracker();
        Item itemTest = new Item("test", "testDescription", "123");
        tracker.add(itemTest);
        assertThat(tracker.findAll().length, is(1));
    }
    /**
    * test for findById method.
     */
    @Test
    public void whenFindByIdThenReturnName() {
        Tracker tracker = new Tracker();
        Item itemTest = new Item("test", "testDescription", "123");
        tracker.add(itemTest);
        assertThat(tracker.findById(itemTest.getId()).getName(), is("test"));
    }


}
