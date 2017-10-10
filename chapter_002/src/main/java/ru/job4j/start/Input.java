package ru.job4j.start;
/**
 * Input interface.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 19.09.17
 */
public interface Input {
    /**
     * @param question - String.
     * @return String
     */
    String ask(String question);

    int ask(String question, int[] range);
}
