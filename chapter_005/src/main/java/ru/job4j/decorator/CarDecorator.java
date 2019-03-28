package ru.job4j.decorator;

public abstract class CarDecorator implements Car {
    protected final Car car;

    protected CarDecorator(Car car) {
        this.car = car;
    }

    @Override
    public int getPrice() {
        return car.getPrice();
    }

    @Override
    public String getDescription() {
        return car.getDescription();
    }
}
