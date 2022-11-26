package com.popov.model;

public abstract class Engine {
    protected String type;

    protected Engine(String type) {
        this.type = type;
    }

    public void printType() {
        System.out.println("***" + type + "***");
    }

    public abstract double calculatePower();
}
