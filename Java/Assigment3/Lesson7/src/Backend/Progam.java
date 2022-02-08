package Backend;

import java.util.Scanner;

import Entity.Car;

public class Progam {
	// không có thuộc tính gì ? 
	
	// chỉ có method 
		public static void main(String[] args) {
		

			Car car1 = new Car("Vinfast", "Black", "Lux SA");
			car1.printCar();
			Car car2 = new Car("Toyota", "Bromn", "Vios");
			Car car3 = new Car("Mercedes", "white", "C3000");
			Car car4 = new Car("Mazda", "Red", "Mazda3");
			
			System.out.println(car1.bard + " " + car1.name + " " + car1.color  + " " + car1.getWheelAmount());
		}
		
	
}
