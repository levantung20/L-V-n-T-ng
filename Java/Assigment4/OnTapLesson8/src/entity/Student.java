package entity;

import java.time.LocalDate;

public class Student implements Comparable<Student> {
	public static int count = 0;
	private int id;
	String name;
//	private LocalDate birthDay;
//	private float point;
	
	public Student(int id, String name) {
		this.id = id;
		this.name = name;
		count ++;
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
	
	@Override
	public String toString() {
		String result = "";
		result += "id: " + id + "\n";
		result += "Name : " + name + "\n";
		return result;
	}

// equals
	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		String NAME = obj.toString();
		if (name.equals(NAME)) {
			return true;
		} else
			return false;
	}

	// CompareTo
	@Override
	public int compareTo(Student student) {
		if (student == null) {
			return -1;
		}
		if (name.equals(student.name) ) {
			return 1;
		} else if(student.name.equals(name)) {
			return -1;
		}else {
			return 0;
		}
	}
}
