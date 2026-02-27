package com.carEngine;

import org.springframework.stereotype.Component;

@Component
public class DieselEngine implements Engine {
	public DieselEngine() {
		System.out.println("Disele Engine bean Created");
	}
	
	@Override
	public String getEngine() {
		return "Diesele Engine";
		
	}

}
