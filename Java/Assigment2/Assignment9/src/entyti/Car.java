package entyti;

public class Car {
	private String name;
	private String type;
	public Car(String name, String type) {
		super();
		this.name = name;
		this.type = type;
	}
	public static class Engine {
		String engineType;
		public Engine(String engineType) {
			super();
			this.engineType = engineType;
		}
		public String getEngineType() {
			return engineType;
		}
		public void setEngineType(String engineType) {
			this.engineType = engineType;
		}
	}
}
