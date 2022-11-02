package com.popov;

import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

public class Main2 {
    public static void main(String[] args) {
//        copy1();
//        copy2();
//        copy3();
//        copy4();
//        sort();
//        search();
        bubbleSwap();



    }

    private static void bubbleSwap() {
        final Random random = new Random();
        int firstNumber = random.nextInt(100);
        int secondNumber = random.nextInt(100);
        System.out.printf("First number %d, second number %d%n", firstNumber, secondNumber);
        int temp = firstNumber;
        firstNumber = secondNumber;
        secondNumber = temp;
        System.out.printf("First number %d, second number %d%n", firstNumber, secondNumber);
    }

    private static void search() {
        int[] numbers = new int[5];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        final Random random = new Random();
        int number = 0;
        for (int i = 0; i < numbers.length; i++) {
            number = random.nextInt(-100, 100);
            numbers[i] = number;
        }

        System.out.println("After fill - Init array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("After sort - Init array: " + Arrays.toString(numbers));
        final int searchNumber = random.nextInt(-100, 100);
        System.out.println("Search number " + searchNumber);
        final int index1 = Arrays.binarySearch(numbers, searchNumber);
        System.out.println("Index " + index1);

        System.out.println("Search number " + number);
        final int index2 = Arrays.binarySearch(numbers, number);
        System.out.println("Index " + index2);
    }

    private static void sort() {
        int[] numbers = new int[5];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        final Random random = new Random();
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = random.nextInt(-100, 100);
        }

        System.out.println("After fill - Init array: " + Arrays.toString(numbers));
        Arrays.sort(numbers);
        System.out.println("After sort - Init array: " + Arrays.toString(numbers));
    }

    private static void copy4() {
        int[] numbers = new int[3];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        Arrays.fill(numbers, 10);
        System.out.println("After fill - Init array: " + Arrays.toString(numbers));

        int[] newNumbers = Arrays.stream(numbers).toArray();
        System.out.println("After copy - Out array: " + Arrays.toString(newNumbers));
    }

    private static void copy3() {
        int[] numbers = new int[3];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        Arrays.fill(numbers, 10);
        System.out.println("After fill - Init array: " + Arrays.toString(numbers));

        int[] newNumbers = Arrays.copyOf(numbers, numbers.length * 2);
        System.out.println("After copy - Out array: " + Arrays.toString(newNumbers));
    }

    private static void copy2() {
        int[] numbers = new int[3];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        Arrays.fill(numbers, 10);
        System.out.println("After fill - Init array: " + Arrays.toString(numbers));

        int[] newNumbers = new int[numbers.length * 2];
        System.out.println("Before copy - Out array: " + Arrays.toString(newNumbers));
        System.arraycopy(numbers, 0, newNumbers, 1, numbers.length);
        System.out.println("After copy - Out array: " + Arrays.toString(newNumbers));
    }

    private static void copy1() {
        int[] numbers = new int[3];
        System.out.println("Before fill - Init array: " + Arrays.toString(numbers));
        Arrays.fill(numbers, 10);
        System.out.println("After fill - Init array: " + Arrays.toString(numbers));

        int[] newNumbers = new int[numbers.length * 2];
        System.out.println("Before copy - Out array: " + Arrays.toString(newNumbers));
        for (int i = 0; i < numbers.length; i++) {
            newNumbers[i] = numbers[i];
        }
        System.out.println("After copy - Out array: " + Arrays.toString(newNumbers));
    }
}
