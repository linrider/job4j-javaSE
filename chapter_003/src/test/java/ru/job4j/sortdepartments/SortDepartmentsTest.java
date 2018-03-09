package ru.job4j.sortdepartments;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

import java.util.Arrays;
import java.util.List;
/**
 * SortDepartmentsTest for task "Отсортировать департаменты [#34352]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 30.12.17
 */
public class SortDepartmentsTest {
    private String[] departments = new String[]{"K2\\SK1\\SSK2", "K2\\SK1\\SSK1", "K2", "K1\\SK1\\SSK2",
            "K1\\SK1\\SSK1", "K1\\SK2", "K1\\SK1"};

    /**
     * whenStringArrayIsSortedAscending.
     */
    @Test
    public void whenStringArrayIsSortedAscending() {
        SortDepartments sortDepartments = new SortDepartments();
        List<List<String>> branches = sortDepartments.splitAndComplement(departments);
        List<List<String>> sorted = sortDepartments.sortAscending(branches);
        List<String> result = sortDepartments.deSplit(sorted);
        List<String> expected = Arrays.asList("K1", "K1\\SK1", "K1\\SK1\\SSK1", "K1\\SK1\\SSK2", "K1\\SK2",
                "K2", "K2\\SK1", "K2\\SK1\\SSK1", "K2\\SK1\\SSK2");
        assertThat(result, is(expected));

    }

    /**
     * whenStringArrayIsSortedDecreasing.
     */
    @Test
    public void whenStringArrayIsSortedDecreasing() {
        SortDepartments sortDepartments = new SortDepartments();
        List<List<String>> branches = sortDepartments.splitAndComplement(departments);
        List<List<String>> sorted = sortDepartments.sortDecreasing(branches);
        List<String> result = sortDepartments.deSplit(sorted);
        List<String> expected = Arrays.asList("K2", "K2\\SK1", "K2\\SK1\\SSK2", "K2\\SK1\\SSK1",
                "K1", "K1\\SK2", "K1\\SK1", "K1\\SK1\\SSK2", "K1\\SK1\\SSK1");
        assertThat(result, is(expected));
    }
}
