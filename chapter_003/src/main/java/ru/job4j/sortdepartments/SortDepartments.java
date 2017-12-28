package ru.job4j.sortdepartments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDepartments {
    private static final int[] pos = {1, 5, 10};

    public List<String> sortAscending(List<String> departments) {
        departments.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                int res = ((left.length() == 2) || (right.length() == 2)) ? Integer.compare((int) left.charAt(pos[0]), (int) right.charAt(pos[0])) : 1;
                //res = ((left.length() == 6) || (right.length() == 6)) ? Integer.compare((int) left.charAt(pos[1]), (int) right.charAt(pos[1])) : 1;
                return res;
            }
        });
        return departments;
    }

    public static void main(String[] args) {
        SortDepartments sortDepartments = new SortDepartments();
        ArrayList<String> list = new ArrayList<String>();
        list.add("K1\\SK1");
        list.add("K2");
        list.add("K1\\SK2");
        list.add("K1");
        list.add("K2\\SK1");
        list.add("K1\\SK1\\SSK2");

        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");
        list.add("K1\\SK1\\SSK1");

        for (String x : list) {
            System.out.println(x);
        }
        System.out.println("-------------");
        sortDepartments.sortAscending(list);
        for (String x : list) {
            System.out.println(x);
        }


    }
}
