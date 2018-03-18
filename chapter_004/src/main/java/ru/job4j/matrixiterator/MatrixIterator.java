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
    private int iRow = 0;
    private int iColumn = 0;
    private int absLength = 0;
    private int count = 0;

    /** constructor MatrixIterator.
     * @param values - final int[][].
     */
    public MatrixIterator(final int[][] values) {
        this.values = values;
        for (int i = 0; i < values.length; i++) {
            absLength += values[i].length;
        }
    }

    /**
     * hasNext.
     * @return - Integer.
     */
    @Override
    public boolean hasNext() {
        return count < absLength;
    }

    /**
     * next.
     * @return - Integer.
     */
    @Override
    public Integer next() {
        if (absLength == 0) {
            throw new NoSuchElementException();
        }

        count++;
        Integer res = values[iRow][iColumn];
        if (iColumn >= values[iRow].length - 1) {
            ++iRow;
            iColumn = 0;
        } else {
            ++iColumn;
        }
        return res;
    }
}
