package entity;

public class Person {
		int msv;
		String firstName;
		String Adders;
		int age;
		public Person(int msv, String firstName, String adders, int age) {
			this.msv = msv;
			this.firstName = firstName;
			Adders = adders;
			this.age = age;
		}
		public int getMsv() {
			return msv;
		}
		public void setMsv(int msv) {
			this.msv = msv;
		}
		public String getFirstName() {
			return firstName;
		}
		public void setFirstName(String firstName) {
			this.firstName = firstName;
		}
		public String getAdders() {
			return Adders;
		}
		public void setAdders(String adders) {
			Adders = adders;
		}
		public int getAge() {
			return age;
		}
		public void setAge(int age) {
			this.age = age;
		}
		@Override
		public String toString() {
			return " msv " + this.msv + " firstName " + this.firstName + " adders " + this.Adders + " age "+ this.age;
		}
		
}
