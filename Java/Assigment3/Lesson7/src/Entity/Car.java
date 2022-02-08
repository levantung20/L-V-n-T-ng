package Entity;

public class Car extends Vehicle {
	
	public static int wheelmount = 4;

	public Car(String bard, String color, String name) {
		super(bard, color, name);
	}

	public int getWheelAmount() {
		return wheelmount;
	}

	public void setWheelAmount(int wheelmount) {
		this.wheelmount = wheelmount;
	}
	public void printCar() {
		System.out.println("đây là đối tượng xe hơi ");
	}
	

}
