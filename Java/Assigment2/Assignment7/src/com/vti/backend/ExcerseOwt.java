package com.vti.backend;

import com.vti.entity.Student2;

public class ExcerseOwt {
	public static void main(String[] args) {

		Student2 student1 = new Student2(1, "Nguyễn Minh Anh");
		Student2 student2 = new Student2(2, "Nguyễn Minh Hiếu");
		Student2 student3 = new Student2(3, "Phạm Yến Thanh");
		
		System.out.println("Tiền quỹ  của lớp là " + Student2.getMoneyGroup());
		
		System.out.println("====================================================");
		System.out.println("Tiền  lần thứ 1  lấy đi 50k để đi mua bánh kẹo về liên hoan");
		student1.layTien(50);
		
		System.out.println("Tiền quỹ còn lại là  " + Student2.getMoneyGroup());
		System.out.println("==================================================");
		System.out.println("Tiền lần thứ 2 lấy đi 20k đi mua thuốc lắc về sập sình  ");
		student2.layTien(20);
		
		System.out.println("Tiền quỹ còn lại là " + Student2.getMoneyGroup());
		System.out.println("================================================");
		System.out.println("Tiền lần thứ 3 lấy đi 150k để đi bay bar");
		student3.layTien(150);
		
		System.out.println("Tiền quỹ còn lại là " + Student2.getMoneyGroup());
		System.out.println(" ====================================================== ");
		
		System.out.println("Cả lớp mỗi người đóng lại cho quỹ 5000k , tổng  là :  " );
		student1.nopTien(5000);
		student2.nopTien(5000);
		student3.nopTien(5000);
		
		System.out.println(Student2.getMoneyGroup());
}
}
