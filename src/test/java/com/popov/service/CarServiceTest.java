package com.popov.service;

import com.popov.model.Car;
import com.popov.repository.CarArrayRepository;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;


class CarServiceTest {
    private CarService target;
    private CarArrayRepository repository;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(CarArrayRepository.class);
        target = new CarService(repository);
    }

    @Test
    void createTest() {
        // initialize

        // action
        final Car car = target.create();

        // checks
        Assertions.assertNotNull(car);
        Assertions.assertNotNull(car.getId());
    }

    @Test
    void printAll() {
        // initialize

        // action

        // checks
        Assertions.assertDoesNotThrow(() -> target.printAll());
    }

    @Test
    void findIdIncorrectNullId() {
        // initialize
        String id = null;

        // action
        final Car car = target.find(id);

        // checks
        Assertions.assertNull(car);
    }

    @Test
    void findIdIncorrectEmptyId() {
        // initialize
        String id = "";

        // action
        final Car car = target.find(id);

        // checks
        Assertions.assertNull(car);
    }

    @Test
    void findNotFound() {
        // initialize
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(null);

        // action
        final Car car = target.find(id);

        // checks
        Assertions.assertNull(car);
    }

    @Test
    void find() {
        // initialize
        final Car expected = new Car();
        String id = "123";
        Mockito.when(repository.getById("123")).thenReturn(expected);

        // action
        final Car actual = target.find(id);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void div() {
        // initialize
        int count = 10;
        int expected = 1;

        // action
        final int actual = target.div(count);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void divZero() {
        // initialize
        int count = 0;
        int expected = 10;

        // action
        final int actual = target.div(count);

        // checks
        Assertions.assertEquals(expected, actual);
    }

    @Test
    void deleteIdNull() {
        // initialize

        // action
        target.delete(null);

        // checks
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void deleteIdEmpty() {
        // initialize

        // action
        target.delete("");

        // checks
        Mockito.verify(repository, Mockito.never()).delete(Mockito.anyString());
    }

    @Test
    void delete() {
        // initialize
        final String id = "123";

        // action
        target.delete(id);

        // checks
        Mockito.verify(repository).delete(id);
    }
}