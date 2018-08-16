package ru.job4j.map;

import java.util.Iterator;

public class SimpleMap<K, V> implements Iterable {
    private Entry<K, V> table[];
    private int size;

    public SimpleMap() {
        this.table = new Entry[16];
    }

    public SimpleMap(int capacity) {
        this.table = new Entry[capacity];
    }


    public class Entry<K, V> {
        K key;
        V value;
        int hash;

        public Entry(K key, V value) {
            this.key = key;
            this.value = value;
        }
    }

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
        }
        return result;
    }

    public V get(K key) {
        int pos = key.hashCode() & (table.length - 1);
        return table[pos].value;
    }

    public boolean delete(K key) {
        boolean result = false;
        int pos = key.hashCode() & (table.length - 1);
        if (table[pos].key.equals(key)) {
            table[pos] = null;
            result = true;
            size++;
        }
        return result;
    }

    private void resize(int newCapacity) {
        Entry[] newTable = new Entry[newCapacity];
        table = transfer(newTable);

    }

    private Entry[] transfer(Entry[] newTable) {
        for (Entry<K, V> entry : table ) {
            newTable[entry.key.hashCode() & (newTable.length - 1)] = entry;
        }
        return newTable;
    }


    @Override
    public Iterator iterator() {
        return new Iterator<Entry<K, V>>() {
            int position = 0;
            @Override
            public boolean hasNext() {
                return position < table.length;
            }

            @Override
            public Entry<K, V> next() {
                while (table[position] == null) {
                    position++;
                }
                return table[position++];
            }
        };
    }
}
