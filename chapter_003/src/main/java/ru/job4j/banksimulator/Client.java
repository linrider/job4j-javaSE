package ru.job4j.banksimulator;

import java.util.Objects;

public class Client {
    private String name;
    private String passport;

    public void setName(String name) {
        this.name = name;
    }

    public void setPassport(String passport) {
        this.passport = passport;
    }

    public String getName() {
        return name;
    }

    public String getPassport() {
        return passport;
    }

    Client(String name, String passport) {
        this.name = name;
        this.passport = passport;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Client client = (Client) o;
        return Objects.equals(name, client.name) &&
                Objects.equals(passport, client.passport);
    }

    @Override
    public int hashCode() {

        return Objects.hash(name, passport);
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", passport='" + passport + '\'' +
                '}';
    }
}
