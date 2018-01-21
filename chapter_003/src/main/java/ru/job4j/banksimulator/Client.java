package ru.job4j.banksimulator;

import java.util.Objects;
/**
 * Client.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.01.18
 */
public class Client {
    private String name;
    private String passport;

    /**
     * getter for passport.
     * @return - String.
     */
    public String getPassport() {
        return passport;
    }

    /**
     * Constructor for Client.
     * @param name - String.
     * @param passport - String.
     */
    Client(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    /**
     * equals.
     * @param o - Object.
     * @return - boolean.
     */
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(passport, client.passport);
    }

    /**
     * hashcode.
     * @return - int.
     */
    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }

    /**
     * toString.
     * @return - String.
     */
    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
