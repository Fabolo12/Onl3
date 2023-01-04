package com.popov.action;

import lombok.Getter;
import lombok.Setter;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Collectors;
import java.util.stream.Stream;

@FunctionalInterface
interface MyPredicate<T> {
    static boolean test2(Object value) {
        return value != null;
    }

    boolean test(T value);

    default boolean test1(T value) {
        return value != null;
    }

    String toString();
}

public class StreamAction {

    private static int amount2 = 100;

    public static void main(String[] args) {
        /*final Consumer<String> stringConsumer = a -> System.out.println(a);
        final Consumer<String> stringConsumer1 = a -> {
            if (a.isEmpty()) {
                System.out.println("Incorrect");
                return;
            }
            System.out.println(a);
        };
        stringConsumer1.accept("");

        Predicate<String> isEmptyString1 = a -> a.isEmpty();
        Predicate<String> isEmptyString2 = String::isEmpty;

        if ("".isEmpty()) {
            System.out.println("Incorrect");
        }

        if (isEmptyString1.test("")) {
            System.out.println("Incorrect");
        }

        final IntBinaryOperator intBinaryOperator1 = (int a, int b) -> {
            System.out.println("a: " + a);
            System.out.println("b: " + b);
            return a + b;
        };

        final IntBinaryOperator intBinaryOperator2 = (int a, int b) -> a + b;

        System.out.println(intBinaryOperator1.applyAsInt(3, 10));

        stringConsumer.accept("13 qwerty");*/

       /* final Consumer<Object> consumer1 =
                (Object obj) -> System.out.println("*" + obj + "*");
        consumer1.accept("TEST 1");

        final Consumer<Object> consumer2 = System.out::println;
        consumer2.accept("TEST 2");*/

        /*System.out.println(simpleWay("    QWertY   "));
        System.out.println(lambdaWay("    QWertY 2   "));*/

        /*Predicate<String> isEmptyString1 = a -> a.isEmpty();
        isEmptyString1.test("");

        final MyChecker myChecker = new MyChecker();
        myChecker.test("");

        MyPredicate<String> myPredicate1 = new MyPredicate<>() {
            @Override
            public boolean test(final String value) {
                return value.isEmpty();
            }
        };
        myPredicate1.test("");

        MyPredicate<String> myPredicate2 = value -> value.isEmpty();
        myPredicate2.test("");

        MyPredicate<String> myPredicate3 = String::isEmpty;
        myPredicate3.test("");*/

        /*final int amount = 100;

        MyPredicate<Integer> myPredicate1 = a -> a > amount;
        MyPredicate<Integer> myPredicate2 = a -> a > amount2;

        System.out.println(myPredicate2.test(100));
        amount2 = 101;*/

        /*Supplier<Integer> supplier1 = () -> 5;
        supplierExample(supplier1);
        Supplier<String> supplier2 = () -> "TESTING";
        supplierExample(supplier2);*/

       /* Predicate<String> predicate1 = String::isEmpty;
        predicateExample(predicate1);
        Predicate<Integer> predicate2 = value -> value > 0;
//        predicateExample(predicate2);
        Predicate<String> predicate3 = value -> value.length() > 1;
        predicateExample(predicate3);*/

        /*List<Integer> list = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        List<Integer> listResult1 = new ArrayList<>();

        for (Integer integer : list) {
            if (integer >= 5) {
                listResult1.add(integer);
            }
        }
        System.out.println(listResult1);

        final List<Integer> listResult2 = list.stream()
                .filter(i -> i >= 5)
                .collect(Collectors.toList());
        System.out.println(listResult2);
        System.out.println(list);

        Predicate<Integer> predicate = a -> a >= 5;
        final List<Integer> listResult3 = list.stream()
                .filter(predicate)
                .collect(Collectors.toList());
        System.out.println(listResult3);

        list.stream()
                .filter(s -> s >= 5)
                .peek(System.out::println)
                .collect(Collectors.toList());*/

        final BoxTest box1 = new BoxTest();
        List<Integer> list1 = Arrays.asList(1, 2, 3, 4, 5, 6, 7, 8, 9);
        box1.setSize(list1);

        final BoxTest box2 = new BoxTest();
        List<Integer> list2 = Arrays.asList(10, 20, 30, 40, 50, 60, 70, 80, 90);
        box2.setName("T");
        box2.setSize(list2);

        final BoxTest box3 = new BoxTest();
        List<Integer> list3 = Arrays.asList(-1, -2, -3, -4, -5, -6, -7, -8, -9);
        box3.setName("Q");
        box3.setSize(list3);

        final List<BoxTest> boxes = Arrays.asList(box1, box2, box3);
        final Stream<Integer> integerStream = boxes.stream()
                .flatMap(box -> box.getSize().stream());

        final List<Integer> collect = integerStream.collect(Collectors.toList());

        final Stream<List<Integer>> listStream = boxes.stream()
                .map(box -> box.getSize());

        final Stream<Stream<Integer>> streamStream = boxes.stream()
                .map(box -> box.getSize().stream());

        final Stream<String> stringStream = boxes.stream()
                .map(box -> box.getName());

        Function.identity();

        boxes.stream()
                .filter(box -> box.getName() != null)
                .flatMap(box -> box.getSize().stream())
                .filter(size -> size % 2 == 0)
                .forEach(System.out::println);
    }

    private static void supplierExample(final Supplier<?> supplier) {
        System.out.println("supplier " + supplier.get());
    }

    private static void predicateExample(final Predicate<String> predicate) {
        String lineForTest = "word";
        System.out.println("predicate " + predicate.test(lineForTest));
    }

    public static String simpleWay(final String string) {
        final String trim = string.trim();
        final String lowerCase = trim.toLowerCase();
        final StringBuilder stringBuilder = new StringBuilder(lowerCase);
        final StringBuilder reverse = stringBuilder.reverse();
        final String result = reverse.toString();
        return result;
    }

    public Function<String, String> map = word -> "***" + word.toUpperCase() + "***";

    public String listExample(final List<Integer> list) {
        return list.stream()
                .filter(Objects::nonNull)
                .filter(integer -> integer >= 10)
                .distinct()
                .sorted(Integer::compare)
                .limit(5)
                .map(integer -> "***" + integer + "***")
                .collect(Collectors.joining(","));
    }

    public String lambdaWay(final String string) {
        Function<String, String> function = String::trim;
        final String result = function.andThen(String::toLowerCase)
                .andThen(StringBuilder::new)
                .andThen(StringBuilder::reverse)
                .andThen(StringBuilder::toString)
                .apply(string);
        return result;
    }
}

class MyChecker implements MyPredicate<String> {
    @Override
    public boolean test(final String value) {
        return value.isEmpty();
    }
}


@Getter
@Setter
class BoxTest {
    private List<Integer> size;

    private String name;
}

