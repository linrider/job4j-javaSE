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

    protected Item add(Item item) {
        item.setId(this.generateId());
        this.items[position++] = item;
        return item;
    }

    /**
     * update.
     * @param item - Item.
     */
    protected void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.length; i++) {
            if (items[i] != null && items[i].getId().equals(id)) {
                items[i] = item;
                break;
            }
        }
    }

    /**
     * delete.
     * @param item - Item.
     */
    protected void delete(Item item) {
        String id = item.getId();
        for (int i = 0; i < position; i++) {
            if (items[i].getId().equals(id)) {
                for (int j = i; j < items.length - 1; j++) {
                    items[j] = items[j + 1];
                }
                if (items[items.length - 1] != null) { items[items.length - 1] = null; }
                break;
            }
        }
        position--;
    }
    /**
     * findAll.
     * @return list - Item[].
     */
    protected Item[] findAll() {
        Item[] list = new Item[position];
        for (int i = 0; i < position; i++) {
            list[i] = items[i];
        }
        return list;
    }
    /**
     * findByName.
     * @param key - String.
     * @return list - Item[].
     */
    protected Item[] findByName(String key) {
        int count = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) count++;
        }

        Item[] list = new Item[count];
        int i = 0;
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                list[i++] = item;
            }
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
