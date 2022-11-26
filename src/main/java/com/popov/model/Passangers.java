package com.popov.model;

public interface Passangers {
    int getPassengersCount();

    default int getPassengersCount2() {
        return 0;
    }

    static int getPassengersCount3() {
        return 0;
    }
}
