package com.popov.model;

public class Person {
    private String name;

    private int age = 0;

    private final double weight;

    public Person(final double weight) {
       this(weight, 18);
    }

    public Person(final double weight, final int age) {
        this.weight = weight;
        this.age = age;
    }

    public void setName(final String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setAge(final int age) {
        if (age < 0) {
            this.age = 18;
        } else {
            this.age = age;
        }
    }

    public int getAge() {
        return age;
    }

    public static void print() {
        System.out.println("Person class");
    }
}
