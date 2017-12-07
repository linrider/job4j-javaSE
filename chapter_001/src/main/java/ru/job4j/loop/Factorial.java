package ru.job4j.loop;

/**
 * Factorial. Task "4.2. Создать программу вычисляющую факториал. [#193]".
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 0.1
 */

public class Factorial {

    public int calc(int n) {
        int factorial = 1;
        if (n != 0) {
            for (int i = 1; i <= n; i++) {
                factorial *= i;
            }
        }
        return factorial;
    }
}
