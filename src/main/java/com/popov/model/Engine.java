package com.popov.model;

import lombok.Getter;

@Getter
public abstract class Engine {
    private final String type;

    protected Engine(String type) {
        this.type = type;
    }

    public void printType() {
        System.out.println("***" + type + "***");
    }

    public abstract double calculatePower();
}
