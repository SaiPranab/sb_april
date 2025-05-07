package com.jt.hello;

import org.springframework.stereotype.Component;

@Component
public class Person {
    public void sayHello() {
        System.out.println("Person Says Hello");
    }
}
