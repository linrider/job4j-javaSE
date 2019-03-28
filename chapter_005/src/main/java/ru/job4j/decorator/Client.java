package ru.job4j.decorator;

public class Client {
    public static void main(String[] args) {
        Car car = new SimpleCar();
        System.out.println(car.getPrice());
        System.out.println(car.getDescription());

        car = new Conditioner(car);
        System.out.println(car.getDescription());
        System.out.println(car.getPrice());

        Car maxCar = new WoodInterior(new Conditioner(new SimpleCar()));
        System.out.println(maxCar.getDescription() + " " + maxCar.getPrice());

    }
}
