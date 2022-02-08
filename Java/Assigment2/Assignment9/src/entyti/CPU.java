package entyti;

public class CPU {
	private float price;
	public static class Processor {
		float coreAmount;
		String menufacturer;	
		public float getCache() {
			return 4.3f;
		}	
		public Processor(float coreAmount, String menufacturer) {
			super();
			this.coreAmount = coreAmount;
			this.menufacturer = menufacturer;
		}

		// get, set
		public float getCoreAmount() {
			return coreAmount;
		}

		public void setCoreAmount(float coreAmount) {
			this.coreAmount = coreAmount;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}
	}

	
	public static class Ram {
		String memory;
		String menufacturer;

		
		public float getClockSpeed() {
			return 5.5f;
		}

		// create
		public Ram(String memory, String menufacturer) {
			super();
			this.memory = memory;
			this.menufacturer = menufacturer;
		}
		public String getMemory() {
			return memory;
		}

		public void setMemory(String memory) {
			this.memory = memory;
		}

		public String getMenufacturer() {
			return menufacturer;
		}

		public void setMenufacturer(String menufacturer) {
			this.menufacturer = menufacturer;
		}
	}
}

