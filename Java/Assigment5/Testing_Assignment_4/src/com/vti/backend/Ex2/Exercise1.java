package com.vti.backend.Ex2;

import java.sql.Date;

import com.vti.Entity.Ex2.Account;


public class Exercise1 {
	
//	 Question2
		public static void main(String[] args) {
			
			
			//khởi tạo hàm câu a
			Account account1 = new Account();
			
			Account account2 = new Account(1, "ltung@gmail.com", "zeding", "Thanh", "Pham");
			
			Account account3 = new Account(2, "thanh@gmail.com", "Lessin", "Tung", "Van", "Dev");
			
			Account account4 = new Account(3, "Tingla@gmail.com", "Barson", "Le", "Nguyen", "TestTer", new Date(2021/10/14));
			
			
			System.out.println(account4.id);
			System.out.println(account4.email);
			System.out.println(account4.userName);
			System.out.println(account4.fullName);
			System.out.println(account4.position);
			System.out.println(account4.createDate);
		}
	//Question3: vẫn đang lỗi chưa fix
//			public static void main(String[] args) {
//				Group groups1 = new Group();
//				
//				Group groups2 = new Group("VTI", "NguyenQuyet", "Demo", newDate(2021/10/04));
//				
//	}

}
