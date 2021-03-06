package ru.job4j.store;

/**
 * RoleStore for task "5.2.2. Реализовать Analize<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class RoleStore<Role> extends AbstractStore{

    /**
     * Constructor for RoleStore objects.
     * @param number
     */
    public RoleStore(int number) {
       super(number);
    }

}
