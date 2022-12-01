package com.popov;

import com.popov.model.Car;
import com.popov.model.ElectricEngine;
import com.popov.model.Engine;
import com.popov.model.OilEngine;
import com.popov.model.Passangers;
import com.popov.repository.CarArrayRepository;
import com.popov.service.CarService;
import lombok.Getter;

import java.util.Arrays;
import java.util.concurrent.locks.Lock;

public class Main {
    public static void main(final String[] args) throws CloneNotSupportedException {
        final CarService carService =
                new CarService(new CarArrayRepository());
/*

        final Car electricCar = carService.createElectricCar();
        System.out.println(electricCar);
        final OilEngine oilEngine = new OilEngine(12, "VT-10");
        final ElectricEngine electricEngine = new ElectricEngine(
                12, "VT-10", 220);
        oilEngine.display();
        electricEngine.display();

        System.out.println(oilEngine.calculatePower());
        System.out.println(electricEngine.calculatePower());

        oilEngine.printType();
        electricEngine.printType();

        final Passangers passangers = new Passangers() {
            @Override
            public int getPassengersCount() {
                return 100;
            }
        };

        System.out.println(passangers.getPassengersCount());

        final PassangersIml passangersIml = new PassangersIml();
        System.out.println(passangersIml.getPassengersCount());
*/

        carService.create(10);
        final Car[] all = carService.getAll();
        for (Car car : all) {
            System.out.println(car.getEngine().getType());
            CarService.check(car);
        }
    }
}

class PassangersIml implements Passangers {
    @Override
    public int getPassengersCount() {
        return 100;
    }
}
