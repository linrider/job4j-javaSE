package ru.job4j.coffeeMachine;

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
     * WhenCoffeeMachineGetValueAndPriceThenGiveChange.
     */
    @Test
    public void WhenCoffeeMachineGetValueAndPriceThenGiveChange() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int result[] = coffeeMachine.changes(50, 35);
        int[] expectation = {10, 5};
        assertThat(result, is(expectation));
    }

    /**
     * WhenValueEqualsPriceThenThenThenGiveZero.
     */
    @Test
    public void WhenValueEqualsPriceThenThenThenGiveZero() {
        CoffeeMachine coffeeMachine = new CoffeeMachine();
        int result[] = coffeeMachine.changes(50, 50);
        int[] expectation = {0};
        assertThat(result, is(expectation));
    }
}
