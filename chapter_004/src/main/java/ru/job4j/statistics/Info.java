package ru.job4j.statistics;
/**
 * Info class for task "Статистика по коллекции. [#45889]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 25.11.18.
 */
public class Info {
    private int added;
    private int changed;
    private int deleted;

    /**
     * Info constructor.
     * @param added - int.
     * @param changed - int.
     * @param deleted - int.
     */
    Info(int added, int changed, int deleted) {
        this.added = added;
        this.changed = changed;
        this.deleted = deleted;
    }

    /**
     * gatAdded.
     * @return int.
     */
    public int getAdded() {
        return added;
    }

    /**
     * getChanged.
     * @return int.
     */
    public int getChanged() {
        return changed;
    }

    /**
     * getDeleted.
     * @return int.
     */
    public int getDeleted() {
        return deleted;
    }
}
