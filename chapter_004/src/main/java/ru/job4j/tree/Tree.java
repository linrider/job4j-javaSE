package ru.job4j.tree;

import java.util.*;
/**
 * Tree class for task "1. Создать элементарную структуру дерева [#1711]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.09.18.
 */
public class Tree<E extends Comparable<E>> implements SimpleTree<E>,  Iterable<E> {
    private Node<E> root;
    private  int size = 0;
    private int modCount = 0;

    /**
     * Tree constructor.
     * @param rootValue - E.
     */
    public Tree(E rootValue) {
        this.root = new Node<E>(rootValue);
    }


    /**
     * add.
     * добавляет узел в дерево.
     * @param parent - E.
     * @param child  - E.
     * @return boolean.
     */
    @Override
    public boolean add(E parent, E child) {
        boolean result = true;
        if (!findBy(child).isPresent()) {
            Optional<Node<E>> currentNode = findBy(parent);
            currentNode.get().add(new Node<>(child));
            this.size++;
            this.modCount++;
        } else  result = false;
        return result;
    }

    /**
     * findBy/
     * ищет в дереве узел с заданым значением.
     * @param value - E.
     * @return Optional<Node<E>>.
     */
    @Override
    public Optional<Node<E>> findBy(E value) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (el.eqValue(value)) {
                rsl = Optional.of(el);
                break;
            }
            for (Node<E> child : el.leaves()) {
                data.offer(child);
            }
        }
        return rsl;
    }

    /**
     * Iterator for Tree.
     * @return Iterator<E>.
     */
    @Override
    public Iterator<E> iterator() {
        return new Iterator<E>() {
            private Node<E> currentNode = root;
            private List<E> used = new ArrayList<>();
            private int counter = 0;
            Queue<Node<E>> queue = new LinkedList<>();
            private int modIndicator = modCount;

            /**
             * nextNode.
             * переводит каретку.
             * @param node - Node<E>.
             * @return Node<E>.
             */
            private Node<E> nextNode(Node<E> node) {
                for (Node<E> shuttle : node.getChildren()) {
                    queue.offer(shuttle);
                }
                return queue.poll();
            }

            /**
             * hasNext.
             * @return boolean.
             */
            @Override
            public boolean hasNext() {
                return this.counter < size;
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
                Node<E> result = currentNode;
                this.used.add(result.getValue());
                currentNode = this.nextNode(currentNode);
                counter++;
                return result.getValue();
            }
        };
    }
}
