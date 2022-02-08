package com.vti.backend.Ex6;

import java.util.Scanner;

import com.vti.Entity.Ex6.Phone;
import com.vti.Entity.Ex6.VietNamsePhone;

public class Exerci6 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		VietNamsePhone vnPhone = new VietNamsePhone();
		while(true) {
		System.out.println("=========");
		System.out.println("1. them danh ba");
		System.out.println("2.xoa danh ba ");
		System.out.println("3. sua danh ba");
		System.out.println("4.tim kiem danh ba");
		System.out.println("5.show");
		System.out.println("6.Thoat chuong trinh");
		int menuChoose = sc.nextInt();
		
		switch (menuChoose) {
		case 1: 
			System.out.println("nhập vào tên");
			String name = sc.next();
			System.out.println("nhập vào số phone : ");
			String phone = sc.next();
			vnPhone.insertContact(name, phone);
			break;
		case 2 :
			System.out.println("Nhập vào tên cần remove : ");
			
			String removeName = sc.next();
			vnPhone.removeContact(removeName);
			break;
			
		case 3 : 
			System.out.println("nhập tên cần sửa");
			String name1 = sc.next();
			System.out.println("nhập số phone mới : ");
			String newPhone = sc.next();
			vnPhone.updateContact(name1, newPhone);
			System.out.println("Kết quả : ");
			vnPhone.searchContact(name1);
			break;
		case 4 : 
			System.out.println(" nhập vào tên cần tìm");
			String searchName = sc.next();
			vnPhone.searchContact(searchName);
			break;
			
		case 5 : 
			vnPhone.printContact();
			break;
		case 6 : 
			System.out.println("Bạn đã thoát danh bạ!!!Xin Cảm ơn");
		default:
			break;
		}
	}
}
}