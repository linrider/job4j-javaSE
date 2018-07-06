package ru.job4j.simplearraylist;

import java.util.NoSuchElementException;

/**
 * SimpleArrayList for task "5.3.0 Создать метод delete для односвязного списка [#51424]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 23.06.18.
 */
public class SimpleArrayList<E> {
    private int size;
    private Node<E> first;

    /**
     * Класс предназначен для хранения данных.
     */
    private static class Node<E> {
        E date;
        Node<E> next;

        Node(E date) {
            this.date = date;
        }
    }
    /**
    * Метод вставляет в начало списка данные.
    */
    public void add(E date) {
        Node<E> newLink = new Node<>(date);
        newLink.next = this.first;
        this.first = newLink;
        this.size++;
    }

    /**
    * Реализовать метод удаления первого элемента в списке.
    */
    public E delete() {
        if (size == 0) {
            throw new NoSuchElementException();
        }
        E result = null;
        if (size != 1) {
            this.first = this.first.next;
            this.size--;
            result = this.first.date;
        } else  {
            size--;
            this.first = null;
        }
        return result;
    }

    /**
    * Метод получения элемента по индексу.
    */
    public E get(int index) {
        Node<E> result = this.first;
        for (int i = 0; i < index; i++) {
            result = result.next;
        }
        return result.date;
    }

    /**
    * Метод получения размера коллекции.
    */
    public int getSize() {
        return this.size;
    }


}
