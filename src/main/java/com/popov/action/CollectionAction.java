package com.popov.action;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.ListIterator;
import java.util.Map;
import java.util.Random;
import java.util.Set;
import java.util.TreeSet;

public class CollectionAction implements Action {

    @Override
    public void execute() {

    }

    public static void main(String[] args) {
//        iteratorExamples();
//        listExamples();
//        setExamples();
//        compareExample();
//        deleteExample();
        mapExample();
    }

    private static void mapExample() {
        final Map<Dog, Integer> map = new HashMap<>();
        final Dog dog = new Dog();
        System.out.println(dog);
        map.put(dog, dog.getAge());

        System.out.println("Get 1: " + map.get(dog));
        System.out.println(dog.hashCode());

        dog.setWeight(100);
        System.out.println("Get 2: " + map.get(dog));
        System.out.println(dog.hashCode());

        final Iterator<Map.Entry<Dog, Integer>> iterator = map.entrySet().iterator();
    }

    private static void deleteExample() {
        final List<String> strings = new ArrayList<>();
        strings.add("1");
        strings.add("2");
        strings.add("3");
        strings.add("4");
        strings.add("5");
/*        for (String word : strings) {
            if (word.equals("3")) {
                strings.remove(word); // java.util.ConcurrentModificationException
            }
            strings.add("3");// java.util.ConcurrentModificationException
        }*/

        System.out.println("Before fori: " + strings);
        for (int i = 0; i < strings.size(); i++) {
            final String word = strings.get(i);
            if (word.equals("3")) {
                strings.remove(word);
            }
            if (word.equals("1")) {
                strings.add("10");
            }
        }
        System.out.println("After fori: " + strings);

        strings.add("3");
        System.out.println("Before removeIf: " + strings);
        strings.removeIf(word -> word.equals("3"));
        System.out.println("After removeIf: " + strings);

        strings.add("3");
        System.out.println("Before iterator: " + strings);
        final Iterator<String> iterator = strings.iterator();
        while (iterator.hasNext()) {
            final String word = iterator.next();
            if (word.equals("3")) {
                iterator.remove();
            }
            /*if (word.equals("1")) {
                strings.add("10");
            }*/
        }
        System.out.println("After iterator: " + strings);
    }

    private static void wildcardExample() {
        final List<Integer> integers = new ArrayList<>();
        final List<Long> longs = new LinkedList<>();
        final List<String> strings = new ArrayList<>();
        listSum1(integers);
        listSum1(longs);
//        listSum1(strings); compilation error

        listSum2(integers);
        listSum2(longs);
//        listSum2(strings); compilation error
    }

    private static void listSum1(final List<? extends Number> list) {
        int sum = 0;
        for (Number number : list) {
            sum += number.intValue();
        }
        System.out.println("Sum: " + sum);
    }

    private static <T extends Number> void listSum2(final List<T> list) {
        int sum = 0;
        for (Number number : list) {
            sum += number.intValue();
        }
        System.out.println("Sum: " + sum);
    }

    private static void compareExample() {
        final Set<String> treeSet = new TreeSet<>();
        treeSet.add("qwerty");
        treeSet.forEach(word -> {
            System.out.println("TreeSet word: " + word);
        });
        final Set<Cat> catSet = new TreeSet<>();
        catSet.add(new Cat());
        catSet.add(new Cat());
        catSet.forEach(cat -> {
            System.out.println("TreeSet cat: " + cat.getAge());
        });

        final Comparator<Dog> ageComparator = new DogAgeComparator();
        final Comparator<Dog> weightComparator = new Comparator<Dog>() {
            @Override
            public int compare(final Dog o1, final Dog o2) {
                return Integer.compare(o1.getWeight(), o2.getWeight());
            }
        };
        final Comparator<Dog> dogComparator = ageComparator.thenComparing(weightComparator);

        final Set<Dog> dogSet;
        if (new Random().nextBoolean()) {
            dogSet = new TreeSet<>(weightComparator);
        } else {
            dogSet = new TreeSet<>(ageComparator);
        }


        dogSet.add(new Dog());
        dogSet.add(new Dog());
        dogSet.forEach(dog -> {
            System.out.println("TreeSet dog: " + dog.getAge());
        });
    }

    private static void setExamples() {
        final Set<String> hashSet = new HashSet<>();
        hashSet.add("qwerty");
        hashSet.add("dfjkalsdhfjkhas");
        hashSet.add("qwerty");
        hashSet.add("dsjahjklhsdkj");
        hashSet.forEach(word -> {
            System.out.println("HashSet word: " + word);
        });

        final Set<String> linkedHashSet = new LinkedHashSet<>();
        linkedHashSet.add("qwerty");
        linkedHashSet.add("dfjkalsdhfjkhas");
        linkedHashSet.add("qwerty");
        linkedHashSet.add("dsjahjklhsdkj");
        linkedHashSet.add(null);
        linkedHashSet.forEach(word -> {
            System.out.println("LinkedHashSet word: " + word);
        });
    }

    private static void listExamples() {
        final List<Integer> arrayList = new ArrayList<>();
        arrayList.add(1);
        arrayList.add(1);
        arrayList.add(2);
        arrayList.add(3);
        arrayList.forEach(number -> {
            System.out.println("Array number: " + number);
        });
        System.out.println(arrayList.get(2));

        final List<Integer> linkedList = new LinkedList<>();
        linkedList.add(1);
        linkedList.add(1);
        linkedList.add(2);
        linkedList.add(3);
        linkedList.forEach(number -> {
            System.out.println("Linked number: " + number);
        });
        System.out.println(linkedList.get(2));
    }

    private static void iteratorExamples() {
        final Collection<String> collections = new HashSet<>();
        collections.add("1");
        collections.add("2");
        collections.add("3");
        collections.add("4");
        final Iterator<String> iterator = collections.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }

        System.out.println();

        final List<String> list = new ArrayList<>();
        list.addAll(collections);
        final ListIterator<String> listIterator = list.listIterator();
        while (listIterator.hasNext()) {
            System.out.println(listIterator.next());
        }
        while (listIterator.hasPrevious()) {
            System.out.println(listIterator.previous());
        }
    }
}

@Getter
class Cat implements Comparable<Cat> {
    private static final Random RANDOM = new Random();
    private final int age = RANDOM.nextInt(25);

    @Override
    public int compareTo(final Cat o) {
        return Integer.compare(this.getAge(), o.getAge());
    }
}

@Getter
@Setter
@ToString
@EqualsAndHashCode
class Dog {
    private static final Random RANDOM = new Random();
    private final int age = RANDOM.nextInt(25);
    private int weight = RANDOM.nextInt(50);
}

class DogAgeComparator implements Comparator<Dog> {
    @Override
    public int compare(final Dog o1, final Dog o2) {
        return Integer.compare(o1.getAge(), o2.getAge());
    }
}
