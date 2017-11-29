package ru.job4j.start;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
/**
 * Tracker for task "2. Реализовать класс Tracker [#396]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 12.09.17
 */
public class Tracker {

    private List<Item> items = new ArrayList<>();
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
        this.items.add(item);
        return item;
    }

    /**
     * update.
     * @param item - Item.
     */
    protected void update(Item item) {
        String id = item.getId();
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i) != null && items.get(i).getId().equals(id)) {
                items.set(i, item);
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
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).getId().equals(id)) { items.remove(i); }
        }
    }

    /**
     * findAll.
     * @return list - Item[].
     */
    protected List<Item> findAll() {
        List<Item> list = new ArrayList<>();
        for (int i = 0; i < items.size(); i++) {
            list.add(items.get(i));
        }
        return list;
    }
    /**
     * findByName.
     * @param key - String.
     * @return list - Item[].
     */
    protected List<Item> findByName(String key) {
        List<Item> list = new ArrayList<>();
        for (Item item : items) {
            if (item != null && item.getName().equals(key)) {
                list.add(item);
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
