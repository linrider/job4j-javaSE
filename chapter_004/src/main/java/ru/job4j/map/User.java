package ru.job4j.map;

import java.util.*;
/**
 * User for task "2. Не перекрывать equals hashCode [#1005]".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 02.08.18.
 */
public class User {
    private String name;
    private int children;
    private Calendar birthday;


    /**
     * constructor for User class.
     * @param name - String.
     * @param children - int.
     * @param birthday - Calendar.
     */
    public User(String name, int children, Calendar birthday) {
        this.name = name;
        this.children = children;
        this.birthday = birthday;
    }

    /**
     * @param args - String[].
     */
    public static void main(String[] args) {
        User user1 = new User("john", 1, new GregorianCalendar(1972, 8, 01));
        User user2 = new User("john", 1, new GregorianCalendar(1972, 8, 01));
        int hash1 = user1.hashCode();
//        System.out.println(Integer.toBinaryString(hash1));
//        int hash1Moved = hash1 >>> 16;
//        System.out.println("0000000000000000" + Integer.toBinaryString(hash1Moved));
//        int hashXORed = hash1 ^ hash1Moved;
//        System.out.println(Integer.toBinaryString(hashXORed));
//        System.out.println(hashXORed);
       // System.out.println(user2.hashCode() & 15);
        int var = 0;
        var = user1.hashCode() ^ var >>> 16;
        System.out.println(var);

        Map<User, Object> users = new HashMap<>();
        users.put(user1, new Object());
        users.put(user2, new Object());
        System.out.println(users);
    }

    /**
     * equals.
     * @param o - Object.
     * @return boolean.
     */
//    @Override
//    public boolean equals(Object o) {
//        if (this == o) return true;
//        if (!(o instanceof User)) return false;
//        User user = (User) o;
//        return children == user.children &&
//                Objects.equals(name, user.name) &&
//                Objects.equals(birthday, user.birthday);
//    }

    /**
     * hashCode.
     * @return int.
     */
    @Override
    public int hashCode() {
        int result = name != null ? name.hashCode() : 0;
        result = 31 * result + children + birthday.hashCode();
        return result;
    }
}
