package ru.job4j.primeiterator;

import java.util.Iterator;
import java.util.NoSuchElementException;
/**
 * PrimeIterator for task "5.1.3. Создать итератор простые числа.".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 01.04.18.
 */
public class PrimeIterator implements Iterator<Integer> {
    private int position;
    private boolean hasNextFlag = false;
    private Integer lastPrimePos = null;
    private final int[] numbers;

    /**
     * PrimeIterator constructor.
     * @param numbers - int[].
     */
    public PrimeIterator(int[] numbers) {
        this.numbers = numbers;

        //looking for first prime number's index
        for (int i = 0; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                position = i;
                break;
            }
        }
        //looking for last prime number's index
        for (int i = position + 1; i < numbers.length; i++) {
            if (isPrime(numbers[i])) {
                lastPrimePos = i;
            }
        }

    }

    /**
     * isPrime.
     * @param value - int.
     * @return boolean.
     */
    public boolean isPrime(int value) {
        boolean primeFlag = true;
        for (int i = 2; i*i <= value; i++) {
         if (value % i == 0) {
             primeFlag = false;
             break;
         }
        }
        if (value == 1) {
            primeFlag = false;
        }
        if (value == 2) {
            primeFlag = true;
        }
        return primeFlag;
    }

    /**
     * hasNext.
     * @return boolean.
     */
    @Override
    public boolean hasNext() {
        if (lastPrimePos != null) {
            hasNextFlag = position <= lastPrimePos;
        }
        return hasNextFlag;
    }

    /**
     * next.
     * @return Integer.
     */
    @Override
    public Integer next() {
        if (!hasNextFlag) {
            throw new NoSuchElementException();
        }

        int res = numbers[position];

        if (position < lastPrimePos) {
            for (int i = position + 1; i < numbers.length; i++) {

                if (isPrime(numbers[i])) {
                    position = i;
                    break;
                }
            }
        } else {
            position++;
        }

        return res;
    }
}
