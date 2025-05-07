package com.jt.di;

import org.springframework.stereotype.Component;

@Component
public class Engine {
    public void startEngine() {
        System.out.println("Engine is started");
    }
}
