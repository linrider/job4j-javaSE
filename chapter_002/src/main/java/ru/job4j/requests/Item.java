package ru.job4j.requests;
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
    private String comments;
    private long create;

//    public Item(int count) {
//
//    }
    public Item(String name, String description, long create) {
        this.name = name;
        this.description = description;
        this.create = create;
        this.comments = comments;
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
}
