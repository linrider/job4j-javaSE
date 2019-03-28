package ru.job4j.decorator;

public class Conditioner extends CarDecorator {
    protected Conditioner(Car car) {
        super(car);
    }

    @Override
    public int getPrice() {
        return super.getPrice() + 20000;
    }

    @Override
    public String getDescription() {
        return super.getDescription() + " with conditioner";
    }
}
