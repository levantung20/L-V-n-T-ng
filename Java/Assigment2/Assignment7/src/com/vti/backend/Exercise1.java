package com.vti.backend;

import java.util.ArrayList;
import java.util.List;

import com.vti.entity.Student;

public class Exercise1 {
	public static void main(String[] args) {

		List<Student> listStudents = new ArrayList<>();
		listStudents.add(new Student(1, "Lê Việt Hà"));
		listStudents.add(new Student(2, "Lê Văn Tùng"));
		listStudents.add(new Student(3, "Đào Thị Thanh Loan"));

		// set trường đại học bách khoa
		Student.setCollege("Đại Học Bách Khoa");

		for (int i = 0; i < 3; i++) {
			System.out.println(listStudents.toString());
			;

		}
		// sét trường đại học công nghệ
		System.out.println("----------------***----------------------");
		Student.setCollege("Đại Học Công nghệ");
		for (int i = 0; i < 3; i++) {
			System.out.println(listStudents.toString());

		}

	}

}