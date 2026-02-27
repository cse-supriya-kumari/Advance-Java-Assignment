package com.carEngine;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
public class Car {

	private Engine engine;
	
	@Autowired
	public Car(Engine engine) {
		this.engine = engine;
		System.out.println("Car been created by Spring");

		}
	public void drive() {
		System.out.println("Driving CAr using "+ engine.getEngine());
	}
	
	@PostConstruct
	public void init() {
		System.out.println("Car bean initialized");
	}
	
	public Engine getEngine() {
		return engine;
	}
	public void setEngine(Engine engine) {
		this.engine = engine;
	}
	

}
