package ru.job4j.banksimulator;

public class Account {
    private double value;
    private String requisites;

    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
