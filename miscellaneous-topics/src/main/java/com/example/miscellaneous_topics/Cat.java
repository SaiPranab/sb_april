package com.example.miscellaneous_topics;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class Cat implements Animal {

    @Override
    public void eat() {
        System.out.println("Cat eat");
    }

}
