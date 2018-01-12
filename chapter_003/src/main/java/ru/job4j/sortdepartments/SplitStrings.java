package ru.job4j.sortdepartments;


import java.util.*;

public class SplitStrings {

    public List<List<String>> splitStrings(List<String> departments) {
        ArrayList<List<String>> branches = new ArrayList<>();

        for (String string : departments) {
            String[] stringArr = string.split("\\\\");
            branches.add(Arrays.asList(stringArr));
        }

        return branches;
    }

    public List<List<String>> sortAscending(List<List<String>> departments) {
        departments.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> left, List<String> right) {
                final int res = Integer.compare(left.size(), right.size());
                return res == 0 ? compare("fdvdfv", "cfdsvf") : res;
            }

        });
        return departments;
    }


    public static void main(String[] args) {
        SplitStrings splitStrings = new SplitStrings();
        List<String> departments = new ArrayList<>();
        departments.add("K1\\SK1");
        departments.add("K2");
        departments.add("K1");
        departments.add("K1\\SK1\\SSK1");

        List<List<String>> list = new ArrayList<>(splitStrings.splitStrings(departments));
        List<List<String>> sorted = new ArrayList<>(splitStrings.sortAscending(list));
        System.out.println(sorted);
    }
}
