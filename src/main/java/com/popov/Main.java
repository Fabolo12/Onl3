package com.popov;

import com.popov.model.Car;
import com.popov.repository.CarArrayRepository;
import com.popov.service.CarService;

public class Main {
    public static void main(final String[] args) {
        final CarService carService = new CarService(new CarArrayRepository());
        for (int i = 0; i < 3; i++) {
            final Car car = carService.create();
            carService.print(car);
            CarService.check(car);
        }


        /*final Car car1 = carService.create();
        carService.printAll();

        System.out.println(carService.find(car1.getId()));

        carService.create(3);
        carService.printAll();

        carService.delete(car1.getId());
        carService.printAll();

        final Car[] all = carService.getAll();
        final Car car = all[0];
        carService.changeRandomColor(car.getId());
        System.out.println(carService.find(car.getId()));*/

    }
}
