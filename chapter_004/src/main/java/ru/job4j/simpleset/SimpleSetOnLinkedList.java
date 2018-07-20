package ru.job4j.simpleset;

import ru.job4j.linkedContainer.LinkedContainer;

import java.util.Iterator;
/**
 * SimpleSetOnLinkedList for task "2. Set реализованный на связном списке. [#997]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 20.07.18.
 */
public class SimpleSetOnLinkedList<T> implements Iterable<T> {
    LinkedContainer<T> set;

    /**
     * Constructor for SimpleSetOnLinkedList.
     */
    public SimpleSetOnLinkedList() {
        this.set = new LinkedContainer<>();
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
            this.set.addToTail(value);
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
                this.set.addToTail(value);
            }
        }
    }

    /**
     * iterator.
     * @return - Iterator<T>.
     */
    @Override
    public Iterator<T> iterator() {
        return set.iterator();
    }
}
