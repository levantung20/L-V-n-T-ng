package vti.com.qlhs;

import entitye.Student;

public class Progam {
		public static void main(String[] args) {
			Student student = new Student(1, " Lê Văn Tùng", "Thai Binh", 9.8f);
			student.setDiemHocLuc(5.0f);
			System.out.println(student.toString());
			student.congThemDiemHocLuc(4f);
			System.out.println(student);
			student.dihoc();
		}
}
