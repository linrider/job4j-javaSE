package ru.job4j.decorator;

public class SimpleCar implements Car {
    @Override
    public int getPrice() {
        return 100000;
    }

    @Override
    public String getDescription() {
        return "The simplest car";
    }
}
