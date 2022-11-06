package com.popov;

import com.popov.model.Person;

public class Main {
    public static void main(final String[] args) {
        final Person person = new Person(0.6);
        person.setName("John");
        person.setAge(25);
        System.out.println(person.getName() + " " + person.getAge());
    }
}
