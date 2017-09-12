package ru.job4j.requests;
/**
 * Tracker for task "2. Реализовать класс Tracker [#396]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 12.09.17
 */

import java.util.Random;

public class Tracker {
    private Item[] items = new Item[100];
    private int position = 0;
    private static final Random RN = new Random();

    /**
     * generateId.
     * @return  id - String.
     */
    String generateId() {
        return String.valueOf(System.currentTimeMillis() + RN.nextLong());
    }

    public Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * update.
     * @param item - Item.
     */
    public void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
            }
        }
    }

    /**
     * delete.
     * @param item - Item.
     */
    public void delete(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) items[i] = null;
        }
    }
    /**
     * findAll.
     * @return list - Item[].
     */
    public Item[] findAll() {
        int count = 0;
        for (Item x : items) {
            if (x != null) count++;
        }

        Item[] list = new Item[count];
        int i = 0;
        for (Item item : items) {
            if (item != null) {
                list[i] = item;
                i++;
            }
        }
        return list;
    }
    /**
     * findByName.
     * @param key - String.
     * @return list - Item[].
     */
    public Item[] findByName(String key) {
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) count++;
        }

        Item[] list = new Item[count];
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) list[i] = item;
            i++;
        }
        return list;
    }

    /**
     * findById.
     * @param id - String.
     * @return result - Item.
     */
    protected Item findById(String id) {
        Item result = null;
        for (Item item : items) {
            if (item != null && item.getId().equals(id)) {
                result = item;
                break;
            }
        }
        return result;
    }

}
