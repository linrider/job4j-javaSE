package ru.job4j.start;

import java.util.function.Consumer;

/**
 * StartUI.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 19.09.17
 */
public class StartUI {
    private Input input;
    private Tracker tracker;
    private boolean working = true;
    private final Consumer<String> output;

    /**
     * StartUI constructor.
     * @param input - Input.
     * @param tracker - Tracker.
     * @param output
     */
    public StartUI(Input input, Tracker tracker, Consumer<String> output) {
        this.input = input;
        this.tracker = tracker;
        this.output = output;
    }

    /**
     * init.
     */
    public void init() {
       MenuTracker menu = new MenuTracker(this.input, this.tracker, this.output);
       menu.fillActions(this);
       while (this.working) {
           menu.showMenu();
       }
        }
    /**
     * stop.
     */
    public void stop() {
        this.working = false;
    }
    /**
     * Main.
     * @param args - String[].
     */
    public static void main(String[] args) {
        Tracker tracker = new Tracker();
        Input input = new ValidateInput();
        new StartUI(input, tracker, output).init();
    }
}
