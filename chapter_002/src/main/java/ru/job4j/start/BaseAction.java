package ru.job4j.start;

import javax.swing.*;
/**
 * BaseAction abstract class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 14.10.17
 */
public abstract class BaseAction implements UserAction {
    private int key;
    private String name;

    /**
     * BaseAction constructor.
     * @param key - int.
     * @param name - Sring.
     */
    BaseAction(int key, String name) {
        this.key = key;
        this.name = name;
    }

    /**
     * key.
     * @return - int.
     */
    public int key() {
        return this.key;
    }

    /**
     * execute.
     * @param input   - Input.
     * @param tracker - Tracker.
     */
    public abstract void execute(Input input, Tracker tracker);

    /**
     * execute.
     * @return - String.
     */
    public String info() {
        return String.format("%s. %s", this.key, this.name);
    }
}
