package com.jt.di;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Car {
    // field based injection
    // @Autowired
    private Engine engine;

    // setter absed injection
    // @Autowired
    // public void setEngine(Engine engine) {
    // System.out.println("Setter method called - DI");
    // this.engine = engine;
    // }

    // constructor based injection
    @Autowired
    public Car(Engine engine) {
        System.out.println("Constructor is called - DI");
        this.engine = engine;
    }

    public Car() {
    }

    public void runCar() {
        engine.startEngine();
        System.out.println("Car is running");
    }
}
