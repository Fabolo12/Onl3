package com.popov.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.Random;
import java.util.UUID;

@Getter
@Setter
@ToString
public class Car implements Passangers {
    private final String id;
    private final Random random = new Random();
    private String manufacturer;
    private OilEngine oilEngine;

    private ElectricEngine electricEngine;
    private Color color;
    private int count;
    private int price;

    public Car() {
        this.id = UUID.randomUUID().toString();
    }

    public Car(String manufacturer, OilEngine oilEngine, Color color) {
        this.id = UUID.randomUUID().toString();
        this.manufacturer = manufacturer;
        this.oilEngine = oilEngine;
        this.color = color;
        this.count = 1;
        this.price = random.nextInt(1_000_000);
    }

    @Override
    public int getPassengersCount() {
        return 4;
    }

    @Override
    public int getPassengersCount2() {
        return 10;
    }
}
