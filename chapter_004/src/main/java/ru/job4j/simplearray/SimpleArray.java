package ru.job4j.simplearray;

import java.util.Iterator;
/**
 * SimpleArray for task "5.2.1. Реализовать SimpleArray<T>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 21.05.18.
 */
public class SimpleArray<T> implements Iterable<T> {

    private Object[] objects;
    private int index = 0;

    /**
     * @param size - int.
     */
    public SimpleArray(int size) {
        this.objects = new Object[size];
    }

    /**
     * @param value - T.
     */
    public  void add(T value) {
        if (index < objects.length) {
            this.objects[index++] = value;
        } else {
            throw new ArrayIndexOutOfBoundsException();
        }
    }

    /**
     * @param position - int.
     * @return T.
     */
    public T get(int position) {
        return (T) this.objects[position];
    }

    /**
     * @param index - int.
     * @param model -T.
     */
    public void set(int index, T model) {
        this.objects[index] = model;
    }

    /**
     * @param index - int.
     */
    public void delete(int index) {
        this.objects[index] = null;
    }

    /**
     * @return Iterator.
     */
    @Override
    public Iterator iterator() {
        return new Iterator() {

            private int index = 0;

            /**
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return index < objects.length;
            }

            /**
             * @return T.
             */
            @Override
            public T next() {
                return (T) objects[index++];
            }
        };
    }
}
