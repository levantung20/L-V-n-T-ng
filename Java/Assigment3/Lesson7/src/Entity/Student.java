package Entity;

public class Student {
	private int id;
	private	String Name;
	private	static String college ;
	
	public Student(int id, String name) {
		this.id = id;
		Name = name;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return Name;
	}

	public void setName(String name) {
		Name = name;
	}

	public static String getCollege() {
		return college;
	}

	public static void setCollege(String college) {
		Student.college = college;
	}
	
	@Override
	public String toString() {
		return  "id:  " + this.id +  ", Name:  "  + this.Name +  ", College:  "  + this.college;
	}
}
	
