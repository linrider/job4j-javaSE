package ru.job4j.sortdepartments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDepartments {

    public List<String> sortAscending(List<String> departments) {
        departments.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                return left.compareTo(right);
            }
        });
        return departments;
    }

    public List<String> sortDecreasing(List<String> departments) {
        departments.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {
                return right.compareTo(left);
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
        System.out.println("-------------");
        sortDepartments.sortDecreasing(list);
        for (String x : list) {
            System.out.println(x);
        }

    }
}
