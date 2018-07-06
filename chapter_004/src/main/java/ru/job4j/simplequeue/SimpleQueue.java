package ru.job4j.simplequeue;

import ru.job4j.linkedContainer.LinkedContainer;

/**
 * SimpleQueue for task "5.3.3. Используя контейнер на базе связанного списка создать контейнер Stack и Queue [#160]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 05.07.18.
 */
public class SimpleQueue<T> {
    private LinkedContainer<T> simpleQueue = new LinkedContainer<>();
    private int size = 0;

    /**
     * poll.
     * @return T.
     */
    public T poll() {
        T result = simpleQueue.get(0);
        simpleQueue.removeFirst();
        this.size--;
        return result;
    }


    /**
     * push.
     * @param value - T.
     */
    public void push(T value){
        simpleQueue.add(value);
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
