package ru.job4j.tree;

import java.util.Optional;
/**
 * SimpleTree inteface for task "1. Создать элементарную структуру дерева [#1711]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.09.18.
 */
public interface SimpleTree<E extends Comparable<E>> extends Iterable<E> {
    /**
     * add.
     * Добавить элемент child в parent.
     * Parent может иметь список child.
     * @param parent - E.
     * @param child - E.
     * @return boolean.
     */
    boolean add(E parent, E child);

    /**
     * findBy.
     * @param value - E.
     * @return Node<E>.
     */
    Optional<Node<E>> findBy(E value);
}
