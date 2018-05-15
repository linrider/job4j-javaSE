package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

public class RoleStore<T extends Base> implements Store{
    private SimpleArray<T> roleStore;
    private int number;

    public RoleStore(int number) {
        this.roleStore = new SimpleArray<>(number);
    }

    @Override
    public void add(Base model) {
        roleStore.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int position = 0;

        while (position < number) {
            if (id.equals(roleStore.get(position).getId())) {
                roleStore.set(position, (T) model);
                break;
            } else {
                position++;
            }
        }

        return roleStore.get(position).equals(model);
    }

    @Override
    public boolean delete(String id) {
        int position = 0;
        while (position < number) {
            if (roleStore.get(position).getId().equals(id)) {
                roleStore.delete(position);
                break;
            } else {
                position++;
            }
        }

        return roleStore.get(position) == null;
    }

    @Override
    public T findById(String id) {
        T result = null;
        Iterator<T> it = roleStore.iterator();
        while (it.hasNext()) {
            result = it.next();
            if (id.equals(result.getId())) {
                break;
            }
        }

        return result;
    }
}
