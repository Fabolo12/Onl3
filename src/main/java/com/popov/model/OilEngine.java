package com.popov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class OilEngine extends Engine {
    protected int power;

    public OilEngine() {
        super("TV-12");
    }

    public OilEngine(int power, String type) {
        super(type);
        this.power = power;
    }

    public void display() {
        System.out.println(power + " " + getType());
    }

    @Override
    public double calculatePower() {
        return power * 5;
    }

    @Override
    public String toString() {
        return "OilEngine{" +
                "power=" + power +
                ", type='" + getType() +
                '}';
    }
}
