package ru.job4j.start;
/**
 * Item for task "2. Реализовать класс Tracker [#396]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 07.09.17
 */

public class Item {
    private String id;
    private String name;
    private String description;
    private long create;

    /**
     * Item constructor.
     * @param name - String.
     * @param description - String.
     * @param create - long.
     */

    Item(String name, String description, String create) {
        this.name = name;
        this.description = description;
        this.create = Long.parseLong(create);
    }
    /**
     * Item constructor.
     * @param id - String.
     * @param name - String.
     * @param description - String.
     * @param create - long.
     */
    Item(String id, String name, String description, String create) {
        this.name = name;
        this.description = description;
        this.create = Long.parseLong(create);
        this.id = id;
    }

    /**
     * getId.
     * @return id - String.
     */
    public String getId() {
        return this.id;
    }

    /**
     * setId.
     * @param id - String.
     */
    public void setId(String id) {
        this.id = id;
    }

    /**
     * getName.
     * @return name - String.
     */
    public String getName() {
        return this.name;
    }

    /**
     * getId.
     * @return id - String.
     */
    public String getDescription() {
        return this.description;
    }

    /**
     * getId.
     * @return create - long.
     */
    public long getCreate() {
        return this.create;
    }

    @Override
    public String toString() {
        return this.name + " " + this.description + " " + this.create + " " + this.id;
    }
}

