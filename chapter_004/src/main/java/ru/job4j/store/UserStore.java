package ru.job4j.store;

import ru.job4j.simplearray.SimpleArray;

import java.util.Iterator;

public class UserStore<T extends Base> implements Store<T>{
    private SimpleArray<T> userStore;
    private int number;

    public UserStore(int number) {
        this.userStore = new SimpleArray<>(number);
        this.number = number;
    }

    @Override
    public void add(Base model) {
        userStore.add((T) model);
    }

    @Override
    public boolean replace(String id, Base model) {
        int position = 0;

        while (position < number) {
            if (userStore.get(position).getId().equals(id)) {
                userStore.set(position, (T) model);
                break;
            } else {
                position++;
            }
        }

        return userStore.get(position).getId().equals(model.getId());
    }

    @Override
    public boolean delete(String id) {
        int position = 0;
        while (position < number) {
            if (userStore.get(position).getId().equals(id)) {
                userStore.delete(position);
                break;
            } else {
                position++;
            }
        }

        return userStore.get(position) == null;
    }

    @Override
    public T findById(String id) {
        T result = null;
        Iterator<T> it = userStore.iterator();
        while (it.hasNext()) {
            result = it.next();
            if (id.equals(result.getId())) {
                break;
            }
        }

        return result;
    }
}
