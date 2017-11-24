package ru.job4j.perfComparison;

import java.awt.*;
import java.util.Iterator;
import java.util.TreeSet;

public class Polygon {

    public static void main(String args[]) {
        TreeSet<String> treeSet = new TreeSet<>();
        treeSet.add("John");
        treeSet.add("Paul");
        treeSet.add("George");
        treeSet.add("Chopstick");
        treeSet.add("Robert");
        treeSet.add("Julia");
        treeSet.add("Andrew");

        for (String setMember : treeSet) {
            System.out.println(setMember);
        }
        System.out.println();

        Iterator<String> itr = treeSet.iterator();
        for (int i = 0; i < 3; i++) {
            itr.next();
            itr.remove();
        }

        for (String setMember : treeSet) {
            System.out.println(setMember);
        }
        System.out.println();
    }

}
