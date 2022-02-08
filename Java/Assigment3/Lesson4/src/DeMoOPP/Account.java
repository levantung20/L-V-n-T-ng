package DeMoOPP;

import java.time.LocalDate;

public class Account {
	private int id;
	private String userName;
	private String fullName;
	private String email;
	private LocalDate createDate;
	private String diaChi;
	
	//  đây là constructor rỗng k tham số 
	public Account() {}
	
	public Account(int id, String userName, String fullName, String email, LocalDate createDate) {
		
		this.id = id;
		this.userName = userName;
		this.fullName = fullName;
		this.email = email;
		this.createDate = createDate;
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
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public LocalDate getCreateDate() {
		return createDate;
	}
	public void setCreateDate(LocalDate createDate) {
		this.createDate = createDate;
	}
	@Override
	public String toString() {
		return  " id " + this.id + " full Name " + this.fullName +  " email " + this.email + "username " + this.userName
				 + " createDate " + this.createDate;
	}
}
