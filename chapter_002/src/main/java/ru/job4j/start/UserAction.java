package ru.job4j.start;

/**
 * UserAction interface.
 */
public interface UserAction {

    /**
     * key.
     * @return int.
     */
    int key();

    /**
     * execute.
     * @param input - Input.
     * @param tracker - Tracker.
     */
    void execute(Input input, Tracker tracker);

    /**
     * info.
     * @return String.
     */
    String info();
}
