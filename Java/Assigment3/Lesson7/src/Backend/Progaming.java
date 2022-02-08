package Backend;

import Entity.Student;

//import java.util.ArrayList;
//import java.util.List;
//import java.util.Scanner;
//
//import Entity.Student;

public class Progaming {
			public static void main(String[] args) {
				// khởi tạo 3 học sinh
				Student[] list = new Student[3];
				 list[0] = new Student(1 , "Lê Thanh Vân");
				 list[1] = new Student(2 , "Lê Văn Tùng");
				 list[2] = new Student(3 , "Lê Việt Hà");
				
				//set trường đại học bách khoa
				Student.setCollege("Đại Học Bách Khoa");
				
				for (int i = 0; i < 3; i++) {
					System.out.println(list[i].toString());

				}
			System.out.println("=========================================");
				// set trường đại học công nghệ
				Student.setCollege("Đại Học Công Nghệ");
				for (int i = 0; i < 3; i++) {
					System.out.println(list[i].toString());
				}
			}
}

	
	
	
	
	
	
	
	
	
	
	
	
	
	
//	public static void main(String[] args) {
//		Student student1 = new Student(1, "Nguyễn Văn A");
//		Student student2 = new Student(2, "Nguyễn Văn B");
//		Student student3 = new Student(3, "Nguyễn Văn C");
//
//		List<Student> listStudents = new ArrayList<>();
//		listStudents.add(student1);
//		listStudents.add(student2);
//		listStudents.add(student3);
//
//		for (Student student : listStudents) {
//			System.out.println(student.id + " " + student.Name + " " + student.college);
//		}
//
//		 
//		for (Student student : listStudents) {
//			student.college = "DH Cong Nghe";
//			System.out.println(student.id + " " + student.Name + " " + student.college);
//		}
//	}


