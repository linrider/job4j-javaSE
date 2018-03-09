package ru.job4j.sortdepartments;


import java.util.*;
/**
 * SortDepartments for task "Отсортировать департаменты [#34352]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 30.12.17
 */
public class SortDepartments {

    /**
     * splitAndComplement.
     * @param departments - List<String>.
     * @return List<String>.
     */
    public List<List<String>> splitAndComplement(String[] departments) {

        ArrayList<List<String>> branches = new ArrayList<>();
        //this is spliting
        for (String string : departments) {
            branches.add(Arrays.asList(string.split("\\\\")));
        }

        //this is complementing
        //от foreach пришлось отказаться, добавление элементов в branches выбрасывает ConcurrentModificationException
        for (int i = 0; i < branches.size(); i++) {
            if (branches.get(i).size() > 1) {
                ArrayList<String> missing = new ArrayList<>(branches.get(i));
                missing.remove(missing.size() - 1);

                boolean grade = false;
                for (int j = 0; j < branches.size(); j++) {
                    grade = missing.equals(branches.get(j));
                    if (grade) {
                        break;
                    }
                }
                if (!grade) {
                    branches.add(missing);
                }
            }
        }
        return branches;
    }

    /**
     * deSplit (восстанвливает строки кодово департаментов)ю
     * @param branches - List<List<String>>.
     * @return List<String>.
     */
    public List<String> deSplit(List<List<String>> branches) {
        List<String> departments = new ArrayList<>();
        for (List<String> branch : branches) {
            StringBuilder string = new StringBuilder();
            for (int i = 0; i < branch.size(); i++) {
                string.append(branch.get(i));
                if (i != branch.size() - 1) {
                    string.append("\\");
                }
            }
            departments.add(string.toString());
        }
        return departments;
    }

    /**
     * sortAscending (сортировка по возрастанию).
     * @param departments - List<List<String>>.
     * @return List<List<String>>.
     */
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

    /**
     * sortDecreasing (сортировка по убыванию с сохранением иерархии).
     * @param departments - List<List<String>>.
     * @return List<List<String>>.
     */
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
                return res == 0 ? Integer.compare(left.size(), right.size()): res;
            }
        });
        return departments;
    }
}
