package com.popov.action;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

class StreamActionTest {

    private StreamAction target;

    @BeforeEach
    void setUp() {
        target = new StreamAction();
    }

    @Test
    void lambdaWay() {
        final String word = "  lINe  ";
        final String result = target.lambdaWay(word);
        final String expected = "enil";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void mapTest() {
        final String word = "line";
        final String result = target.map.apply(word);
        final String expected = "***LINE***";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void listExampleTest() {
        List<Integer> list = new ArrayList<>();
        list.add(null);
        list.add(30);
        list.add(2);
        list.add(30);
        list.add(10);
        list.add(4);
        list.add(5);
        list.add(79);
        list.add(7);
        list.add(71);
        list.add(78);
        list.add(60);
        final String result = target.listExample(list);
        final String expected = "***10***,***30***,***60***,***71***,***78***";
        Assertions.assertEquals(expected, result);
    }

    @Test
    void simpleWayTest() {
        final String word = "  lINe  ";
        final String result = StreamAction.simpleWay(word);
        final String expected = "enil";
        Assertions.assertEquals(expected, result);
    }
}