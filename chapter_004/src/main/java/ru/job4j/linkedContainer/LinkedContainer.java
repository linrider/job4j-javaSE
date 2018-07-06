package ru.job4j.linkedContainer;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * LinkedContainer for task "5.3.2. Создать контейнер на базе связанного списка  [#159]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 28.06.18.
 */
public class LinkedContainer<E> implements Iterable<E> {
    private int size = 0;
    private int modCount = 0;
    private Node<E> firstNode;
    private Node<E> lastNode;


    /**
     * Node class for saving data.
     * @param <E>.
     */
    private class Node<E> {
        E date;
        Node<E> next;
        Node<E> prev;

        /**
         * Node<E> constructor.
         * @param current - E.
         * @param prev - Node<E>.
         * @param next - Node<E>.
         */
        Node(E current, Node<E> prev, Node<E> next) {
            this.date = current;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * add.
     * @param value - E.
     */
    public void add(E value) {
        if (size == 0) {
            this.firstNode = new Node<>(value, null, null);
        } else if (size == 1) {
            this.lastNode = new Node<>(value, firstNode, null);
            firstNode.next = lastNode;
        } else {
            Node<E> newNode = new Node<>(value,lastNode, null );
            Node<E> node = lastNode;
            lastNode = newNode;
            node.next = lastNode;
        }
        this.modCount++;
        this.size++;
    }

    /**
     * get.
     * @param index - int.
     * @return E.
     */
    public E get(int index) {
        Node<E> result;
        if (index > (size / 2)) {
            result = lastNode;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        } else {
            result = firstNode;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        }
        return result.date;
    }

    /**
     * getLast.
     * @return E.
     */
    public E getLast() {
        return this.lastNode.date;
    }

    /**
     * removeLast.
     * @return E.
     */
    public E removeLast() {
        E result = null;
        if (this.size == 1) {
            firstNode = null;
        } else if (this.size == 2) {
            firstNode.next = null;
            result = firstNode.date;
        } else {
            Node<E> current = lastNode.prev;
            current.next = null;
            lastNode = current;
            result = lastNode.date;
        }
        this.size--;
        return result;
    }

    /**
     * removeFirst.
     * @return E.
     */
    public E removeFirst() {
        E result = null;
        if (this.size == 1) {
            firstNode = null;
        } else if (this.size == 2) {
            lastNode.prev = null;
            firstNode = lastNode;
            result = firstNode.date;
        } else {
            Node<E> current = firstNode.next;
            current.prev = null;
            firstNode = current;
            result = firstNode.date;
        }
        this.size--;
        return result;
    }

    /**
     * Iterator.
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = firstNode;
            private int modIndicator = modCount;

            /**
             * hasNext.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return current != null;
            }

            /**
             * next.
             * @return E.
             */
            @Override
            public E next() {
                if (current == null) {
                    throw new NoSuchElementException();
                }
                if (modCount != modIndicator) {
                    throw new ConcurrentModificationException();
                }
                Node<E> result = current;
                current = current.next;
                return result.date;
            }
        };
    }

}
