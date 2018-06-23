package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;
/**
 * AbstractStore for task "5.2.2. Реализовать Store<T extends Base>".
 * @author Wladyslaw Lazin (wladislaw.lazin@gmail.com).
 * @version $Id$.
 * @since 11.06.18.
 */
public abstract class AbstractStore<T extends Base> implements Store<T> {
    protected int number;
    protected SimpleArray<T> store;

    /**
     * add.
     * @param model - Base.
     */
    @Override
    public void add(Base model) {
        store.add((T) model);
    }

    /**
     * replace.
     * @param id    - String.
     * @param model - T.
     * @return boolean.
     */
    @Override
    public boolean replace(String id, Base model) {
        int position = 0;

        while (position < number) {
            if (id.equals(store.get(position).getId())) {
                store.set(position, (T) model);
                break;
            } else {
                position++;
            }
        }

        return store.get(position).equals(model);
    }

    /**
     * delete.
     * @param id - String.
     * @return boolean.
     */
    @Override
    public boolean delete(String id) {
        int position = 0;
        while (position < number) {
            if (store.get(position).getId().equals(id)) {
                store.delete(position);
                break;
            } else {
                position++;
            }
        }

        return store.get(position) == null;
    }

    /**
     * findById.
     * @param id - String.
     * @return boolean.
     */
    @Override
    public T findById(String id) {
        T result = null;
        Iterator<T> it = store.iterator();
        while (it.hasNext()) {
            result = it.next();
            if (id.equals(result.getId())) {
                break;
            }
        }

        return result;
    }
}
