package ru.job4j.statistics;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Analize class for task "Статистика по коллекции. [#45889]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 25.11.18.
 */
public class Analize {
    private List<User> previous = new ArrayList<>();
    private List<User> current = new ArrayList<>();


    /**
     * User internal class.
     */
    public static class User {
        int id;
        String name;

        /**
         * User constructor.
         * @param name - String.
         * @param id - int.
         */
        public User(String name, int id) {
            this.name = name;
            this.id = id;
        }
    }

    /**
     * Info internal class.
     */
    public static class Info {
        int added = 0;
        int changed = 0;
        int deleted = 0;

        /**
         * Info constructor.
         * @param added - int.
         * @param deleted - int.
         * @param changed - int.
         */
        public Info(int added, int deleted, int changed) {
            this.added = added;
            this.changed = changed;
            this.deleted = deleted;
        }
    }

    /**
     * diff.
     * @return Info.
     */
    public Info diff() {
        int added = 0;
        int deleted =0;
        int changed =0;
        int diff = current.size() - previous.size();
        if (diff > 0) {
            added = diff;
        } else if (diff < 0){
            deleted = Math.abs(diff);
        }
        HashMap<Integer, String> previousMap = new HashMap<>();
        for (User shuttle : previous) {
            previousMap.put(shuttle.id, shuttle.name);
        }
        HashMap<Integer, String> currentMap = new HashMap<>();
        for (User shuttle : current) {
            currentMap.put(shuttle.id, shuttle.name);
        }
        for (Map.Entry<Integer, String> pair : previousMap.entrySet()) {
            if (currentMap.containsKey(pair.getKey())) {
                if (!currentMap.get(pair.getKey()).equals(pair.getValue())) {
                changed++;
                }
            }
        }
        return new Info(added, deleted, changed);
    }

    /**
     * backup.
     */
    public void backup() {
        previous.clear();
        for (User shuttle : current) {
            previous.add(new User(shuttle.name, shuttle.id));
        }
    }

    /**
     * findIndexByName.
     * @param userName - String.
     * @return int.
     */
    private int findIndexByName(String userName) {
        int result = -1;
        for (User shuttle : current) {
            result = shuttle.name.equals(userName) ? current.indexOf(shuttle) : -1;
            if (result >= 0) {
                break;
            }
        }
        return result;
    }

    /**
     * add.
     * @param user - User.
     * @return boolean.
     */
    public boolean add(User user) {
        boolean result = false;
        if (this.current.size() != 0) {
            for (User shuttle : current) {
                if (shuttle.id == user.id) {
                    break;
                } else {
                    result = true;
                }
            }
        } else {
            result = true;
        }
        if (result) {
            this.current.add(user);
        }
        return result;
    }

    /**
     * delete.
     * @param userName - String.
     * @return boolean.
     */
    public boolean delete(String userName) {
        boolean result = false;
        int index = this.findIndexByName(userName);
        if (index >= 0) {
            this.current.remove(index);
            result = true;
        }
        return result;
    }

    /**
     * change.
     * @param oldName - String.
     * @param newName - String.
     * @return boolean.
     */
    public boolean change(String oldName, String newName) {
        boolean result = false;
        int index = this.findIndexByName(oldName);
        if (index >= 0) {
            User modUser = this.current.get(index);
            modUser.name = newName;
            this.current.set(index, modUser);
            result = true;
        }
        return result;
    }
}


