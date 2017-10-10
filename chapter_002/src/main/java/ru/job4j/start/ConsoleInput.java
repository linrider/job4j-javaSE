package ru.job4j.start;


import java.util.Scanner;
/**
 * ConsoleInput.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 19.09.17
 */
public class ConsoleInput implements Input {
    private Scanner scanner = new Scanner(System.in);

    /**
     * ask.
     * @param question - String.
     * @return String
     */
    @Override
    public String ask(String question) {
        System.out.print(question);
        return scanner.nextLine();
    }

    /**
     * ask.
     * @param question - String.
     * @param range - int[].
     * @return int.
     */
    @Override
    public int ask(String question, int[] range) {
        int key = Integer.valueOf(this.ask(question));
        boolean exist = false;
        for (int value : range) {
            if (value == key) {
                exist = true;
                break; }

        }
        if (exist) {
            return key;
        } else { throw new MenuOutException("out of menu range!"); }

    }
}
