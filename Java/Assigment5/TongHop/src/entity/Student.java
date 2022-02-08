package entity;

public class Student {
	int id;
	String name;
	int age;
	int soTay;
	int soChan;

	public Student(int id, String name, int age, int soTay, int soChan) {
		super();
		this.id = id;
		this.name = name;
		this.age = age;
		this.soTay = soTay;
		this.soChan = soChan;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getSoTay() {
		return soTay;
	}

	public void setSoTay(int soTay) {
		this.soTay = soTay;
	}

	public int getSoChan() {
		return soChan;
	}

	public void setSoChan(int soChan) {
		this.soChan = soChan;
	}

	@Override
	public String toString() {
		return " id " + this.id + " name " + this.name + " age " + this.age + " so tay " + this.soTay + " so chan "
				+ this.soChan;
	}
}
