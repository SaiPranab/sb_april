package com.jt.bean_life_cycle;

import org.springframework.stereotype.Component;

import jakarta.annotation.PreDestroy;

@Component
public class Greeting {
    public Greeting() {
        System.out.println("Greeting Object is constructed");
    }

    @PreDestroy
    public void destroyGreeting() {
        System.out.println("Greeting Object destroyed");
    }
}
