package ru.job4j.loopfinder;
/**
 * LoopFinder for task "5.3.4. Задан связанный список. Определить цикличность. [#161]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 14.07.18.
 */
public class LoopFinder {

    protected Node<Integer> first = new Node<>(1);
    protected Node<Integer> two = new Node<>(2);
    protected Node<Integer> third = new Node<>(3);
    protected Node<Integer> four = new Node<>(4);

    /**
     * LoopFinder constructor.
     */
    public  LoopFinder() {

        first.next = two;
        two.next = third;
        third.next = four;
        four.next = first;
    }


    /**
     * Node class.
     * @param <T>.
     */
    protected class Node<T> {
        T value;
        Node<T> next;

        public Node(T value) {
            this.value = value;
        }
    }


    /**
     * hasCycle.
     * @param first - Node.
     * @return boolean.
     * метод запускает обход списка с помощью 2-х указателей,
     * движущихся с разными скоростями. При наличии замыкания
     * они рано или поздно встречаются.
     */
    public boolean hasCycle(Node first) {
        Node slowMarker = first;
        Node fastMarker = first;
        boolean result = false;

        while (!result) {
            slowMarker = slowMarker.next;
            fastMarker = fastMarker.next.next;
            if (slowMarker == null || fastMarker == null) {
                break;
            }
            result = slowMarker == fastMarker;
        }
        return result;
    }
}
