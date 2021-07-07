package com.example.model3;

public class Whale extends Mammal implements Swimmer{

	@Override
	public void swim() {
		System.out.println("swim swim swim");
		
	}

	@Override
	public void dive() {
		System.out.println("Diving");
		
	}
	
}
