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
    private Node<E> head;
    private Node<E> tail;

    /**
     * Constructor for LinkedContainer.
     */
    public LinkedContainer() {
        this.head = new Node<>(null, null, null);
        this.tail = new Node<>(null, head, null);
        this.head.next = tail;
    }


    /**
     * Node class for saving data.
     * @param <E>.
     */
    private class Node<E> {
        E value;
        Node<E> next;
        Node<E> prev;

        /**
         * Node<E> constructor.
         * @param current - E.
         * @param prev - Node<E>.
         * @param next - Node<E>.
         */
        Node(E current, Node<E> prev, Node<E> next) {
            this.value = current;
            this.prev = prev;
            this.next = next;
        }
    }

    /**
     * addToTail.
     * @param value - E.
     */
    public void addToTail(E value) {
        Node<E> newNode = tail;
        newNode.value = value;
        tail = new Node<>(null, newNode, null);
        newNode.next = tail;
        this.modCount++;
        this.size++;
    }

    /**
     * addToHead.
     * @param value - E.
     */
    public void addToHead(E value) {
        Node<E> newNode = head;
        newNode.value = value;
        head = new Node<>(null, null, newNode);
        newNode.prev = head;
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
            result = tail.prev;
            for (int i = size - 1; i > index; i--) {
                result = result.prev;
            }
        } else {
            result = this.head.next;
            for (int i = 0; i < index; i++) {
                result = result.next;
            }
        }
        return result.value;
    }

    /**
     * removeLast.
     * @return E.
     */
    public E removeLast() {
         if (this.size == 0) {
             throw new NoSuchElementException();
         }
         tail.prev = tail.prev.prev;
         this.size--;
         this.modCount++;
        return tail.prev.value;
    }

    /**
     * removeFirst.
     * @return E.
     */
    public E removeFirst() {
        if (this.size == 0) {
            throw new NoSuchElementException();
        }
        head.next = head.next.next;
        this.size--;
        this.modCount++;
        return head.next.value;
    }

    /**
     * Iterator.
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {

            private Node<E> current = head.next;
            private int modIndicator = modCount;

            /**
             * hasNext.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return current != tail;
            }

            /**
             * next.
             * @return E.
             */
            @Override
            public E next() {
                if (current == tail) {
                    throw new NoSuchElementException();
                }
                if (modCount != modIndicator) {
                    throw new ConcurrentModificationException();
                }
                Node<E> result = current;
                current = current.next;
                return result.value;
            }
        };
    }

}
