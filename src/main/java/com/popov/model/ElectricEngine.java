package com.popov.model;

import lombok.Getter;

@Getter
public class ElectricEngine extends OilEngine {
    private final int energy;

    public ElectricEngine(int power, String type,
                          int energy) {
        super(power, type);
        this.energy = energy;
    }

    @Override
    public void display() {
        System.out.println(power + " " + type  + " " + energy);
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
                ", type='" + type + '\'' +
                '}';
    }
}
