package Entity;

public abstract class Vehicle {
	public	String bard;
	public	String color;
	public	String name;
		public Vehicle(String bard, String color, String name) {
			super();
			this.bard = bard;
			this.color = color;
			this.name = name;
		}
		public String getBard() {
			return bard;
		}
		public void setBard(String bard) {
			this.bard = bard;
		}
		public String getColor() {
			return color;
		}
		public void setColor(String color) {
			this.color = color;
		}
		public String getName() {
			return name;
		}
		public void setName(String name) {
			this.name = name;
		}
		
		
}
