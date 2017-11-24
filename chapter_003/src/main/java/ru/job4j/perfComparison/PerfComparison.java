package ru.job4j.perfComparison;

import java.util.*;
/**
 * PerfComparison for task "2. Тестирование производительности коллекций.".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 23.11.17
 */
public class PerfComparison {
    private static final Random RN = new Random();


    /**
     * add.
     * @param collection - Collection<String>.
     * @param amount - int.
     * @return - long.
     */
    public static long add(Collection<String> collection, int amount) {
        Date start = new Date();
        for (int i = 0; i < amount; i++) {
            collection.add(String.valueOf(System.currentTimeMillis() + RN.nextLong()));
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    /**
     * delete.
     * @param collection - Collection<String>.
     * @param amount - int.
     * @return - long.
     */
    public static long delete(Collection<String> collection, int amount) {
        Date start = new Date();

        Iterator<String> itr = collection.iterator();
        for (int i = 0; i < amount; i++) {
            itr.next();
            itr.remove();
        }
        Date finish = new Date();
        return finish.getTime() - start.getTime();
    }

    /**
     * main.
     * @param args - String.
     */
    public static void main(String args[]) {
        LinkedList<String> linkedList = new LinkedList<String>();
        ArrayList<String> arrayList = new ArrayList<String>();
        TreeSet<String> treeSet = new TreeSet<String>();

        System.out.println(String.format("Test for LinkedList: addition took %s ms , removal took %s ms ", add(linkedList, 1000000), delete(linkedList, 100000)));
        System.out.println(String.format("Test for ArrayList: addition took %s ms , removal took %s ms ", add(arrayList, 1000000), delete(arrayList, 100000)));
        System.out.println(String.format("Test for TreeSet: addition took %s ms , removal took %s ms ", add(treeSet, 1000000), delete(treeSet, 100000)));
    }
}
