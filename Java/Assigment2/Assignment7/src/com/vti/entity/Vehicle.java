package com.vti.entity;

public abstract class Vehicle {
	public String brand;
	public String color;
	public String name;

	public Vehicle(String brand, String color, String name) {
		this.brand = brand;
		this.color = color;
		this.name = name;
	}

	public String getBrand() {
		return brand;
	}

	public String getColor() {
		return color;
	}

	public String getName() {
		return name;
	}

}
