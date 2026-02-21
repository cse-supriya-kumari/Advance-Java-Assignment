package com.example.demo;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary

public class Bike implements Vehicle {
	public Bike() {
		System.out.println("Bike has been created");
	}
	@Override
	public void run() {
		System.out.println("Bike is running....");
	}
	

}
