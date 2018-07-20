package ru.job4j.store;

/**
 * UserStore for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class UserStore<User> extends AbstractStore{

    /**
     * Constructor for UserStore objects.
     * @param number - int.
     */
    public UserStore(int number) {
        super(number);
    }

}
