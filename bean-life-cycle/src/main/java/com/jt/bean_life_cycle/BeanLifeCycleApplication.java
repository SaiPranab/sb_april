package com.jt.bean_life_cycle;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class BeanLifeCycleApplication {

	public static void main(String[] args) {
		System.out.println("main start");

		System.out.println("SpringContainer starts");
		Greet greet = SpringApplication.run(BeanLifeCycleApplication.class, args).getBean(Greet.class);
		System.out.println("SpringContainer fully prepared");

		greet.sayHello();
		System.out.println("main end");
	}

	/*
	 * Bean instantiation
	 * DI
	 * Initialisation
	 * 
	 * Bean Usage
	 * 
	 * Bean destory
	 */

}
