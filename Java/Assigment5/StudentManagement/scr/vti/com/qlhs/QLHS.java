package vti.com.qlhs;

import java.util.ArrayList;
import java.util.List;

import entitye.Student;

public class QLHS {
			public static void main(String[] args) {
				Student student = new Student(1, "Nguyen Minh Anh", "Ha Noi", 10.f);
				Student student2 = new Student(2, "Le Van Tung", "ThaiBinh", 10.f);
				
				List<Student>listStudents = new ArrayList<>();
				listStudents.add(student);
				listStudents.add(student2);
				for (int i = 0; i < listStudents.size(); i++) {
					System.out.println(listStudents.get(i));
					
				}
				
			}

}