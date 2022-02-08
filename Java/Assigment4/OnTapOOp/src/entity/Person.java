package entity;

public abstract class Person {
		int age;
		String fullName;
		
		public Person(int age, String fullName) {
			super();
			this.age = age;
			this.fullName = fullName;
		}
		public void diemDanh() {
			System.out.println("Quet van tay de diem danh ");
		}
		public abstract void anSang();
		
		@Override
		public String toString() {
		return   "Person{" + " age= " + age +  "  fullName =  " + fullName + '\'' + '}';
		
		}
}
