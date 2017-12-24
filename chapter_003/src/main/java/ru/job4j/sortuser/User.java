package ru.job4j.sortuser;

/**
 * User for task "1. Организовать сортировку User".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 03.12.17
 */
public class User implements Comparable<User>{
    protected String name;
    protected int age;

    /**
     * Constructor for User.
     * @param name - String.
     * @param age - int.
     */
    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * toString.
     * @return - String.
     */
    @Override
    public String toString() {
        return "User{" + "name='" + name + '\'' + ", age=" + age + '}';
    }

    @Override
    public int compareTo(User user) {
        final int res = Integer.compare(this.age, user.age);
        return res != 0 ? res : this.name.compareTo(user.name);
    }
}
