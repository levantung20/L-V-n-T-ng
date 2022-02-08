package com.vti.Entity.Ex2;

import java.time.LocalDate;
import java.util.Date;

public class Account {

	public int id;
	public String email;
	public String userName;
	public String fullName;
	public String department;
	public String position;
	public Date createDate;

	// hàm khởi tạo k tham số
	public Account() {
	}

//	b) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName)

	public Account(int id, String email, String userName, String fristName, String lastName) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fristName + lastName;
	};

//	c) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, default createDate = now
	public Account(int id, String email, String userName, String fristName, String lastName, String position) {
		super();
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fristName + lastName;
		this.position = position;
		this.createDate = new Date();
	};

	// d) Có các parameter là id, Email, Username, FirstName,
//	LastName (với FullName = FirstName + LastName) và
//	Position của User, createDate
	public Account(int id, String email, String userName, String fristName, String lastName, String position,
			Date createDate) {
		this.id = id;
		this.email = email;
		this.userName = userName;
		this.fullName = fristName + lastName;
		this.position = position;
		this.createDate = createDate;
	};

}