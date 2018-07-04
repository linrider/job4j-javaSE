package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;
/**
 * UserStoreTest for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class UserStoreTest {
    private UserStore tUserStore = new UserStore(2);

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        User user1 = new User("User One", "id_01");
        User user2 = new User("User Two", "id_02");
        tUserStore.add(user1);
        tUserStore.add(user2);

    }

    /**
     * whenOneObjectIsRBeingReplacedForAnotherOne.
     */
    @Test
    public void whenOneObjectIsRBeingReplacedForAnotherOne() {
        User user3 = new User("User Three", "id_03");
        assertThat(tUserStore.replace("id_02", user3), is(true));
    }

    /**
     * whenOneObjectIsBeingDeleted.
     */
    @Test
    public void whenOneObjectIsBeingDeleted() {
        assertThat(tUserStore.delete("id_02"), is(true));
    }

    /**
     * whenAnObjectIsBeingFoundByItsId.
     */
    @Test
    public void whenAnObjectIsBeingFoundByItsId() {
        User res = (User) tUserStore.findById("id_02");
        assertThat(res.getUserName(),is("User Two"));
    }
}