package ru.job4j.sortdepartments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDepartments {
    public List<String> sortAscending(List<String> departments) {
        departments.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {

                return left.charAt(1) > right.charAt(1) || left.length() >
                        right.length() || left.charAt(left.length() - 1) > right.charAt(right.length() - 1) ? 1 : -1;
            }
        });
        return departments;
    }

    public static void main(String[] args) {
        SortDepartments sortDepartments = new SortDepartments();
        ArrayList<String> list = new ArrayList<String>();
        list.add("K1\\SK1\\SSK1");
        list.add("K1\\SK1");
        list.add("K1\\SK2");
        list.add("K1");
        list.add("K2\\SK1");
        list.add("K1\\SK1\\SSK2");
        list.add("K2");
        list.add("K2\\SK1\\SSK1");
        list.add("K2\\SK1\\SSK2");

        sortDepartments.sortAscending(list);
        System.out.println(list);


    }
}
