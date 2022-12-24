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
    private Engine engine;
    private Color color;
    private int count;
    private int price;

    private Type type;

    public Car() {
        this.id = UUID.randomUUID().toString();
    }

    public Car(String manufacturer, Engine engine, Color color) {
        this.id = UUID.randomUUID().toString();
        this.manufacturer = manufacturer;
        this.engine = engine;
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
