package ru.job4j.sortdepartments;


import java.util.*;

public class SortDepartments {

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
                int res = 0;
                for (int i = 0; i < (left.size() < right.size() ? left.size() : right.size()); i++) {
                    res = left.get(i).compareTo(right.get(i));
                    if (res != 0) {
                        break;
                    }
                }
                return res == 0 ? Integer.compare(left.size(), right.size()) : res;
            }

        });
        return departments;
    }

    public List<List<String>> sortDecreasing(List<List<String>> departments) {
        departments.sort(new Comparator<List<String>>() {
            @Override
            public int compare(List<String> left, List<String> right) {
                int res = 0;
                for (int i = 0; i < (left.size() < right.size() ? left.size() : right.size()); i++) {
                    res = right.get(i).compareTo(left.get(i));
                    if (res != 0) {
                        break;
                    }
                }
                return res == 0 ? Integer.compare(left.size(), right.size()) : res;
            }
        });
        return departments;
    }


    public static void main(String[] args) {
        SortDepartments splitStrings = new SortDepartments();
        List<String> departments = new ArrayList<>();
        departments.add("K1\\SK1\\SSK2");
        departments.add("K2\\SK1\\SSK2");
        departments.add("K1\\SK1");
        departments.add("K2\\SK2\\SSK1");
        departments.add("K2");
        departments.add("K1");
        departments.add("K1\\SK1\\SSK1");
        departments.add("K2\\SK2");

        List<List<String>> list = new ArrayList<>(splitStrings.splitStrings(departments));
        List<List<String>> sortedUp = new ArrayList<>(splitStrings.sortAscending(list));
        List<List<String>> sortedDown = new ArrayList<>(splitStrings.sortDecreasing(list));
        System.out.println(sortedUp);
        System.out.println(sortedDown);
    }
}
