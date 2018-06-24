package ru.job4j.dynamicarray;

import java.util.Arrays;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
/**
 * DynamicArray for task "5.3.1. Создать динамический список на базе массива [#158]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 24.06.18.
 */
public class DynamicArray<E> implements Iterable<E> {

    private Object[] container;
    private int position;
    private int modCount = 0;

    /**
     * Constructor for DynamicArray without params.
     */
    public DynamicArray() {
        this.container = new Object[10];
        position = 0;
    }


    /**
     * DynamicArray.
     * @param size - int.
     */
    public DynamicArray(int size) {
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
        int size = 0;
        for (int i = 0; i < container.length; i++) {
            if (container[i] != null) {
                size++;
            } else {
                break;
            }
        }
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
                return container[index] != null && index < container.length;
            }

            /**
             * next.
             * @return E.
             */
            @Override
            public E next() {
                if (modCount != modIndicator) {
                    throw new ConcurrentModificationException();
                }
                return (E) container[index++];
            }
        };
    }
}
