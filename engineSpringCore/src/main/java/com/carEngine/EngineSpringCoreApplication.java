package com.carEngine;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class EngineSpringCoreApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(EngineSpringCoreApplication.class, args);
		Car car = context.getBean(Car.class);
		car.drive();
	}

}
