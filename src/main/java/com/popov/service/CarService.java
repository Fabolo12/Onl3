package com.popov.service;

import com.popov.model.Car;
import com.popov.model.Color;
import com.popov.model.ElectricEngine;
import com.popov.model.OilEngine;
import com.popov.repository.CarArrayRepository;

import java.util.Arrays;
import java.util.Random;

public class CarService {
    private final CarArrayRepository carArrayRepository;

    private final Random random = new Random();

    public CarService(final CarArrayRepository carArrayRepository) {
        this.carArrayRepository = carArrayRepository;
    }

    public Car create() {
        final Car car = new Car();
        final OilEngine oilEngine = new OilEngine();
        car.setOilEngine(oilEngine);
        carArrayRepository.save(car);
        return car;
    }

    public Car createElectricCar() {
        final Car car = new Car();
        final ElectricEngine electricEngine = new ElectricEngine(
                10, "VT-10", 220);
        car.setElectricEngine(electricEngine);
        carArrayRepository.save(car);
        return car;
    }

    public void create(final int count) {
        for (int i = 0; i < count; i++) {
            create();
        }
    }

    public void print(final Car car) {
        System.out.println(car);
    }

    public void printAll() {
        final Car[] all = carArrayRepository.getAll();
        System.out.println(Arrays.toString(all));
    }

    public Car[] getAll() {
        return carArrayRepository.getAll();
    }

    public Car find(final String id) {
        if (id == null || id.isEmpty()) {
            return null;
        }
        return carArrayRepository.getById(id);
    }

    public void delete(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        carArrayRepository.delete(id);
    }

    public void changeRandomColor(final String id) {
        if (id == null || id.isEmpty()) {
            return;
        }
        final Car car = find(id);
        if (car == null) {
            return;
        }
        findAndChangeRandomColor(car);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        final Color randomColor = Color.getRandomColor(color);
        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public static void check(final Car car) {
        if (car.getCount() <= 0 || car.getOilEngine().getPower() <= 200) {
            if (car.getCount() <= 0) {
                System.out.println("Incorrect count: " + car.getId());
            }
            if (car.getOilEngine().getPower() <= 200) {
                System.out.println("Incorrect engine's power: " + car.getId());
            }
        } else {
            System.out.println("All fine");
        }
    }

    public int div(final int count) {
        if (count == 0) {
            return 10;
        } else {
            return 10 / count;
        }
    }
}
