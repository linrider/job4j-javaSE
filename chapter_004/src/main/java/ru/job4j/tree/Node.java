package ru.job4j.tree;

import java.util.*;
/**
 * Node class for task "1. Создать элементарную структуру дерева [#1711]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.09.18.
 */
public class Node<E extends Comparable<E>> {
    private final List<Node<E>> children = new ArrayList<>();
    private final E value;

    /**
     * Node constructor.
     * @param value - E.
     */
    public Node(final E value) {
        this.value = value;
    }

    /**
     * getChildren.
     * getter for children.
     * @return List<Node<E>>.
     */
    public List<Node<E>> getChildren() {
        return children;
    }

    /**
     * getValue.
     * getter for value of Node.
     * @return E.
     */
    public E getValue() {
        return value;
    }
    /**
     * add.
     * добавляет потомков.
     * @param child - Node<E>.
     */
    public void add(Node<E> child) {
        this.children.add(child);
    }

    /**
     * leaves.
     * возвращает список листьев.
     * @return List<Node<E>>.
     */
    public List<Node<E>> leaves() {
        return this.children;
    }

    /**
     * eqValue.
     * сравнивает узлы по значениям.
     * @param that - E.
     * @return boolean.
     */
    public boolean eqValue(E that) {
        return this.value.compareTo(that) == 0;


    }


}
