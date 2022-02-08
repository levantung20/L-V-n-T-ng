package com.vti.backend;

import com.vti.entity.Car;

public class Program {
		public static void main(String[] args) {
			Car car1 = new Car("VinFast", "red", "BMW");
			Car car2 = new Car("Toyota", "Brown", "Lux SA");
			Car car3 = new Car("Mercedes", "white", "C300");
			Car car4 = new Car("Mazda", "Black", ",Mazda3");
			
			
			System.out.println(car1.brand + " | " + car1.color + " | " + car1.name + " | " + car1.wheelAmount);
			
			
			
//			System.out.println(car1.getWheelAmount());
//			System.out.println(car2.getWheelAmount());
//			System.out.println(car3.getWheelAmount());
//			System.out.println(car4.getWheelAmount());
//			
		}
		
}
