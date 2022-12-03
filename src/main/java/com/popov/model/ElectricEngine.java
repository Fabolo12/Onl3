package com.popov.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ElectricEngine extends OilEngine {
    private int energy;

    public ElectricEngine() {
    }

    public ElectricEngine(int power, String type,
                          int energy) {
        super(power, type);
        this.energy = energy;
    }

    @Override
    public void display() {
        System.out.println(power + " " + getType()  + " " + energy);
    }

    @Override
    public double calculatePower() {
        return super.calculatePower() * energy;
    }

    @Override
    public String toString() {
        return "ElectricEngine{" +
                "energy=" + energy +
                ", power=" + power +
                ", type='" + getType() + '\'' +
                '}';
    }
}
