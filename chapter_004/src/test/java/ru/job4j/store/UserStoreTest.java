package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;
import static org.hamcrest.Matchers.is;

public class UserStoreTest {
    private UserStore tUserStore = new UserStore(2);

    @Before
    public void setUp() {
        User user1 = new User("User One", "id_01");
        User user2 = new User("User Two", "id_02");
        tUserStore.add(user1);
        tUserStore.add(user2);

    }

    @Test
    public void replace() {
        User user3 = new User("User Three", "id_03");
        assertThat(tUserStore.replace("id_02", user3), is(true));
    }

    @Test
    public void delete() {
        assertThat(tUserStore.delete("id_02"), is(true));
    }

    @Test
    public void findById() {
        assertThat(tUserStore.findById("id_02"), is());
    }
}