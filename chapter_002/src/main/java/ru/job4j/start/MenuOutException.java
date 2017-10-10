package ru.job4j.start;
/**
 * MenuOutException class.
 *
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 09.10.17
 */
public class MenuOutException extends RuntimeException {

    /**
     * MenuOutException constructor.
     * @param msg - String.
     */
    public MenuOutException(String msg) {
        super(msg);
    }
}
