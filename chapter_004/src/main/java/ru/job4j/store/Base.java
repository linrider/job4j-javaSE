package ru.job4j.store;

/**
 * Base for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public abstract class Base {
    private final String id;

    /**
     * Constructor for Base abstract class.
     * @param id - String.
     */
    protected Base(final String id) {
        this.id = id;
    }

    /**
     * getId - getter.
     * @return - String.
     */
    public String getId() {
        return id;
    }
}