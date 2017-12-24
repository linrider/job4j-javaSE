package ru.job4j.examples;

import java.util.*;

public class Person implements Comparable<Person>{
    private int age;
    private String name;
    private String job;

    public Person(int age, String name, String job) {
        this.age = age;
        this.name = name;
        this.job = job;
    }

    @Override
    public String toString() {
        return "Person{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", job='" + job + '\'' +
                '}';
    }

    public static void main(String[] args) {
        List<Person> people = new LinkedList<>();
        people.add(new Person(32, "John", "accountant"));
        people.add(new Person(24, "Paul", "musician"));
        people.add(new Person(25, "George", "baker"));

        Map<String, Person> peopleMap = new TreeMap<>();

        System.out.println(people);
    }

    @Override
    public int compareTo(Person person) {
        return Integer.compare(this.age, person.age);
    }
}
