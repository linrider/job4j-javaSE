package ru.job4j.coffeeMachine;
/**
 * NotEnoughMoneyException class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.11.17
 */
public class NotEnoughMoneyException extends RuntimeException{

    /**
     * NotEnoughMoneyException constructor.
     * @param msg - String.
     */
    public NotEnoughMoneyException(String msg) {
        super(msg);
    }
}
