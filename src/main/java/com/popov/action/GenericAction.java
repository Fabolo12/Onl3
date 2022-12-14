package com.popov.action;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

import java.util.Optional;
import java.util.Random;

public class GenericAction implements Action {
    @Override
    public void execute() {
        MyGeneric wrongExample = new MyGeneric("1234");
        final Object value = wrongExample.getValue();

        MyGeneric<String> myGeneric = new MyGeneric<>("1234");
        System.out.println(myGeneric.getValue() + " "
                + myGeneric.getValue().getClass().getSimpleName());
        myGeneric.setValue("4321");
        System.out.println(myGeneric.getValue() + " "
                + myGeneric.getValue().getClass().getSimpleName());

        Pair<String, Integer> pair1 = new Pair<>("qwerty", 12345);
        Pair<Integer, String> pair2 = new Pair<>(12345, "qwerty");
        System.out.printf("Pair1 key: %s value: %d%n",
                pair1.getKey(), pair1.getValue());
        System.out.printf("Pair1 key: %d value: %s%n",
                pair2.getKey(), pair2.getValue());

        StringPair<String> stringPair = new StringPair<>("ytrewq", "qwerty");
        System.out.printf("StringPair key: %s value: %s%n",
                stringPair.getKey(), stringPair.getValue());

        StringIntegerPair stringIntegerPair =
                new StringIntegerPair("qweety", 123345);
        System.out.printf("StringIntegerPair key: %s value: %d%n",
                stringIntegerPair.getKey(), stringIntegerPair.getValue());
        final Integer input1 = stringIntegerPair.print(123);
        System.out.println("Input1: " + input1);
        final String input2 = stringIntegerPair.print("qwerty");
        System.out.println("Input2: " + input2);

        Trio<Double, Integer, Boolean> trio = new Trio<>(1.0, 1, true);
        System.out.printf("Trio element: %f key: %d value: %s%n",
                trio.getElement(), trio.getKey(), trio.getValue());

        Calc calcInt = new Calc();
        calcInt.sum(1.0, 2);
        CalcGeneric<Number> calcGen1 = new CalcGeneric<>();
        calcGen1.sum(1.0, 2);
        CalcGeneric<Integer> calcGen2 = new CalcGeneric<>();
//        calcGen2.sum(1.0, 2); error
        calcGen2.sum(1, 2);

//        calcGen1 = calcGen2; error
        ChildCalcGeneric<Number> childCalcGeneric = new ChildCalcGeneric<>();
        calcGen1 = childCalcGeneric;

        final Optional<Integer> integerOptional = Optional.of(1);
        childCalcGeneric.printType1(integerOptional);
        final Optional<Double> doubleOptional = Optional.of(1.0);
        childCalcGeneric.printType1(doubleOptional);
        System.out.println();

        final Optional<Integer[]> integers = Optional.of(new Integer[]{1});
        childCalcGeneric.printType2(integers);
        final Optional<Double[]> doubles = Optional.of(new Double[]{1.1});
        childCalcGeneric.printType2(doubles);

        Box<Integer> intBox = new Box<>();
        childCalcGeneric.fillOptional(intBox);
        childCalcGeneric.printBox(intBox);

        Box<Double> douBox = new Box<>();
//        childCalcGeneric.fillOptional(douBox); error
        childCalcGeneric.printBox(douBox);

        Box<Number> numBox = new Box<>();
        childCalcGeneric.fillOptional(numBox);
        childCalcGeneric.printBox(numBox);

        Box<Object> objBox = new Box<>();
        childCalcGeneric.fillOptional(objBox);
//        childCalcGeneric.printBox(objBox); error
    }
}

class MyGeneric<V> {
    private V value;

    MyGeneric(final V value) {
        this.value = value;
    }

    V getValue() {
        return value;
    }

    void setValue(final V value) {
        this.value = value;
    }
}

@Getter
@AllArgsConstructor
class Pair<K, V> {
    protected final K key;
    protected final V value;
}

@Getter
class StringPair<V> extends Pair<String, V> {
    StringPair(final String key, final V value) {
        super(key, value);
    }
}

@Getter
class StringIntegerPair extends Pair<String, Integer> {
    StringIntegerPair(final String key, final Integer value) {
        super(key, value);
    }

    public <O> O print(final O input) {
        System.out.println(input);
        return input;
    }
}

@Getter
class Trio<E, K, V> extends Pair<K, V> {
    private final E element;

    Trio(final E element, final K key, final V value) {
        super(key, value);
        this.element = element;
    }
}

class Calc {
    void sum(final Number first, final Number second) {
        double result = first.doubleValue() + second.doubleValue();
        System.out.println("Sum: " + result);
    }
}

class CalcGeneric<T extends Number> {
    void sum(final T first, final T second) {
        double result = first.doubleValue() + second.doubleValue();
        System.out.println("Sum: " + result);
    }
}

class ChildCalcGeneric<T extends Number> extends CalcGeneric<T> {
    <Y extends Number> void printType1(final Optional<Y> optional) {
        final Number number = optional.get();
        System.out.println(number.getClass().getSimpleName());
    }

    void printType2(final Optional<? extends Number[]> optional) {
        for (Number number : optional.get()) {
            System.out.println(number.getClass().getSimpleName());
        }
    }

    void fillOptional(Box<? super Integer> box) {
        final Random random = new Random();
        box.setValue(random.nextInt(100));
    }

    void printBox(Box<? extends Number> box) {
        System.out.println(box.getValue());
    }
}

@Getter
@Setter
class Box<T> {
    private T value;
}
