package entity;

public class Account {
	private int id;
	private String userName;
	private String fullName;
	private int age;
	
	public Account() {
		
	}
	
	
	public Account(int id, String userName, String fullName, int age) {
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.age = age;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getFullName() {
		return fullName;
	}

	public void setFullName(String fullName) {
		this.fullName = fullName;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {

		return " id " + this.id + " username " +  this.userName + " fullName  " + this.fullName + " age  " + this.age;
	}
}
