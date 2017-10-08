package ru.job4j.start;

/**
 * StartUI.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 19.09.17
 */
public class StartUI {
    private Input input;
    private Tracker tracker;

    public StartUI() {

    }

    /**
     * StartUI constructor.
     * @param input
     * @param tracker
     */
    public StartUI(Input input, Tracker tracker) {
        this.input = input;
        this.tracker = tracker;

    }

    /**
     * init.
     */
    public void init() {
       MenuTracker menu = new MenuTracker(this.input, this.tracker);
       while (true) {
           menu.showMenu();
       }
        }

    /**
     * Main.
     * @param args - String[].
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ConsoleInput();
        new StartUI(input, tracker).init();
    }
}
