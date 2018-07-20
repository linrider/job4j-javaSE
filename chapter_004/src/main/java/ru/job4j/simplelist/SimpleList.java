package ru.job4j.simplelist;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * SimpleList for task "5.3.1. Создать динамический список на базе массива [#158]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 24.06.18.
 */
public class SimpleList<E> implements Iterable<E> {

    private Object[] container;
    private int position;
    private int modCount = 0;
    private int size = 0;

    /**
     * Constructor for SimpleList without params.
     */
    public SimpleList() {
        this.container = new Object[10];
        position = 0;
    }


    /**
     * SimpleList.
     * @param size - int.
     */
    public SimpleList(int size) {
        this.container = new Object[size];
        position = 0;
    }

    /**
     * add.
     * @param value - E.
     */
    public void add(E value) {
        if (position >= container.length) {
            Object[] temp = Arrays.copyOf(container, position * 2);
            container = Arrays.copyOf(temp, temp.length);
            modCount++;
        }
        this.container[position++] = value;
        modCount++;
        size++;
    }

    /**
     * get.
     * @param index - int.
     * @return E.
     */
    public E get(int index) {
        return (E) this.container[index];

    }

    /**
     * size (сделал по собственной инициативе для теста).
     * @return int.
     */
    public int size() {
        return size;
    }

    /**
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private int index = 0;
            private int modIndicator = modCount;
            /**
             * hasNext.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return index < size;
            }

            /**
             * next.
             * @return E.
             */
            @Override
            public E next() {
                if (size == 0) {
                    throw new NoSuchElementException();
                }
                if (modCount != modIndicator) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[index++];
            }
        };
    }
}
