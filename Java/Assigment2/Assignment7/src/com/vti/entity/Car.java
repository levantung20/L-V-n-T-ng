package com.vti.entity;

public class Car extends Vehicle {

	public static int wheelAmount = 4;

	public Car(String brand, String color, String name) {
		super(brand, color, name);
	}

	public int getWheelAmount() {
		return wheelAmount;
	}
	
}
