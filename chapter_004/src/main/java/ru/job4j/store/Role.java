package ru.job4j.store;
/**
 * Role for task "5.2.2. Реализовать Analize<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public class Role extends Base{
    private String roleName;

    /**
     * Role class constructor.
     * @param id - String.
     * @param roleName - String.
     */
    public Role(String roleName, String id) {
        super(id);
        this.roleName = roleName;
    }

    /**
     * getRoleName.
     * @return String.
     */
    public String getRoleName() {
        return roleName;
    }
}
