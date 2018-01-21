package ru.job4j.banksimulator;

/**
 * Account.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.01.18
 */
public class Account {
    private double value;
    private String requisites;

    /**
     * Constructor for Accaunt.
     * @param value - double.
     * @param requisites - String.
     */
    public Account(double value, String requisites) {
        this.value = value;
        this.requisites = requisites;
    }

    /**
     * value setter.
     * @param value - double.
     */
    public void setValue(double value) {
        this.value = value;
    }

    /**
     * value getter.
     * @return double.
     */
    public double getValue() {
        return value;
    }

    /**
     * requisites getter.
     * @return Struing.
     */
    public String getRequisites() {
        return requisites;
    }

    /**
     * toString.
     * @return String.
     */
    @Override
    public String toString() {
        return "Account{" +
                "value=" + value +
                ", requisites='" + requisites + '\'' +
                '}';
    }
}
