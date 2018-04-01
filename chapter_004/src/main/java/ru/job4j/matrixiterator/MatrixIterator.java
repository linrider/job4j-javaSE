package ru.job4j.matrixiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

import static javax.management.Query.value;

/**
 * MatrixIterator for task "5.1.1. Итератор для двухмерного массива int[][]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.03.18
 */
public class MatrixIterator implements Iterator<Integer> {
    private int[][] values;
    private int row = 0;
    private int cell = 0;


    /** constructor MatrixIterator.
     * @param values - final int[][].
     */
    public MatrixIterator(final int[][] values) {
        this.values = values;
    }

    /**
     * hasNext.
     * @return - Integer.
     */
    @Override
    public boolean hasNext() {
        return row < values.length && cell < values[row].length;
    }

    /**
     * next.
     * @return - Integer.
     */
    @Override
    public Integer next() {
        if (values.length == 0) {
            throw new NoSuchElementException();
        }
        //перевод каретки
        Integer res = values[row][cell];
        if (cell >= values[row].length - 1) {
            ++row;
            cell = 0;
        } else {
            ++cell;
        }
        return res;
    }
}
