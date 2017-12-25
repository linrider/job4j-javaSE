package ru.job4j.sortdepartments;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class SortDepartments {
    public List<String> sortAscending(List<String> departments) {
        departments.sort(new Comparator<String>() {
            @Override
            public int compare(String left, String right) {

                return left.length() > right.length() ? 1 : -1;
            }
        });
        return departments;
    }

    public static void main(String[] args) {
        SortDepartments sortDepartments = new SortDepartments();
        ArrayList<String> list = new ArrayList<String>();
        list.add("K1\Sk1");


    }
}
