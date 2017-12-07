package ru.job4j.coffeemachine;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
/**
 * CoffeeMachineTest class.
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com)
 * @version $Id$
 * @since 20.11.17
 */
public class CoffeeMachineTest {

    /**
     * whenCoffeeMachineGetValueAndPriceThenGiveChange.
     */
    @Test
    public void whenCoffeeMachineGetValueAndPriceThenGiveChange() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 35);
        int[] expectation = {10, 5};
        assertThat(result, is(expectation));
    }

    /**
     * whenValueEqualsPriceThenThenThenGiveZero.
     */
    @Test
    public void whenValueEqualsPriceThenThenThenGiveZero() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int[] result = coffeeMachine.changes(50, 50);
        int[] expectation = {0};
        assertThat(result, is(expectation));
    }
}
