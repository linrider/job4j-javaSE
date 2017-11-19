package ru.job4j.coffeeMachine;

public class CoffeeMachine {
    private int value;
    private int price;
    private int[] coins = {1, 2, 5, 10};


    CoffeeMachine(int value, int price) {
        this.value = value;
        this.price = price;
    }

    int[] changes(int value, int price) {
        int difference = value - price;

        for (int i = this.coins.length - 1; i <= 0; i--) {

        }

        int[] change = new int[10];
        return change;
    }
}
