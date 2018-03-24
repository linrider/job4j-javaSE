package ru.job4j.evennumbersiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

/**
 * EvenNumbersIterator for task "5.1.2. Создать итератор четные числа".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 21.03.18
 */
public class EvenNumbersIterator implements Iterator<Integer> {
    private final int [] numbers;
    private boolean hasNextFlag = false;
    private Integer position = 0;
    private Integer lastNumbIndex = null;


    /**
     * @param numbers - int[].
     */
    public EvenNumbersIterator(int[] numbers) {
        this.numbers = numbers;

        for (int i = numbers.length - 1; i >= 0; i--) {
            if (numbers[i] != 0 && numbers[i] % 2 == 0) {
                lastNumbIndex = i;
                break;
            }

        }

        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] != 0 && numbers[i] % 2 == 0) {
                position = i;
                break;
            }
        }
    }

    /**
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        if (lastNumbIndex != null) {
            hasNextFlag = position <= lastNumbIndex;
        }
        return hasNextFlag;
    }

    /**
     * @return int[].
     */
    @Override
    public Integer next() {
        if (!hasNextFlag) {
            throw new NoSuchElementException();
        }

        int res = numbers[position];

        for (int i = position + 1; i < numbers.length; i++) {
            if (numbers[i] != 0 && numbers[i] % 2 == 0) {
                position = i;
                break;
            } else if (i > lastNumbIndex && i == numbers.length - 1) {
                position = numbers.length - 1;
            }
        }

        return res;
    }
}
