package com.thomas.model;

public class Simulation {
	public static void main(String[] args) {
		FlyingVehicle fv = new FlyingVehicle((short)4, new Engine());
		
		fv.setName("A new flying vehicle");
		System.out.println(fv.getName());
		
		Airplane boeing = new Airplane((short)4,(short)5);
		boeing.move(15);
	}
}
