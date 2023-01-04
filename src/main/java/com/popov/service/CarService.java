package com.popov.service;

import com.popov.model.Car;
import com.popov.model.Color;
import com.popov.model.ElectricEngine;
import com.popov.model.Engine;
import com.popov.model.OilEngine;
import com.popov.repository.CarArrayRepository;
import com.popov.repository.CarListRepository;
import com.popov.repository.Crud;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class CarService {
    private final Crud<Car> carArrayRepository;

    private final Random random = new Random();

    private static CarService instance;

    private CarService(final Crud<Car> repository) {
        this.carArrayRepository = repository;
    }

    public static CarService getInstance() {
        if (instance == null) {
            instance = new CarService(CarListRepository.getInstance());
        }
        return instance;
    }

    public static CarService getInstance(final Crud<Car> repository) {
        if (instance == null) {
            instance = new CarService(repository);
        }
        return instance;
    }

    public Car create() {
        final Car car = new Car();
        final Engine engine = new OilEngine(
                100, "OIL");
        car.setEngine(engine);
        carArrayRepository.save(car);
        return car;
    }

    public Car createElectricCar() {
        final Car car = new Car();
        final Engine engine = new ElectricEngine(
                10, "Electric", 220);
        car.setEngine(engine);
        carArrayRepository.save(car);
        return car;
    }

    public void create(final int count) {
        for (int i = 0; i < count; i++) {
            if (random.nextBoolean()) {
                create();
            } else {
                createElectricCar();
            }
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

    public Optional<Car> find(final String id) {
        if (id == null || id.isEmpty()) {
            return Optional.empty();
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
        find(id).ifPresent(this::findAndChangeRandomColor);
    }

    private void findAndChangeRandomColor(final Car car) {
        final Color color = car.getColor();
        final Color randomColor = Color.getRandomColor(color);
//        carArrayRepository.updateColor(car.getId(), randomColor);
    }

    public static void check(final Car car) {
        if (car.getEngine() instanceof ElectricEngine) {
            System.out.println("Electric engine can't check :(");
        } else if (car.getEngine() instanceof OilEngine engine) {
            if (car.getCount() <= 0 || engine.getPower() <= 200) {
                if (car.getCount() <= 0) {
                    System.out.println("Incorrect count: " + car.getId());
                }
                if (engine.getPower() <= 200) {
                    System.out.println("Incorrect engine's power: " + car.getId());
                }
            } else {
                System.out.println("All fine");
            }
        }
    }

    public int div(final int count) {
        if (count == 0) {
            return 10;
        } else {
            return 10 / count;
        }
    }

    public Optional<Engine> createEngine(final String type) {
        if (type.equals("oil")) {
            final OilEngine oilEngine = new OilEngine();
            oilEngine.setPower(100);
            // TODO set fields
            return Optional.of(oilEngine);
        } else if (type.equals("electro")) {
            final ElectricEngine electricEngine = new ElectricEngine();
            electricEngine.setEnergy(100);
            // TODO set fields
            return Optional.of(electricEngine);
        }
        return Optional.empty();
    }

    public Engine createDefaultEngine() {
        final ElectricEngine electricEngine = new ElectricEngine();
        electricEngine.setEnergy(100);
        // TODO set fields
        return electricEngine;
    }

    public int compareCar(final Car first, final Car second) {
        return first.getId().compareTo(second.getId());
    }
}
