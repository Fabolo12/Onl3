package com.popov;

import lombok.EqualsAndHashCode;

import java.util.Objects;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
        final Parent parent = new Parent();
        parent.print();

        final Children1 children1 = new Children1();
        children1.print();
        children1.test();

        final Parent parent1 = new Children1();
        parent1.print();
//        parent1.test();
        if (parent1 instanceof Children1) {
            Children1 children11 = (Children1) parent1;
            children11.test();
        }

        if (parent1 instanceof Children1 children11) {
            children11.test();
        }


        ParentInterface parentInterface = new Children1();

        System.out.println("~".repeat(10));

        Parent[] parents = new Parent[5];
        parents[0] = new Parent();
        parents[1] = new Children1();
        parents[2] = new Children2();
        parents[3] = new Children1();
        parents[4] = new Parent();
        for (Parent p : parents) {
            p.print();
        }

        System.out.println("~".repeat(10));

        for (int i = 0; i < 10; i++) {
            createRandomClass().print();
        }

        System.out.println(parents.hashCode());
        System.out.println(parents.hashCode());


    }

    private static Parent createRandomClass() {
        final Random random = new Random();
        final int anInt = random.nextInt(12);
        if (anInt <= 4) {
            return new Parent();
        } else if (anInt <= 8) {
            return new Children1();
        } else {
            return new Children2();
        }
    }
}

interface ParentInterface {

}

class Parent {
    private String id;
    private String color;

    protected void print() {
        System.out.println("Class Parent");
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Parent parent = (Parent) o;
        return Objects.equals(id, parent.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }
}

class Children1 extends Parent implements ParentInterface {
    @Override
    protected void print() {
        System.out.println("Class Children1");
    }

    public void test() {
        System.out.println("TEST");
    }
}
class Children2 extends Parent {
}

