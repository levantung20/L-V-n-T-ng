package Entity;

public class Student2 {
	private int id;
	private String Name;
	private static String college;
	private static int monenyGroup;

	public Student2(int id, String name) {
		this.id = id;
		this.Name = name;
		this.monenyGroup += 100;
	}

	public void nopTien(int amount) {
		this.monenyGroup += amount;
	}

	public void layTien(int amount) {
		this.monenyGroup -= amount;
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
		Student2.college = college;
	}
	

	public static int getMonenyGroup() {
		return monenyGroup;
	}

	public static void setMonenyGroup(int monenyGroup) {
		Student2.monenyGroup = monenyGroup;
	}

	@Override
	public String toString() {
		return "id:  " + this.id + ", Name:  " + this.Name + ", College:  " + this.college;
	}
}
