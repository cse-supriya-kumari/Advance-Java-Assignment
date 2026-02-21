package com.example.demo;

import org.springframework.beans.factory.BeanFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class DemoSpringApplication {

	public static void main(String[] args) {
//		SpringApplication.run(DemoSpringApplication.class, args);
//		System.out.println("Hello World");
//		Car car = new Car();
		
		
//		BeanFactory factory = SpringApplication.run(DemoSpringApplication.class,args);
//		Vehicle vehile = factory.getBean("car",Vehicle.class);
//		vehile.run();
//		
		
		
		BeanFactory factory = SpringApplication.run(DemoSpringApplication.class,args);
		Vehicle vehile = factory.getBean("auto",Vehicle.class);
		vehile.run();
		
		
//		ApplicationContext context = SpringApplication.run(DemoSpringApplication.class,args);
//		Car car1 = context.getBean(Car.class);
//		Car car2 = context.getBean(Car.class);
//		System.out.println(car1);
//		System.out.println(car2);
		
//		ApplicationContext context = SpringApplication.run(DemoSpringApplication.class,args);
//		Vehicle v = context.getBean(Vehicle.class);
//	//	Vehicle v = context.getBean(Bike.class);
//		v.run();
//		
		
	}

}
