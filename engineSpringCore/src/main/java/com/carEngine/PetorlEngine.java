package com.carEngine;

import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

import jakarta.annotation.PostConstruct;

@Component
@Primary
public class PetorlEngine  implements Engine{
	public PetorlEngine() {
		System.out.println("Petrol Engine bean created");
	}
	@Override
	public String getEngine() {
		return "Petrol Engine";
	}
	

}
