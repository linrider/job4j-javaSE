package ru.job4j.coffeeMachine;
/**
 * CoffeeMachine class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.11.17
 */

public class CoffeeMachine {
    private int[] coins = {1, 2, 5, 10};


    /**
     * changes.
     * @param value - int.
     * @param price - int.
     * @return int[].
     * @throws NotEnoughMoneyException
     */
    int[] changes(int value, int price) throws NotEnoughMoneyException {
        int difference = value - price;

        if (difference < 0) throw new NotEnoughMoneyException("Not enough money. Please enter more money.");
        else if (difference == 0) {
            int[] changes = {0};
            return changes;
        }

        int a = 0;
        int i = this.coins.length - 1;
        //определяем длину массива
        do {
            a += difference / this.coins[i];
            difference = difference % this.coins[i--];
        } while (difference > 0 && i >= 0);

        int[] changes = new int[a];
        int position = 0;
        a = 0;
        i = this.coins.length - 1;
        difference = value - price;
        //жадный алгоритм
        do {
            a = difference /this.coins[i];
            for (int j = 0; j < a; j++) {
                changes[position++] = this.coins[i];
            }
            difference = difference % this.coins[i--];
        } while (difference >= 0 && i >= 0);

        return changes;
    }
}
