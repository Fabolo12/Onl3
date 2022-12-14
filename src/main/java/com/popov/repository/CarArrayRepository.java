package com.popov.repository;

import com.popov.model.Car;
import com.popov.model.Color;

import java.util.Optional;

//    CRUD
//    Create (Save, Insert)
//    Read (getById, getAll)
//    Update
//    Delete
public class CarArrayRepository implements Crud<Car>{ // can be named DAO in same case
    private static Car[] cars = new Car[10];

    private static CarArrayRepository instance;

    private CarArrayRepository() {
    }

    public static CarArrayRepository getInstance() {
        if (instance == null) {
            instance = new CarArrayRepository();
        }
        return instance;
    }

    @Override
    public void save(final Car car) {
        final int index = putCar(car);
        if (index == cars.length) {
            final int oldLength = cars.length;
            increaseArray();
            cars[oldLength] = car;
        }
    }

    @Override
    public Car[] getAll() {
        final int newLength = foundLength();
        final Car[] newCars = new Car[newLength];
        System.arraycopy(cars, 0, newCars, 0, newLength);
        return newCars;
    }

    @Override
    public Optional<Car> getById(final String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return Optional.of(car);
            }
        }
        return Optional.empty();
    }

    @Override
    public void delete(final String id) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index].getId().equals(id)) {
                break;
            }
        }
        if (index != cars.length) {
            System.arraycopy(cars, index + 1, cars, index, cars.length - (index + 1));
        }
    }

    public void insert(int index, final Car car) {
        // TODO: 09/11/22
        // Example: insert(7, Car car);
        // If 7 is not empty -> need to transfer existed values and put new value to 7 index
        // If 7 is empty -> need to check bounds
        // if we have empty cell before index -> use first empty cell insted of
    }

    public void updateColor(final String id, final Color color) {
        getById(id).ifPresent(car -> car.setColor(color));
    }

    private int foundLength() {
        int newLength = 0;
        for (Car car : cars) {
            if (car != null) {
                newLength++;
            } else {
                break;
            }
        }
        return newLength;
    }

    private int putCar(final Car car) {
        int index = 0;
        for (; index < cars.length; index++) {
            if (cars[index] == null) {
                cars[index] = car;
                break;
            }
        }
        return index;
    }

    private void increaseArray() {
        Car[] newCars = new Car[cars.length * 2];
        System.arraycopy(cars, 0, newCars, 0, cars.length);
        cars = newCars;
    }
}
