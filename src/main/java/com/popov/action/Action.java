package com.popov.action;

import com.popov.service.CarService;

public interface Action {

    CarService CAR_SERVICE = CarService.getInstance();

    void execute();
}
