package entity;

public class Student extends Person {
	 public String hometown;
	 public int mark;
	
	public Student(int age, String fullName, String hometown, int mark) {
		super(age, fullName);
		this.hometown = hometown;
		this.mark = mark;
	}

	@Override
	public void anSang() {
		System.out.println("ăn sáng mỳ 5k");
		
	}
}
