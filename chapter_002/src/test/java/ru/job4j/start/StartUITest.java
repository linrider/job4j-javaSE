package ru.job4j.start;

import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.function.Consumer;

import static org.hamcrest.core.Is.is;
import static org.hamcrest.core.IsNull.nullValue;
import static org.junit.Assert.assertThat;

/**
 * StartUITest (test for StartUI).
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$2.
 * @since 12.09.17
 */
public class StartUITest {

    private final ByteArrayOutputStream out = new ByteArrayOutputStream();
    private final Consumer<String> output = new Consumer<String>() {
        private final PrintStream stdout = new PrintStream(out);

        @Override
        public void accept(String s) {
            stdout.println(s);
        }
    };
    /**
     * Test for "Add new Item".
     */
    @Test
    public void whenUserAddItemThenTrackerHasNewItemWithSameName() {
        Tracker tracker = new Tracker();     // создаём Tracker
        Input input = new StubInput(new String[]{"0", "test name", "desc", "123", "6", "y"});   //создаём StubInput с последовательностью действий
        new StartUI(input, tracker, output).init();     //   создаём StartUI и вызываем метод init()
        assertThat(tracker.findAll().get(0).getName(), is("test name")); // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
    }

    /**
     * Test for "Show all items".
     */
    @Test
    public void whenTrackerReturnsAllItems() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем 3 заявки
        tracker.add(new Item("John Silver", "engage in the service", "1742"));
        tracker.add(new Item("Jim Hockins", "find treasures", "1742"));
        tracker.add(new Item("Doctor Livsey", "find treasures", "1742"));

        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"1", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findAll().get(0).getName(), is("John Silver"));
        assertThat(tracker.findAll().get(1).getName(), is("Jim Hockins"));
        assertThat(tracker.findAll().get(2).getName(), is("Doctor Livsey"));
    }

    /**
     * Test for "Edit item".
     */
    @Test
    public void whenUpdateThenTrackerHasUpdatedValue() {
        // создаём Tracker
        Tracker tracker = new Tracker();
        //Напрямую добавляем заявку
        Item item = tracker.add(new Item("John Silver", "engage in the service", "1742"));
        //создаём StubInput с последовательностью действий
        Input input = new StubInput(new String[]{"2", item.getId(), "test name", "desc", "1742", "6", "y"});
        // создаём StartUI и вызываем метод init()
        new StartUI(input, tracker, output).init();
        // проверяем, что нулевой элемент массива в трекере содержит имя, введённое при эмуляции.
        assertThat(tracker.findById(item.getId()).getName(), is("test name"));
    }

    /**
     * Test for "Delete item".
     */
    @Test
    public void whenDeleteThenTrackerHasNotDeletedValue() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("John Silver", "engage in the service", "1742"));
        Input input = new StubInput(new String[]{"3", item.getId(), "6", "y"});
        new StartUI(input, tracker, output).init();
        tracker.delete(item);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    /**
     * Test for "Find item by Id".
     */
    @Test
    public void whenFindNameByIdThenTrackerHasFoundValues() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("John Silver", "engage in the service", "1742"));
        Input input = new StubInput(new String[]{"4", item.getId(), "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findById(item.getId()).getName(), is("John Silver"));
    }

    /**
     * Test for "Find items by name".
     */
    @Test
    public void whenFindByNameThenTrackerHasFoundValues() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("John Silver", "engage in the service", "1742"));
        Input input = new StubInput(new String[]{"5", item.getName(), "6", "y"});
        new StartUI(input, tracker, output).init();
        assertThat(tracker.findByName(item.getName()).get(0).getName(), is("John Silver"));
    }

}
