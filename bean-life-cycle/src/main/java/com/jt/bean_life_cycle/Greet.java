package com.jt.bean_life_cycle;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;

@Component
public class Greet {
    private Greeting greeting;

    public Greet() {
        System.out.println("Greet Object is constructed");
    }

    @Autowired
    public void setGreeting(Greeting greeting) {
        System.out.println("Dependency Injected");
    }

    @PostConstruct
    public void init() {
        System.out.println("init method of Greet class");
    }

    public void sayHello() {
        System.out.println("Hello from Greet");
    }

    @PreDestroy
    public void destroyGreet() {
        System.out.println("Greet Object destroyed");
    }
}
