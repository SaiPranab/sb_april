package com.jt.hello;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration // It is another way to tell the Spring that some beans are
               // registered within this file
public class AppConfig {
    @Bean
    public Teacher getTeacher() {
        System.out.println("factory method - returns Teacher bean");
        return new Teacher();
    }
}
