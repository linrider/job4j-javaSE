package ru.job4j.perfComparison;

import javax.jws.soap.SOAPBinding;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class Polygon {

    static class User {
        private final String name;

        User(String name) {
            this.name = name;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) return true;
            if (o == null || getClass() != o.getClass()) return false;
            User user = (User) o;
            return Objects.equals(name, user.name);
        }

        @Override
        public int hashCode() {

            return Objects.hash(name);
        }
    }
    public static void main(String[] args) {
        List<User> users =new ArrayList<User>();

        users.add(new User("John"));
        boolean result = users.contains(new User("John"));
        System.out.print(result);
    }
}
