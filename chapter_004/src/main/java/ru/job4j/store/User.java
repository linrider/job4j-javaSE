package ru.job4j.store;

public class User extends Base{
    private String userName;

    public User(String userName, String id) {
        super(id);
        this.userName = userName;

    }



}
