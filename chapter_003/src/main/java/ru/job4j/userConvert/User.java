package ru.job4j.userConvert;
/**
 * User for task "2. Написать программу преобразования List в Map".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 27.11.17
 */
public class User {
    protected int id;
    protected String name;
    protected String city;

    /**
     * Constructor for User class.
     * @param name - String.
     * @param city -String.
     * @param id - int.
     */
    User(String name, String city, int id) {
        this.name = name;
        this.city = city;
        this.id = id;
    }
}
