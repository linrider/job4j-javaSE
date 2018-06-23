package ru.job4j.store;
/**
 * User for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class User extends Base{
    private String userName;

    /**
     * Constructor for User class.
     * @param userName - String.
     * @param id - String.
     */
    public User(String userName, String id) {
        super(id);
        this.userName = userName;

    }

    /**
     * getUserName.
     * @return String.
     */
    public String getUserName() {
        return userName;
    }
}
