package com.vti.backend.Ex4;

import com.vti.Entity.Ex4.Student;

public class Exercise4 {
		public static void main(String[] args) {
		Student student = new Student(1	,"Le Van Tung", "ThaiBinh");
		student.setDiemHocLuc(2.0f);
		System.out.println(student.toString());
		student.setDiemHocLuc(5.0f);
		System.out.println(student.toString());
		student.setDiemHocLuc(7.0f);
		System.out.println(student);
		student.setDiemHocLuc(9.0f);
		System.out.println(student);
			

			
		}
}
