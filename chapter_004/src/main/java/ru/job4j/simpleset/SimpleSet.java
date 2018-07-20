package ru.job4j.simpleset;
/**
 * SimpleList for task "1. Реализовать коллекцию Set на массиве [#996]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 19.07.18.
 */
import java.util.Iterator;

import ru.job4j.simplelist.SimpleList;

public class SimpleSet<T> implements Iterable<T> {
    private SimpleList<T> set;

    /**
     * Constructor for SimpleSet.
     */
    public SimpleSet() {
        this.set = new SimpleList<>();
    }

    /**
     * size.
     * @return - int.
     */
    public int size() {
        return set.size();
    }


    /**
     * add.
     * @param value - T.
     */
    public void add(T value) {
        if (set.size() == 0) {
            this.set.add(value);
        } else {
            Iterator<T> it = set.iterator();
            boolean uniqueness = true;
            while (it.hasNext()) {
                if (value.hashCode() == it.next().hashCode()) {
                    uniqueness = false;
                    break;
                }
            }
            if (uniqueness) {
                this.set.add(value);
            }
        }
    }

    /**
     *
     * @return - Iterator<T>.
     */
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }

}
