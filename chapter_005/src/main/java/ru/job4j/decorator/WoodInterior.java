package ru.job4j.decorator;

public class WoodInterior extends CarDecorator {
    protected WoodInterior(Car car) {
        super(car);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 30000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with wood interior";
    }
}
