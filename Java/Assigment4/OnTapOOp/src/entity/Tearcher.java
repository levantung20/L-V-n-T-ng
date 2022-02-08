package entity;

public class Tearcher extends Person {
		 public String object;
		 public float saraly;

		public Tearcher(int age, String fullName, String object, float saraly) {
			super(age, fullName);
			this.object = object;
			this.saraly = saraly;
		}

		@Override
		public void anSang() {
		System.out.println("ăn sáng phở bò 30k");
			
		}
		


}
