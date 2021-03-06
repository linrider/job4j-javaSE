package ru.job4j.simplestack;

import ru.job4j.simplelinkedlist.SimpleLinkedList;

/**
 * SimpleStack for task "5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack и Queue [#160]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 05.07.18.
 */
public class SimpleStack<T> {

    private SimpleLinkedList<T> simpleStack = new SimpleLinkedList<>();
    private int size = 0;

    /**
     * poll.
     * @return T.
     */
    public T poll() {
        T result = simpleStack.get(0);
        simpleStack.delete();
        this.size--;
        return result;
    }

    /**
     * push.
     * @param value - T.
     */
    public void push(T value) {
        simpleStack.add(value);
        this.size++;
    }

    /**
     * size getter.
     * @return int.
     */
    public int size() {
        return this.size;
    }
}