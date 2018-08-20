package ru.job4j.map;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * SimpleMap for task "8. Реализовать собственную структуру данных - HashMap [#1008]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 15.08.18.
 */
public class SimpleMap<K, V> implements Iterable {
    private Entry<K, V> table[];
    private int size;
    private int modCount = 0;

    /**
     * SimpleMap constructor.
     */
    public SimpleMap() {
        this.table = new Entry[16];
    }

    /**
     * SimpleMap constructor.
     * @param capacity - int.
     */
    public SimpleMap(int capacity) {
        this.table = new Entry[capacity];
    }


    /**
     * Entry.
     * @param <K>.
     * @param <V>.
     */
    public class Entry<K, V> {
        K key;
        V value;
        int hash;

        /**
         * Entry constructor.
         * @param key - K.
         * @param value - V.
         */
        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }

        /**
         * getValue.
         * @return V.
         */
        public V getValue() {
            return this.value;
        }
    }

    /**
     * insert.
     * @param key - K.
     * @param value - V.
     * @return boolean.
     */
    public boolean insert(K key, V value) {
        if (this.size == table.length) {
            resize(table.length * 2);
        }
        boolean result = false;
        Entry<K, V> entry = new Entry<>(key, value);
        entry.hash = key.hashCode();
        int pos = entry.hash & (table.length - 1);
        if (table[pos] == null) {
            table[pos] = entry;
            result = true;
            size++;
            modCount++;
        }
        return result;
    }

    /**
     * getTableSize.
     * @return int.
     */
    public int getTableSize() {
        return this.table.length;
    }

    /**
     * get.
     * @param key - K.
     * @return V.
     */
    public V get(K key) {
        return table[key.hashCode() & (table.length - 1)].value;
    }

    /**
     * delete.
     * @param key - K.
     * @return boolean.
     */
    public boolean delete(K key) {
        boolean result = false;
        int pos = key.hashCode() & (table.length - 1);
        if (table[pos].key.equals(key)) {
            table[pos] = null;
            result = true;
            size--;
            modCount++;
        }
        return result;
    }

    /**
     * size.
     * @return int.
     */
    public int size() {
        return this.size;
    }

    /**
     * resize.
     * @param newCapacity - int.
     */
    private void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        table = transfer(newTable);

    }

    /**
     * transfer.
     * @param newTable - Entry[].
     * @return Entry[].
     */
    private Entry[] transfer(Entry[] newTable) {
        for (Entry<K, V> entry : table ) {
            newTable[entry.key.hashCode() & (newTable.length - 1)] = entry;
        }
        return newTable;
    }

    /**
     * Iterator.
     * @return Iterator<Entry<K, V>>.
     */
    @Override
    public Iterator<Entry<K, V>> iterator() {
        return new Iterator<Entry<K, V>>() {
            int position = 0;
            int modIndicator = modCount;
            int reminder = size;

            /**
             * hasNext.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return reminder > 0;
            }

            /**
             * next.
             * @return Entry<K, V>.
             */
            @Override
            public Entry<K, V> next() {
                if (size == 0) {
                    throw new NoSuchElementException();
                }
                if (modCount != modIndicator) {
                    throw new ConcurrentModificationException();
                }

                while (table[position] == null) {
                    position++;
                }
                reminder--;
                return table[position++];
            }
        };
    }
}
