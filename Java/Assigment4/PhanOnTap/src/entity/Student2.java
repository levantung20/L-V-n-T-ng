package entity;

public abstract class Student2  extends Person{
		int id;
		String name;
		public Student2(String name, int id, String name2) {
			super(name);
			this.id = id;
			name = name2;
		}

		public void setId(int id) {
			this.id = id;
		}

		public void setName(String name) {
			this.name = name;
		}
		
		
}
