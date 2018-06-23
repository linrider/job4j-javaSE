package ru.job4j.store;

import org.junit.Before;
import org.junit.Test;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.*;
/**
 * UserStoreTest for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class RoleStoreTest {
    private RoleStore tRoleStore = new RoleStore(2);

    /**
     * setUp.
     */
    @Before
    public void setUp() {
        Role role1 = new Role("Role One", "id_01");
        Role role2 = new Role("Role Two", "id_02");
        tRoleStore.add(role1);
        tRoleStore.add(role2);

    }

    /**
     * whenOneObjectIsRBeingReplacedForAnotherOne.
     */
    @Test
    public void whenOneObjectIsRBeingReplacedForAnotherOne() {
        Role role3 = new Role("Role Three", "id_03");
        assertThat(tRoleStore.replace("id_02", role3), is(true));
    }

    /**
     * whenOneObjectIsBeingDeleted.
     */
    @Test
    public void whenOneObjectIsBeingDeleted() {
        assertThat(tRoleStore.delete("id_02"), is(true));
    }

    /**
     * whenAnObjectIsBeingFoundByItsId.
     */
    @Test
    public void whenAnObjectIsBeingFoundByItsId() {
        Role res = (Role) tRoleStore.findById("id_02");
        assertThat(res.getRoleName(),is("Role Two"));
    }

}